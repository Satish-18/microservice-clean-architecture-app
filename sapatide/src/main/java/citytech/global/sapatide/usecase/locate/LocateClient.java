package citytech.global.sapatide.usecase.locate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

public class LocateClient {
    private final HttpClient httpClient;

    public LocateClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public Optional<LocateResponse> post(String url) throws IOException, InterruptedException {

        HttpResponse<String> stringHttpResponse = this.httpClient.send(this.prepareClientRequest(url), HttpResponse.BodyHandlers.ofString());
        if (stringHttpResponse.statusCode() == 200) {
            String jsonResponse = stringHttpResponse.body();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            JsonNode propertiesNode = jsonNode
                    .path("features")
                    .get(0)
                    .path("properties");
            return new LocateResponse(
                    propertiesNode.get("country").asText(),
                    propertiesNode.get("state").asText(),
                    propertiesNode.get("county").asText(),
                    propertiesNode.get("category").asText()
            );
        }else{
            return null;
        }

    }

    private HttpRequest prepareClientRequest(String url) {

        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .headers("token","X-XSRF-TOKEN")
                .GET()
                .timeout(Duration.ofSeconds(10))
                .build();
    }
}

