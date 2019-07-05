package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import constants.ApiResponse;
import model.ABCBank;
import model.CardDetails;
import model.CardTransactionDetails;
import model.CreateUser;
import model.XYZBank;
import repository.CardRepository;
import repository.CreateABCAccountRepository;
import repository.CreateUserRepository;
import repository.CreateXYZAccountRepository;

@Service
public class CardService {
	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	PayUsingAccountService payUsingAccountService;
	
	@Autowired
	CreateUserRepository createUserRepository;
	
	@Autowired
	CreateABCAccountRepository abcRepository;
	
	@Autowired
	CreateXYZAccountRepository xyzRepository;
	
	public CardDetails findUserByCardNumber(Long cardNumber) {
		CardDetails cardDetails=cardRepository.findByCardNumber(cardNumber).orElse(new CardDetails());
		return cardDetails;
	}

	
	public boolean verifyCardDetails(CardTransactionDetails cardTransactionDetails) {
		Long cardNumber=cardTransactionDetails.getCardNumber();
		CardDetails cardDetails=findUserByCardNumber(cardNumber);
		int cvvReal=cardDetails.getCvv();
		int expiryMonthReal=cardDetails.getExpiryMonth();
		int expiryYearReal=cardDetails.getExpiryYear();
		int cvv=cardTransactionDetails.getCvv();
		int expiryMonth=cardTransactionDetails.getExpiryMonth();
		int expiryYear=cardTransactionDetails.getExpiryYear();
		if(cvv==cvvReal && expiryMonth==expiryMonthReal && expiryYear==expiryYearReal) {
			return true;
		}
		return false;
	}

	
	public ResponseEntity<?> transfer(CardTransactionDetails cardTransactionDetails,String email) {
		Long amountToAddLong=cardTransactionDetails.getAmountToAdd();
		CreateUser walletUser=payUsingAccountService.getPayUser(email);
		Long walletBalance=walletUser.getWalletBalance();
		Long cardNumber=cardTransactionDetails.getCardNumber();
		CardDetails cardDetails=findUserByCardNumber(cardNumber);
		String bankName=cardDetails.getBankName();
		String accountNumber=String.valueOf(cardDetails.getAccountNumber());
		
		try {
		if(bankName.equals("ABC")) {
			ABCBank abcUser=payUsingAccountService.getABCBankReceivingUser(accountNumber);
			Long bankBalance=abcUser.getBalance();
			if(bankBalance>=amountToAddLong) {
				bankBalance-=amountToAddLong;
				walletBalance+=amountToAddLong;
				abcUser.setBalance(bankBalance);
				walletUser.setWalletBalance(walletBalance);
				createUserRepository.save(walletUser);
				abcRepository.save(abcUser);
				return new ResponseEntity(new ApiResponse(true, "Successfull Transaction"),HttpStatus.OK);
			}
			else {
				return new ResponseEntity(new ApiResponse(false, "Insufficient Balance"),HttpStatus.BAD_REQUEST);
			}
			
				}
		
		else if(bankName.equals("XYZ")) {
			XYZBank xyzUser=payUsingAccountService.getXYZBankReceivingUser(accountNumber);
			Long bankBalance=xyzUser.getBalance();
			if(bankBalance>=amountToAddLong) {
				bankBalance-=amountToAddLong;
				walletBalance+=amountToAddLong;
				xyzUser.setBalance(bankBalance);
				walletUser.setWalletBalance(walletBalance);	
				createUserRepository.save(walletUser);
				xyzRepository.save(xyzUser);
				return new ResponseEntity(new ApiResponse(true, "Successfull Transaction"),HttpStatus.OK);
		}else {
			return new ResponseEntity(new ApiResponse(false, "Insufficient Balance"),HttpStatus.BAD_REQUEST);
		}

	
	}
		}catch(Exception e) {
		return new ResponseEntity(new ApiResponse(false, "Invalid Credentials"),HttpStatus.BAD_REQUEST);
	}
		return new ResponseEntity(new ApiResponse(false, "Invalid Credentials"),HttpStatus.BAD_REQUEST);
	}
	
}

