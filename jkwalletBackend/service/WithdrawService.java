package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import constants.ApiResponse;
import model.ABCBank;
import model.CreateUser;
import model.XYZBank;
import repository.CreateABCAccountRepository;
import repository.CreateUserRepository;
import repository.CreateXYZAccountRepository;
@Service
public class WithdrawService {
	
	@Autowired
	CreateUserRepository createUserRepository;
	
	@Autowired
	CreateABCAccountRepository abcAccountRepository;
	
	@Autowired
	CreateXYZAccountRepository xyzAccountRepository;
	
	
	public CreateUser getWithdrawUser(String email) {
		CreateUser payingUser=createUserRepository.findByEmail(email).orElse(new CreateUser());
		return payingUser;
	}


	public ABCBank getABCBankReceivingUser(String mobileNumber) {
		ABCBank abcBank=abcAccountRepository.findByMobileNumber(mobileNumber).orElse(new ABCBank());
		return abcBank;
	}
	
	public XYZBank getXYZBankReceivingUser(String mobileNumber) {
		XYZBank xyzBank=xyzAccountRepository.findByMobileNumber(mobileNumber).orElse(new XYZBank());
		return xyzBank;
	}
	
	
	public ResponseEntity withdrawMoney(String email,String bankName,String amountTowithdraw) {
		try {
		
		CreateUser withdrawUser=createUserRepository.findByEmail(email).orElse(new CreateUser());
		Long walletBalance=withdrawUser.getWalletBalance();
		Long amountTowithdrawLong=Long.valueOf(amountTowithdraw);
		String withdrawUserMobileNumber=withdrawUser.getMobileNumber();
		
		if(bankName.equals("ABC") && walletBalance>=amountTowithdrawLong) {
			ABCBank abcBankUser=getABCBankReceivingUser(withdrawUserMobileNumber);
			Long currentBankBalance=abcBankUser.getBalance();
			walletBalance-=amountTowithdrawLong;
			currentBankBalance+=amountTowithdrawLong;
			withdrawUser.setWalletBalance(walletBalance);
			abcBankUser.setBalance(currentBankBalance);
			createUserRepository.save(withdrawUser);
			abcAccountRepository.save(abcBankUser);
			return new ResponseEntity(new ApiResponse(true,"Transaction Successfull"),HttpStatus.OK);
		}
		
		else if(bankName.equals("XYZ")&& walletBalance>=amountTowithdrawLong) {
			XYZBank xyzBankUser=getXYZBankReceivingUser(withdrawUserMobileNumber);
			Long currentBankBalance=xyzBankUser.getBalance();
			walletBalance-=amountTowithdrawLong;
			currentBankBalance+=amountTowithdrawLong;
			withdrawUser.setWalletBalance(walletBalance);
			xyzBankUser.setBalance(currentBankBalance);
			createUserRepository.save(withdrawUser);
			xyzAccountRepository.save(xyzBankUser);
			return new ResponseEntity(new ApiResponse(true,"Transaction Successfull"),HttpStatus.OK);
		}
		}catch (Exception e) {
			return new ResponseEntity(new ApiResponse(false,"Invalid Credits"),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new ApiResponse(false,"Invalid Credits"),HttpStatus.BAD_REQUEST);
	}
}
