package com.paulmalland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paulmalland.model.Exercise;

@Controller
public class MinutesController {

	/**
	 * @RequestMapping(value="/addMinutes")
	 * /addMinutes refer to the url that we looking for 
	 * i.e http://localhost/FitnessTracker/addMinutes.html 
	 * @param exercise
	 * @return
	 */
	@RequestMapping(value="/addMinutes")
	public String addMinutes(@ModelAttribute ("exercise") Exercise exercise) {
		
		System.out.println("exercise: " + exercise.getMinutes() );
		
		
		/** This "addMinutes" that we return is used by our InternatRessourceViewResolver or ViewResolver
		 * in the servlet-config.xml file to search for the right .jsp file to fire up. 
		 * If the return is just 'return "forward:addMoreMinutes";' the page breack
		 * cause it doesn't know where is FitnessTracker/addMoreMinutes
		 * it has to be return '"forward:addMoreMinutes.html";' so the RequestMapping
		 * of the addMore%Minutes method can work.
		 *  "forward:addMoreMinutes.html"; is going OUTSIDE of our frameword and comming back IN
		 *  and remember, the servlet mapping in the web.xml file say that we look for request
		 *  that looks like "*.html" 
		 *  
		 *   "forward: " bypass our view resolver, the same request enter addMoreMinutes
		 */
		//return "forward:addMoreMinutes.html";
		
		// "redirect:" also lead to addMoreMinutes put it closes our request and reopen a new one
		// so the first exercise object is lost
		//return "redirect:addMoreMinutes.html";
		return "addMinutes";
	}
	
	/**
	 * Here an example of chaining. From the addMinutes method,
	 * who return "forward:addMoreMinutes.html"; that bypass our view resolver 
	 * and enter back throug as a request and enter the addMoreMinutes method and the view resolver
	 * but it is the same request
	 * 
	 * The second ewample of chaining is with "redirect:" that close the incoming request and 
	 * opening a new one, loosing the precedent.
	 * 
	 * @RequestMapping(value="/addMoreMinutes")
	 * /addMinutes refer to the url that we looking for 
	 * i.e http://localhost/FitnessTracker/addMoreMinutes.html 
	 * @param exercise
	 * @return
	 */
//	@RequestMapping(value="/addMoreMinutes")
//	public String addMoreMinutes(@ModelAttribute ("exercise") Exercise exercise) {
//		
//		System.out.println("exercising: " + exercise.getMinutes() );
//		
//		
//		/** this "addMinutes" that we return is used by our InternatRessourceViewResolver or ViewResolver
//		 * in the servlet-config.xml file to search for the right .jsp file to fire up. 
//		 */
//		return "addMinutes";	
//	}
	
}