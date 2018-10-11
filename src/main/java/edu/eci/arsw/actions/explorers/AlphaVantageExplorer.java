/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.actions.explorers;

import edu.eci.arsw.actions.beans.ActionsExplorer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author estudiante
 */
@Service
public class AlphaVantageExplorer implements ActionsExplorer {
    private static final String USER_AGENT = "Mozilla/5.0";    
    
    @Override
    public  Set getActionDaily(String act){
        System.out.println("Entro 3");
        Set action=new HashSet();        
        String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="+act+"&apikey=demo";
        System.out.println(GET_URL);
        try{
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                action.add(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");}
        catch(IOException e){
            e.printStackTrace();
        }
        return action;
    }
    
}
