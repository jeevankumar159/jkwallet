package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import constants.ApiResponse;
import model.CardTransactionDetails;
import model.MobileDetails;
import service.AddMoneyByMobileService;
import service.CardService;

@RestController
public class AddMoneyToWalletApi{
	@Autowired
	CardService cardService;
	
	@Autowired
	AddMoneyByMobileService addMoneyByMobileService;
	
	
	//Method to add Money By Card
	@RequestMapping(method = RequestMethod.POST,path = "/addMoneyByCard")
	public ResponseEntity<?> addMoneyByCard(@RequestBody CardTransactionDetails cardTransactionDetails,@RequestParam(value = "email")String email){
		return cardService.transfer(cardTransactionDetails, email);
		
	}
	
	
	
	//Method to add Money By Mobile
	@RequestMapping(method = RequestMethod.POST,path="/addMoneyByMobile")
	  public ResponseEntity<?> AddMoneyByMobile(@RequestBody MobileDetails mobileDetails)
	  {		
		  return addMoneyByMobileService.addMoneyByMobile(mobileDetails);
		 
	  }
	
	
}
