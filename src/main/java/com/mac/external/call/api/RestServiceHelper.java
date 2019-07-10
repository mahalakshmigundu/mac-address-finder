package main.java.com.mac.external.call.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class RestServiceHelper {
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

            // convert the stream into String.
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            // convert buffer reader to String.
            String output = br.lines().collect(Collectors.joining());

            // convert the string into JSONObject.
            if (output != null) {

                // JSONParser
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(output);

                // get vendor details
                JSONObject vendorDetailsJsonObject = (JSONObject) jsonObject.get("vendorDetails");

                // get company Name.
                String result = (String) vendorDetailsJsonObject.get("companyName");

                System.out.println("******************Result******************");
                System.out.println("Mac Address: " + macAddress);
                System.out.println("Company Name: " + result);
                System.out.println("******************************************");
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
