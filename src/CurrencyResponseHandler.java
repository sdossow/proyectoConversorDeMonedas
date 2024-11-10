import java.net.http.HttpResponse;
import java.util.Map;

public class CurrencyResponseHandler {

    public void handleResponse(HttpResponse<String> response) {
        // Procesar el código de estado
        int statusCode = response.statusCode();
        System.out.println("Código de Estado: " + statusCode);

        // Procesar los encabezados
        Map<String, java.util.List<String>> headers = response.headers().map();
        System.out.println("Encabezados:");
        headers.forEach((key, value) -> System.out.println(key + ": " + value));

        // Procesar el cuerpo de la respuesta
        String responseBody = response.body();
        System.out.println("Cuerpo de la Respuesta: " + responseBody);

        // Deserializar JSON (opcional)
        // Gson gson = new Gson();
        // ExchangeRateData data = gson.fromJson(responseBody, ExchangeRateData.class);
    }
}
