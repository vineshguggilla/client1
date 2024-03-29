package com.client.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.client.pojo.Team;
import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {
		
		Team team = new Team();
		team.setCountry("INDIA");
		
		Gson gson = new Gson();
		String url = "http://192.168.0.20:8080/cricket-app/wc/regiterForWorldCup";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonData = gson.toJson(team);
		
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		System.out.println(result.getBody());
	}
}
