import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyApiClient {
    private String apiKey;
    private String apiHttp;
    private HttpClient httpClient;

    // Constructor para inicializar la API Key y la URL base
    public CurrencyApiClient(String apiKey) {
        this.apiKey = apiKey;
        this.apiHttp = "https://v6.exchangerate-api.com/v6/";
        this.httpClient = HttpClient.newHttpClient();
    }

    // Método para realizar una solicitud GET a la API de tasas de cambio
    public String getExchangeRates(String baseCurrency) throws Exception {
        // Construir la URL con apiKey y baseCurrency
        String requestUrl = apiHttp + apiKey + "/latest/" + baseCurrency;

        // Crear la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .GET()
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar el estado de la respuesta y devolver el cuerpo
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Error en la solicitud: Código de estado " + response.statusCode());
        }
    }

    // Getters y Setters opcionales para la ApiKey
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
