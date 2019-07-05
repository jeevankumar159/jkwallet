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
import model.CreateUser;
import repository.CreateUserRepository;

@RestController
public class AuthenticationApi {
	
	@Autowired
	CreateUserRepository createUserRepository;
	
	
	
	//method to Create User with 0 wallet Balance
	@RequestMapping(method = RequestMethod.POST,path = "/createUser")
	public ResponseEntity<?> createUser(@RequestBody CreateUser createUser){
		 createUser.setWalletBalance(0L);
		createUserRepository.save(createUser);
		return new ResponseEntity(new ApiResponse(true,"User Created Successfully"),HttpStatus.CREATED);
	}
	
	
	//method to Login User using email and Password
	@RequestMapping(method = RequestMethod.GET, path = "/login")
	 public CreateUser LoginUser(@RequestParam(value = "email")String email,@RequestParam(value = "password") String password){
		 CreateUser createuser=createUserRepository.findByEmail(email).orElse(new CreateUser());
		 if(!createuser.getPassword().isEmpty() && createuser.getPassword().equals(password)) 
		 {
		 return createuser;
		 }
		 else
		 {
			 return createuser;
		 }
	 }
	 
}
