import java.net.URI;
import java.net.http.HttpRequest;

public class CurrencyRequestBuilder {
    private String apiKey;
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public CurrencyRequestBuilder(String apiKey) {
        this.apiKey = apiKey;
    }

    public HttpRequest buildGetRequest(String baseCurrency) {
        String requestUrl = API_BASE_URL + apiKey + "/latest/" + baseCurrency;
        return HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .header("Accept", "application/json")
                .GET()
                .build();
    }
}
