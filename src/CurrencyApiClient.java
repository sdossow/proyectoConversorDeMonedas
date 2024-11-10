import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class CurrencyApiClient {
    private String apiKey;
    private HttpClient httpClient;
    private CurrencyRequestBuilder requestBuilder;
    private CurrencyResponseHandler responseHandler;

    public CurrencyApiClient(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
        this.requestBuilder = new CurrencyRequestBuilder(apiKey);
        this.responseHandler = new CurrencyResponseHandler();
    }

    public void getExchangeRates(String baseCurrency) {
        try {
            var request = requestBuilder.buildGetRequest(baseCurrency);
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            responseHandler.handleResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
