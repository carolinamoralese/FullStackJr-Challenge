package com.example.Prueba;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiConsumer {

    private String baseUrl = "https://api.jikan.moe/v4/anime";
    public String getApiAnimes() {
        StringBuilder informationString = new StringBuilder();
        try {
            URL url = new URL(baseUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Ocurrió un error: " + responseCode);
            } else {
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return informationString.toString();
    }

    public String getApiAnimeById(Integer animeId) {
        StringBuilder informationString = new StringBuilder();
        try {
            URL url = new URL(baseUrl + "/" + animeId);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Ocurrió un error: " + responseCode);
            } else {
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return informationString.toString();
    }



}
