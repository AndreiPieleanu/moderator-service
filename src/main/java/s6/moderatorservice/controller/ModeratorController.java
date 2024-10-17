package s6.moderatorservice.controller;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import s6.moderatorservice.service.ModeratorService;

@RestController
@RequestMapping("/api/moderator")
@CrossOrigin
public class ModeratorController {
    private final ModeratorService moderatorService;
    private final RestTemplate restTemplate;
    public ModeratorController(ModeratorService moderatorService){
        this.moderatorService = moderatorService;
        this.restTemplate = new RestTemplate();
    }
    @PostMapping("/predict")
    @CrossOrigin
    public Boolean generate(@RequestBody String text){
        String flaskApiUrl = "http://localhost:5000/predict";  // Flask API URL

        // Prepare the request body as JSON
        JSONObject requestJson = new JSONObject();
        requestJson.put("text", text);

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HttpEntity for the request
        HttpEntity<String> request = new HttpEntity<>(requestJson.toString(), headers);

        // Send the POST request and get the response
        ResponseEntity<String> response = restTemplate.exchange(flaskApiUrl, HttpMethod.POST, request, String.class);

        // Return the result
        JSONObject jsonResponse = new JSONObject(response.getBody());
        return moderatorService.isOffensive(jsonResponse.getString("result"));
    }

}
