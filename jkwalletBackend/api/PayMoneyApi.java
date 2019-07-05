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
import model.PayUser;
import service.PayUsingAccountService;
import service.PayUsingMobileService;

@RestController
public class PayMoneyApi {
	@Autowired
	PayUsingMobileService payUsingMobileService;
	
	@Autowired
	PayUsingAccountService payUsingAccountService;
	
	
	//method to Pay Using Mobile Number of the User
	@RequestMapping(method=RequestMethod.POST,path = "/payUsingMobile")
	  public ResponseEntity<String> payMoneyUsingMobile(@RequestBody PayUser payUser,@RequestParam(value = "email")String email ){
		  String mobileNumber=payUser.getMobileNumber();
		  Long balanceToTransfer=Long.valueOf(payUser.getAmountToPay());
		  return payUsingMobileService.transferMoney(email, mobileNumber, balanceToTransfer);
		  

	  }
	
	
	//Pay Money Using Account Details of User
	  @RequestMapping(method = RequestMethod.POST,path = "/payUsingAccountNumber")
	  public ResponseEntity<String> payUsingAccountNumber(@RequestParam(value = "email")String email,@RequestParam(value = "bankName")String bankName,@RequestParam(value="accountNumber")String accountNumber,@RequestParam(value="balanceToTransfer")String balanceToTransfer){
		  Long balanceToTransferLong=Long.valueOf(balanceToTransfer);
		  return payUsingAccountService.transferMoney(email, bankName, accountNumber, balanceToTransferLong);
		   
	  }
}
