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
public class PayUsingAccountService{

	@Autowired
	CreateUserRepository createUserRepository;
	
	@Autowired
	CreateABCAccountRepository abcAccountRepository;
	
	@Autowired
	CreateXYZAccountRepository xyzAccountRepository;
	

	public CreateUser getPayUser(String email) {
		CreateUser payingUser=createUserRepository.findByEmail(email).orElse(new CreateUser());
		return payingUser;
	}


	public ABCBank getABCBankReceivingUser(String accountNumber) {
		ABCBank abcBank=abcAccountRepository.findByAccountNumber(Long.valueOf(accountNumber)).orElse(new ABCBank());
		return abcBank;
	}
	
	public XYZBank getXYZBankReceivingUser(String accountNumber) {
		XYZBank xyzBank=xyzAccountRepository.findByAccountNumber(Long.valueOf(accountNumber)).orElse(new XYZBank());
		return xyzBank;
	}


	public ResponseEntity transferMoney(String email,String bankName, String accountNumber, Long balanceToTransfer) {
		try {
		if(bankName.equals("ABC")) {
			ABCBank abcBank=getABCBankReceivingUser(accountNumber);
			CreateUser payingUser=getPayUser(email);
			Long payingUserWalletBalance=payingUser.getWalletBalance();
			Long receiverUserBalance=abcBank.getBalance();
			
			if(payingUserWalletBalance>=balanceToTransfer) {
				payingUserWalletBalance-=balanceToTransfer;
				receiverUserBalance+=balanceToTransfer;
				payingUser.setWalletBalance(payingUserWalletBalance);
				abcBank.setBalance(receiverUserBalance);
				abcAccountRepository.save(abcBank);
				createUserRepository.save(payingUser);
				return new ResponseEntity(new ApiResponse(true,"Transaction Successfull"),HttpStatus.OK);   
			}
		}
		
		
		
		
		else if(bankName.equals("XYZ")) {
			
			XYZBank xyzBank=getXYZBankReceivingUser(accountNumber);
			CreateUser payingUser=getPayUser(email);
			Long payingUserWalletBalance=payingUser.getWalletBalance();
			Long receiverUserBalance=xyzBank.getBalance();
			
			if(payingUserWalletBalance>=balanceToTransfer) {
				payingUserWalletBalance-=balanceToTransfer;
				receiverUserBalance+=balanceToTransfer;
				payingUser.setWalletBalance(payingUserWalletBalance);
				xyzBank.setBalance(receiverUserBalance);
				xyzAccountRepository.save(xyzBank);
				createUserRepository.save(payingUser);
				return new ResponseEntity(new ApiResponse(true,"Transaction Successfull"),HttpStatus.OK);   
			}
			
		}
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(new ApiResponse(false,"Invalid Credits"),HttpStatus.BAD_REQUEST);   
		}
		return new ResponseEntity(new ApiResponse(false,"Invalid Credits"),HttpStatus.BAD_REQUEST);
	}

}
