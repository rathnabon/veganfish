package com.aime2code.springboot.veganfish.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aime2code.springboot.veganfish.entity.Breakfast;
import com.aime2code.springboot.veganfish.service.BreakfastService;
import com.aime2code.springboot.veganfish.utils.PdfGenaratorUtil;

@Controller
@RequestMapping("/breakfast")
public class BreakfastController {

	private BreakfastService iBreakfastService;
	
	@Autowired
	PdfGenaratorUtil pdfGenaratorUtil;
	
	@Autowired
	public BreakfastController(BreakfastService aBreakfastService) {
		iBreakfastService = aBreakfastService;
	}
	
	
	/*@GetMapping("/breakfast")
	public List<Breakfast> findAll(Model aModel){
		
		
		
		return iBreakfastService.findAll();
	}*/
	
	
	//test thymeleaf mapping
	@GetMapping("/hello")
	public String sayHello(Model theModel) throws Exception {
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		Map<String,String> data = new HashMap<String,String>();
	    data.put("theDate","James");
	    pdfGenaratorUtil.createPdf("helloworld",data); 
		
		return "helloworld";
	}
	
	
	
	
	//expose "breakfast" and return list of breakfast
	@GetMapping("/list")
	public String findAll(Model aModel){
		
		//get breakfasts from db
		List<Breakfast> lBreakfasts = iBreakfastService.findAll();
		
		//add to the spring model
		aModel.addAttribute("breakfasts", lBreakfasts);
		return "list-breakfasts";
	}
	
	@GetMapping("/breakfast/{aId}")
	public Breakfast findById(@PathVariable int aId) {
		
		Breakfast lBreakfastById = iBreakfastService.findById(aId);
		
		if(lBreakfastById == null) {
			throw new RuntimeException("Breakfast id not found: "+aId);
		}
		
		return lBreakfastById;
	}
	
	
	//add mapping for POST /breakfast - add new breakfast
	@PostMapping("/breakfast")
	public Breakfast addBreakfast(@RequestBody Breakfast aBreakfast) {
		
		//also just in case they pass an id in JSON, set id to O
		//this is to force a save of new item... instead of update
		
		aBreakfast.setiId(0);
		iBreakfastService.save(aBreakfast);
		
		return aBreakfast;
	}
	
	
	//add mapping for PUT /breakfast - update existing breakfast
	@PutMapping("/breakfast")
	public Breakfast updateBreakfast(@RequestBody Breakfast aBreakfast) {
		iBreakfastService.save(aBreakfast);
		return aBreakfast;
	}
	
	
	//add mapping for DELETE /breakfast/{breakfastId} - delete employee
	@DeleteMapping("/breakfast/{breakfastId}")
	public String deleteBreakfast(@PathVariable int aBreakfastId) {
		Breakfast lFindById = iBreakfastService.findById(aBreakfastId);
		
		//throw exception if null
		if(lFindById == null) {
			throw new RuntimeException("Breakfast Id not found - "+aBreakfastId);
		}
		
		iBreakfastService.deleteById(aBreakfastId);
		
		return "Deleted employee id - "+aBreakfastId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
