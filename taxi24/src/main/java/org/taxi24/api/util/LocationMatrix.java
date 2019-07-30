package org.taxi24.api.util;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LocationMatrix {

	private final static Logger LOGGER = LoggerFactory.getLogger(LocationMatrix.class);
	
	public double getDistance(String origin, String destination)
	{
		String url = "http://www.mapquestapi.com/directions/v2/routematrix?key=lAtnnhAHRhfB6Rc1JlGwv4j8m5aKZW01";
		String jsonData = "{" + 
				"  \"locations\": [" + 
				"    \""+origin+"\"," + 
				"    \""+destination+"\"]," + 
				"  \"options\": {" + 
				"    \"manyToOne\": true" + 
				"  }" + 
				"}";
		LOGGER.info("Request ----> " + jsonData);
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(jsonData, headers);
        RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, String.class);
		LOGGER.info("Response ----> " + response.getBody());
		try {
			JSONObject respJson = new JSONObject(response.getBody()) ;
			
			LOGGER.info("*******1 ----> " + respJson.get("distance").toString());
			//LOGGER.info("*******2 ----> " + respJson.getJSONObject("distance"));
			//LOGGER.info("*******3 ----> " + respJson.get("distance"));
			//LOGGER.info("*******4 ----> " + respJson.);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LOGGER.info("Distance ----> " + response.getBody());
		//return response.getBody();
		
		return 0;
	}
}
