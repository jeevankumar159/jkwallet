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
public class PayUsingMobileService  {
	@Autowired
	CreateUserRepository createUserRepository;
	

	public CreateUser getPayUser(String email) {
		CreateUser payingUser=createUserRepository.findByEmail(email).orElse(new CreateUser());
		return payingUser;
	}
	

	
	public CreateUser getReceivingUser(String mobileNumber) {
		CreateUser receivingUser=createUserRepository.findByMobileNumber(mobileNumber).orElse(new CreateUser());
		return receivingUser;
	}
	
	

	public ResponseEntity transferMoney(String email,String mobileNumber,Long balanceToTransfer) {
		try{
			CreateUser payingUser=getPayUser(email);
		
		CreateUser receivingUser=getReceivingUser(mobileNumber);
		Long payingUserWalletBalance=payingUser.getWalletBalance();
		Long receivingUserWalletBalance=receivingUser.getWalletBalance();
		if(payingUserWalletBalance>balanceToTransfer) {
			payingUserWalletBalance=payingUserWalletBalance-balanceToTransfer;
			receivingUserWalletBalance=receivingUserWalletBalance+balanceToTransfer;
			payingUser.setWalletBalance(payingUserWalletBalance);
			receivingUser.setWalletBalance(receivingUserWalletBalance);
			createUserRepository.save(payingUser);
			createUserRepository.save(receivingUser);
			return new ResponseEntity(new ApiResponse(true,"Transaction Successfull"),HttpStatus.OK);
		}
		}catch(Exception e){
			return new ResponseEntity(new ApiResponse(false,"Invalid Credits"),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new ApiResponse(false,"Invalid Credits"),HttpStatus.BAD_REQUEST);
	}

}
