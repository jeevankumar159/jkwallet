package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import constants.ApiResponse;
import service.WithdrawService;


@RestController
public class WithdrawApi {
	@Autowired
	WithdrawService withdrawService;
	
	
	//WithDraw Money To Bank Account
	@RequestMapping(method = RequestMethod.POST,path = "/withdraw")
	  public ResponseEntity<String> withdraw(@RequestParam(value = "email")String email,@RequestParam(value = "bankName")String bankName,@RequestParam(value="amountTowithdraw")String amountTowithdraw){
		return withdrawService.withdrawMoney(email, bankName, amountTowithdraw);
	  }
}
