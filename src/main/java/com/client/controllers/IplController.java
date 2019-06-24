package com.client.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class IplController {

	@RequestMapping(value="/wishUser")
	public String wishUser(@RequestParam("userName") String name, Model model) {
		System.out.println("Wishes requested for user : " + name);
		//Hit rest web service and add result to model object
		
		String url = "http://192.168.0.20:8080/cricket-app/ipl/wishUser?name=" + name;
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		System.out.println(result.getBody());
		model.addAttribute("message", result.getBody());
		//Done
		return "wishes";
	}
}
