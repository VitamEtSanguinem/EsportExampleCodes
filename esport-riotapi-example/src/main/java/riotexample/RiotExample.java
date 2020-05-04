package riotexample;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RiotExample {

    public static void main(String[] args) {
        String key =  "";
        InputStream addedkey = RiotExample.class.getClassLoader().getResourceAsStream("key.txt");

        if(addedkey != null){

            BufferedReader reader = new BufferedReader(new InputStreamReader(addedkey));
            try {
                while (reader.ready()){
                    key=reader.readLine();


            }

        }catch (IOException ioException){
            ioException.printStackTrace();}
        }


        ApiConfig cfg = new ApiConfig().setKey(key);
        RiotApi riotApi = new RiotApi(cfg);


        if(args[0]!=null){
                try {
                    Summoner summoner = riotApi.getSummonerByName(Platform.EUNE, args[0]);
                    System.out.println("Name :" + summoner.getName());
                }catch (RiotApiException riotApiException){
                    riotApiException.getErrorDto();
                }

        }
    }
}
