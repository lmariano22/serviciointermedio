package com.poderjudicial.serviciointermedio.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DniController {
	
	@GetMapping("/consulta-dni/{dni}")
    public ResponseEntity<Map<String, Object>> consultarDni(@PathVariable String dni) {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Imx1aXNhbmdlbG1hcmlhbm9qYXZpZXJAZ21haWwuY29tIn0.FJ_BsNvRo0prJdu_SPncFZUamn539ciFIc6dOyoAVCM";
        String url = "https://dniruc.apisperu.com/api/v1/dni/" + dni + "?token=" + token;

        Map<String, Object> response = new HashMap<>();

        try {
            RestTemplate restTemplate = new RestTemplate();
            Map body = restTemplate.getForObject(url, Map.class);

            response.put("success", true);
            response.put("data", body);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

}

