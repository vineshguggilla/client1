package com.client.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.client.pojo.Team;
import com.google.gson.Gson;

@Controller
public class WorldCupController {

	@RequestMapping(value = "/register")
	public String saveUser(Team team, Model model) {

		// Hit rest web service and add result to model object
		Gson gson = new Gson();
		String url = "http://192.168.0.20:8080/cricket-app/wc/regiterForWorldCup";
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonData = gson.toJson(team);
		
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);

		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

		System.out.println(result.getBody());
		model.addAttribute("message", result.getBody());
		// Done

		return "Home";
	}
}
