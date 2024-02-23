package com.example.Prueba;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiConsumer {

    private String baseUrl = "https://api.jikan.moe/v4/anime";
    public String getApiAnimes() throws JSONException {
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


        JSONObject jsonResponse = new JSONObject(informationString.toString());
        JSONArray animesArray = jsonResponse.getJSONArray("data");

        JSONArray updatedAnimesArray = new JSONArray();

        String recommendation = "";

        System.out.println(animesArray.length());

        for (int i = 0; i <= animesArray.length()-1; i++) {
            JSONObject animeObject = animesArray.getJSONObject(i);

            Integer score = animeObject.getInt("score");

            if(score >= 1 && score <= 4){
                recommendation = "I do not recommend it.";
            }else if(score >= 5 && score <= 7){
                recommendation = "You may have fun.";
            }else{
                recommendation = "Great, this is one of the best anime.";
            }

            animeObject.put("recommendation", recommendation);
            updatedAnimesArray.put(animeObject);
        }

        return updatedAnimesArray.toString();
    }


}
