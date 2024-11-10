import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class CurrencyApiClient {
    private String apiKey;
    private String apiHttp;
    private HttpClient httpClient;

    public CurrencyApiClient(String apiKey) {
        this.apiKey = apiKey;
        this.apiHttp = "https://v6.exchangerate-api.com/v6/";
        this.httpClient = HttpClient.newHttpClient();
    }

    // Método para realizar la solicitud GET y gestionar la respuesta
    public void getExchangeRates(String baseCurrency) {
        try {
            String requestUrl = apiHttp + apiKey + "/latest/" + baseCurrency;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestUrl))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            // Enviar la solicitud y obtener HttpResponse
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Procesar la respuesta HTTP
            handleResponse(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para manejar la respuesta HTTP
    private void handleResponse(HttpResponse<String> response) {
        // Obtener y mostrar el código de estado de la respuesta
        int statusCode = response.statusCode();
        System.out.println("Código de Estado: " + statusCode);

        // Obtener y mostrar los encabezados de la respuesta
        Map<String, java.util.List<String>> headers = response.headers().map();
        System.out.println("Encabezados:");
        headers.forEach((key, value) -> System.out.println(key + ": " + value));

        // Obtener y mostrar el cuerpo de la respuesta
        String responseBody = response.body();
        System.out.println("Cuerpo de la Respuesta: " + responseBody);

        // Aquí podrías procesar el JSON de `responseBody` usando Gson
        // Ejemplo: deserializar el JSON en un objeto Java
        // Gson gson = new Gson();
        // ExchangeRateData data = gson.fromJson(responseBody, ExchangeRateData.class);
    }
}
