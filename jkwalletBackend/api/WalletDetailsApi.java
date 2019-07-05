package api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.CreateUser;
import model.WalletDetails;
import repository.CreateUserRepository;


@RestController
public class WalletDetailsApi {
	@Autowired
	CreateUserRepository createUserRepository;
	
	@RequestMapping(method = RequestMethod.GET,path = "/walletDetails")
	 public WalletDetails loadWalletMoney(@RequestParam(value = "email") String email) {
		  CreateUser createuser=createUserRepository.findByEmail(email).orElse(new CreateUser());
		  if(createuser.getWalletBalance()!=null)
		  {
			  return new WalletDetails(String.valueOf(createuser.getWalletBalance()));
		  }
		  else
		  {
			  return new WalletDetails("0");
		  }
	 }
}
