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

public class Main {
    public static void main(String[] args)
    {
        try {
            JokeDetails();
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

    public static void JokeDetails() throws IOException, URISyntaxException
    {
        URIBuilder builder = new URIBuilder("https://api.chucknorris.io/jokes/random");

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