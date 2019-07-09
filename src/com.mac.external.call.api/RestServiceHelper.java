package external.api.call;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class RestServiceHelper {
    private RestServiceHelper() {
    }

    private static final String apiKey = "at_BbzHpD2Bupytvl6eTFVT4u60kVOtC";

    public static void callExternalMacApi(String macAddress) {
        HttpURLConnection conn = null;
        try {

            URL url = new URL("https://api.macaddress.io/v1?apiKey=" + apiKey + "&output=json&search=" + macAddress);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Mac Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
