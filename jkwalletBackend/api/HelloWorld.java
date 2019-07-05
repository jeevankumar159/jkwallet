package api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorld {
	@RequestMapping(value = "/")
	public String hello() {
		return "Hello Universe";
	}
	  
	}































