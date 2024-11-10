public class Main {
    public static void main(String[] args) {
        CurrencyApiClient client = new CurrencyApiClient("689bb5d443d71cdca247c40f");
        client.getExchangeRates("USD");
    }
}
