package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class GitHitDemo {
    public static void main(String[] args)
    {
        //System.out.println("Hello world!");
        try {
            GitHitDemoClass();
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

    public static void GitHitDemoClass() throws URISyntaxException, IOException
    {
        URIBuilder builder = new URIBuilder("https://api.github.com/users/mechanware");

        HttpGet getDataApi = new HttpGet(builder.build());
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = httpClient.execute(getDataApi);
        if(httpResponse.getStatusLine().getStatusCode() == 200)
        {
            HttpEntity responseEntity = httpResponse.getEntity();
            String result = EntityUtils.toString(responseEntity);
            System.out.println(result);
        }
        else
        {
            System.out.println("Something went wrong. Exception: "+ httpResponse.getStatusLine());

        }

        //Close the Httpclient
        httpClient.close();
    }
}
