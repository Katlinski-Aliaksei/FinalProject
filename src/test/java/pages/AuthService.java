package pages;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthService {

    public static String getToken() throws IOException{
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("https://app.qa.axa.epm-rtc.projects.epam.com/oauth/token");
        post.setHeader("Authorization", "Basic d2ViYXBwOg==");
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("password", "Staging@Axa"));
        formParams.add(new BasicNameValuePair("username", "selenium_chrome"));
        formParams.add(new BasicNameValuePair("grant_type", "password"));
        formParams.add(new BasicNameValuePair("scope", "deltix.axa.user"));
        post.setEntity(new UrlEncodedFormEntity(formParams));
        HttpResponse response = httpClient.execute(post);
        Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
        String s = EntityUtils.toString(response.getEntity());
        s = s.substring(s.indexOf("access_token")+"access_token".length()+3);
        s = s.substring(0, s.indexOf("\""));
        return s;
    }
}
