public class Main {
    public static void main(String[] args) {
        try {
            CurrencyApiClient client = new CurrencyApiClient("689bb5d443d71cdca247c40f");
            String response = client.getExchangeRates("USD");
            System.out.println("Datos de la API: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
