package tests;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AuthService;
import pages.LoginPage;

import java.io.IOException;

public class AuthServiceTest {

    @Test
    public void testLogin() throws IOException {
        String token = AuthService.getToken();
        Assertions.assertNotNull(token);
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("https://app.qa.axa.epm-rtc.projects.epam.com/api/v1/meta/post-trade-order");
        get.setHeader("Authorization", "bearer " + token);
        HttpResponse response =  httpClient.execute(get);
        Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
    }
}
