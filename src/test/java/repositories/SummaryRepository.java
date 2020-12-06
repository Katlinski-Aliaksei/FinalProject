package repositories;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.Assertions;
import pages.AuthService;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class SummaryRepository {

    private static String GET_ALL_URL = "https://app.qa.axa.epm-rtc.projects.epam.com/api/v1/post-trade/orders/query?benchmarkType=VWAP";

    public List<Summary> getAll() {
        try {
            String token = AuthService.getToken();
            Assertions.assertNotNull(token);
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost get = new HttpPost(GET_ALL_URL);
            get.setHeader("Authorization", "bearer " + token);

            StringEntity entity = new StringEntity("{\"expressions\":[\"orderType\",\"count() as all\",\"countIf(priceImprovementToBenchmarkAmount < 0) as negative\",\"countIf(priceImprovementToBenchmarkAmount > 0) as positive\"],\"groupByExpressions\":[\"orderType\"],\"sorts\":[{\"$type\":\"SortDefinition\",\"fieldName\":\"orderType\",\"sortType\":\"ASC\"}],\"filter\":{\"$type\":\"AndFilterDefinition\",\"filters\":[{\"$type\":\"SubqueryFilterDefinition\",\"fieldExpression\":\"orderInstrument\",\"filterType\":\"IN\",\"filterValue\":{\"expressions\":[\"orderInstrument\"],\"groupByExpressions\":[\"orderInstrument\"],\"sorts\":[{\"$type\":\"SortDefinition\",\"fieldName\":\"count()\",\"sortType\":\"DESC\"}],\"take\":10}},{\"$type\":\"FilterDefinition\",\"fieldExpression\":\"dbSequence\",\"filterType\":\"LESS_OR_EQUAL\",\"filterValue\":[\"7615\"]}]}}");
            get.setEntity(entity);
            get.setHeader("Accept", "application/json");
            get.setHeader("Content-type", "application/json");

            HttpResponse response =  httpClient.execute(get);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            StringWriter writer = new StringWriter();
            IOUtils.copy(response.getEntity().getContent(), writer);
            String body = writer.toString();
            SummaryOutput output = mapper.readValue(body, SummaryOutput.class);
            return output.items;
        } catch (IOException exception) {
            return List.of();
        }
    }

    private static class SummaryOutput {
        private List<Summary> items;


        public List<Summary> getItems() {

            return items;
        }

        public void setItems(List<Summary> items) {
            this.items = items;
        }
    }
}
