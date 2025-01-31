package blog.evgeni.goldfish.token;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DexscreenerClient {

    private final RestTemplate restTemplate;
    private final String apiUrl;

    @Autowired
    public DexscreenerClient(RestTemplate restTemplate, @Value("https://api.dexscreener.com/token-profiles/latest/v1") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    public List<Token> getTokens() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return Arrays.asList(objectMapper.readValue(responseEntity.getBody(), Token[].class));
        } catch (Exception e) {
            throw new RuntimeException("Error parsing token data", e);
        }
    }
}