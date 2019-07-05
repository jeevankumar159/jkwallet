package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import constants.ApiResponse;
import model.ABCBank;
import model.CreateUser;
import model.MobileDetails;
import model.XYZBank;
import repository.CreateABCAccountRepository;
import repository.CreateUserRepository;
import repository.CreateXYZAccountRepository;
@Service
public class AddMoneyByMobileService {
	@Autowired
	CreateABCAccountRepository createABCAccountRepository;
	
	@Autowired
	CreateXYZAccountRepository createXYZAccountRepository;
	
	@Autowired
	CreateUserRepository createUserRepository;
	
	
	
	
	public ResponseEntity<?> addMoneyByMobile(MobileDetails mobileDetails){
		try {
		if(mobileDetails.getBank().equals("ABC"))
		  {
		  ABCBank abcBank=createABCAccountRepository.findByMobileNumber(mobileDetails.getMobileNumber()).orElse(new ABCBank());
		  if(abcBank.getMobileNumber()!=null) {
			  if(abcBank.getPin()==Integer.valueOf(mobileDetails.getPin())) {
				  Long bankBalance=abcBank.getBalance();
				  Long amountToDraw=Long.valueOf(mobileDetails.getAmount());
				  CreateUser currentUser=createUserRepository.findByMobileNumber(mobileDetails.getMobileNumber()).orElse(new CreateUser());
				  if(bankBalance>=amountToDraw && currentUser!=null) {
					  abcBank.setBalance(bankBalance-amountToDraw);
					  createABCAccountRepository.save(abcBank);
					  currentUser.setWalletBalance(currentUser.getWalletBalance()+amountToDraw);
					  createUserRepository.save(currentUser);
					  return new ResponseEntity<String >("Success",HttpStatus.OK);
				  }
				  
				  return new ResponseEntity<String >("No Balance",HttpStatus.OK);
			  }
			  else {
				  return new ResponseEntity<String >("Wrong PIN",HttpStatus.OK);
			  }
		  }else {
			  return new ResponseEntity<String >("Wrong Number",HttpStatus.OK);
		  }
		  
		  }
		  
		  
		  
		  
		  else if(mobileDetails.getBank().equals("XYZ")) {
			  XYZBank xyzBank=createXYZAccountRepository.findByMobileNumber(mobileDetails.getMobileNumber()).orElse(new XYZBank());
			  if(xyzBank.getMobileNumber()!=null) {
				  if(xyzBank.getPin()==Integer.valueOf(mobileDetails.getPin())) {
					  Long bankBalance=xyzBank.getBalance();
					  Long amountToDraw=Long.valueOf(mobileDetails.getAmount());
					  CreateUser currentUser=createUserRepository.findByMobileNumber(mobileDetails.getMobileNumber()).orElse(new CreateUser());
					  if(bankBalance>=amountToDraw && currentUser!=null) {
						  xyzBank.setBalance(bankBalance-amountToDraw);
						  createXYZAccountRepository.save(xyzBank);
						  currentUser.setWalletBalance(currentUser.getWalletBalance()+amountToDraw);
						  createUserRepository.save(currentUser);
					  }
					  
					  return new ResponseEntity<String >("Success",HttpStatus.OK);
				  }
				  else {
					  return new ResponseEntity<String >("Success",HttpStatus.OK);
				  }
			  }else {
				  return new ResponseEntity<String >("Success",HttpStatus.OK);
			  }
			  
			  
			  }
			  
			  
			  
			  
			  else {
				  return new ResponseEntity<String >("Wrong Number",HttpStatus.OK);
			  }
		  }catch (Exception e) {
			  return new ResponseEntity(new ApiResponse(false,"Invalid Credits"),HttpStatus.BAD_REQUEST);
		}
	}
	  
	}

