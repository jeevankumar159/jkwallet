package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import constants.ApiResponse;
import model.CardDetails;
import repository.CardRepository;


@RestController
public class CreateCardApi {
	@Autowired
	CardRepository cardRepository;
	
	@RequestMapping(method = RequestMethod.POST,path="/createCard")
	public ResponseEntity<String> addCard(@RequestBody CardDetails cardDetails){
		
		cardRepository.save(cardDetails);
		return new ResponseEntity(new ApiResponse(true,"Card Creation Successfull"),HttpStatus.OK);
	}
}
