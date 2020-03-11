package com.ga4gh.prototype.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga4gh.prototype.entity.GA4GH;
import com.ga4gh.prototype.service.GA4GHService;

@CrossOrigin(origins ="*",allowedHeaders="*",maxAge=200000) 
@RestController
@RequestMapping("/admin")
public class AdminRestController {

	@Autowired  
	private GA4GHService GA4GHService;
	


	

	@GetMapping("")
	public List<GA4GH> FindAll() {
	
		return GA4GHService.findAll();
	}
	
	
	@GetMapping("/id/{theId}")
	public GA4GH findById(@PathVariable int theId) {
		
		return GA4GHService.findById(theId);
	}
	
	@GetMapping("/sequencename/{theId}")
	public List<GA4GH> findBySequence_Name(@PathVariable String theId) {
		
		return GA4GHService.findBySequence_Name(theId);
	}

	@GetMapping("/genbank/{theId}")
	public List<GA4GH> findByGenBank_Accn(@PathVariable String theId) {
		
		return GA4GHService.findByGenBank_Accn(theId);
	}

	@GetMapping("/refseq/{theId}")
	public List<GA4GH> findByRefseq_Accn(@PathVariable String theId) {
		
		return GA4GHService.findByRefseq_Accn(theId);
	}
	
	@GetMapping("/sequencelength/{theId}")
	public List<GA4GH> findBySequencelength(@PathVariable String theId) {
		
		return GA4GHService.findBySequencelength(theId);
	}
	

	@PostMapping("/save")
	public GA4GH add(@RequestBody GA4GH obj) {
		
		obj.setId(0);
		
		GA4GHService.save(obj);
		
		return obj;
	}
	
	@PostMapping("/update")
	public GA4GH update(@RequestBody GA4GH obj) {
		
		GA4GHService.save(obj);
		
		return obj;
	}
	
	@GetMapping("/delete/{theId}")
	public String delete(@PathVariable int theId) {
		
		 GA4GHService.deleteById(theId);
		 
		 return "value deleted";
	}

	
	/*
	 * Generated by POSTMAN: 
	   Unirest.setTimeouts(0, 0);
	   HttpResponse<String> response = Unirest.get("http://localhost:8080/admin")
	  .header("X-API-Key", "TXHJmcmv9z9MrpodVy5B58W2jDQ6lBOR8acwouIl")
	  .header("Content-Type", "text/plain")
	  .body("{\r\n\"partner_secret\":\"057da51d7ee7822304a03c9d1c8adb40\",\r\n\"user_agent\":\"user agent value\",\r\n\"unique_id\":\"39\",\r\n\"page\":1,\r\n\"user_id\":\"xxxxxxxxxx\"\r\n}\r\n")
	  .asString();
	 * 
	 */

	
}
