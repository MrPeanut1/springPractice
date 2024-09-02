package za.ac.cput.springpractice.overwatch;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OverwatchApi {
    //https://overfast-api.tekrop.fr/players/{player_id}/summary
    private final String BASE_URL = "https://overfast-api.tekrop.fr";
    private final RestTemplate restTemplate;

    public OverwatchApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getPlayerSummary(String playerId) {
        String url = BASE_URL + "/players/" + playerId + "/summary";
        return restTemplate.getForObject(url, String.class);
    }
}