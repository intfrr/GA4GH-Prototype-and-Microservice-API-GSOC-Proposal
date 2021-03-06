package com.ga4gh.prototype.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ga4gh.prototype.entity.GA4GH;
import com.ga4gh.prototype.service.GA4GHService;

@CrossOrigin(origins ="*",allowedHeaders="*",maxAge=200000) 
@RestController
@RequestMapping("/user")
public class UserRestController {

	
	private GA4GHService GA4GHService;
	

	@Autowired   
	public UserRestController(GA4GHService GA4GHService)
	{
		this.GA4GHService=GA4GHService;
	}
	

	@GetMapping
	public List<GA4GH> FindAll() {
	
		return GA4GHService.findAll();
	}
	
	@GetMapping("/{pageNo}")
	public List<GA4GH> FindPage(@PathVariable int pageNo) {
	
		List<GA4GH> list = GA4GHService.findPage(pageNo,100, "id");
		
		return list;
	}
	
	@GetMapping("/{pageNo}/{pageSize}")
	public List<GA4GH> FindPageWithSize(@PathVariable int pageNo,
								@PathVariable int pageSize) {
	
		List<GA4GH> list = GA4GHService.findPage(pageNo,pageSize, "id");
		
		return list;
	}
	
	@GetMapping("/{pageNo}/sort/{sort}")
	public List<GA4GH> FindPageWithSorting(@PathVariable int pageNo,
								@PathVariable String sort) {
	
		List<GA4GH> list = GA4GHService.findPage(pageNo,100, sort);
		
		return list;
	}
	
	
	
	@GetMapping("/{pageNo}/{pageSize}/{sort}")
	public List<GA4GH> FindPageWithLimitAndSorting(@PathVariable int pageNo,
								@PathVariable int pageSize,
								@PathVariable String sort) {
	
		List<GA4GH> list = GA4GHService.findPage(pageNo,pageSize,sort);
		
		return list;
	}
	
	@GetMapping("/limit/{pageSize}")
	public List<GA4GH> FindLimit(@PathVariable int pageSize) {
	
		List<GA4GH> list = GA4GHService.findPage(0,pageSize,"id");
		
		return list;
	}
	

	@GetMapping("/limit/{pageSize}/{sort}")
	public List<GA4GH> FindLimitWithSort(@PathVariable int pageSize,
									@PathVariable String sort) {
	
		List<GA4GH> list = GA4GHService.findPage(0,pageSize,sort);
		
		return list;
	}
	
	
	@GetMapping("/id/{theId}")
	public GA4GH findById(@PathVariable int theId) {
		
		return GA4GHService.findById(theId);
	}
	
	@GetMapping("/sequencename/{theId}")
	public List<GA4GH> findBySequence_Name(@RequestHeader("key") String language,
			@PathVariable String theId) {
		System.out.println(language);
		System.out.println(language);
		System.out.println(language);
		System.out.println(language);
		System.out.println(language);
		
		if(language.equals("ga4ahapisecuritykey"))
			return GA4GHService.findBySequence_Name(theId);
		
		return null;
		

	}

	@GetMapping("/genbank/{theId}")
	public List<GA4GH> findByGenBank_Accn(@RequestHeader("key") String language,
			@PathVariable String theId) {
		
		System.out.println(language);
		System.out.println(language);
		System.out.println(language);
		System.out.println(language);
		System.out.println(language);
		
		if(language.equals("ga4ahapisecuritykey"))
			return GA4GHService.findBySequence_Name(theId);
		
		return null;
	}

	@GetMapping("/refseq/{theId}")
	public List<GA4GH> findByRefseq_Accn(@PathVariable String theId) {
		
		return GA4GHService.findByRefseq_Accn(theId);
	}
	
	@GetMapping("/sequencelength/{theId}")
	public List<GA4GH> findBySequencelength(@PathVariable String theId) {
		
		return GA4GHService.findBySequencelength(theId);
	}
	

}
