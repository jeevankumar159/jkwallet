package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import constants.ApiResponse;
import model.ABCBank;
import model.XYZBank;
import repository.CreateABCAccountRepository;
import repository.CreateXYZAccountRepository;

@RestController
public class CreateBanksApi {
	
	@Autowired
	CreateABCAccountRepository createABCAccountRepository;
	
	@Autowired
	CreateXYZAccountRepository createXYZAccountRepository;
	
	
	//Create ABC Bank Account (Using Rest let Client) 
	 @RequestMapping(method = RequestMethod.POST,path = "/createABC")
	 public ResponseEntity<String> CreateABCAccount(@RequestBody ABCBank abcBank){
		 createABCAccountRepository.save(abcBank);
		 return new ResponseEntity(new ApiResponse(true,"Account Creation Successfull"),HttpStatus.OK);
	 }
	  
	  
	  //Create XYZ Bank Account (USing Rest Let Client)
	  @RequestMapping(method = RequestMethod.POST,path = "/createXYZ")
		 public ResponseEntity<String> CreateXYZAccount(@RequestBody XYZBank abcBank){
			 createXYZAccountRepository.save(abcBank);
			 return new ResponseEntity(new ApiResponse(true,"Account Creation Successfull"),HttpStatus.OK);
		 }
}
