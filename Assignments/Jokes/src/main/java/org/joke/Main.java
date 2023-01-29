package org.joke;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        try {
            WeatherDeatailAssign();
        }
        catch (URISyntaxException e)
        {
            System.out.println(e);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }

    public static void WeatherDeatailAssign() throws IOException, URISyntaxException
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Please share your city name to get the weather forecast : ");
        String city = scn.nextLine();

        URIBuilder builder = new URIBuilder("http://api.weatherbit.io/v2.0/current");
        builder.setParameter("key","9c214ffb70f54e90aefe0f6dcee2edad");
        builder.setParameter("lat","35.7796");
        builder.setParameter("lon","-78.6382");
        builder.setParameter("include","minutely");
        builder.setParameter("city",city);


        //Building url for Api call
        HttpGet getData = new HttpGet(builder.build());

        //Create a HttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //Create a HttpResponse
        CloseableHttpResponse httpResponse = httpClient.execute(getData);
        //System.out.println(httpResponse);

        //check the response is success
        if(httpResponse.getStatusLine().getStatusCode() == 200)
        {
            System.out.println(httpResponse);
            //returns and store the response body or relevant data
            HttpEntity responseEntity = httpResponse.getEntity();
            //System.out.println(responseEntity);

            //convert JSON to String
            String result = EntityUtils.toString(responseEntity);
            System.out.println(result);
        }
        else
        {
            System.out.println("Something went wrong. Please check your data");
        }

        //Close the Httpclient
        httpClient.close();
    }
}