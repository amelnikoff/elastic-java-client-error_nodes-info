/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.nodes.NodesInfoResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import co.elastic.clients.util.ApiTypeHelper;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        RestClientBuilder clientBuilder = RestClient.builder(new HttpHost("localhost", 9200, "http"))
                .setRequestConfigCallback(requestConfigBuilder -> {
                    requestConfigBuilder.setConnectTimeout(2000);
                    requestConfigBuilder.setSocketTimeout(90_000);
                    return requestConfigBuilder;
                });

        try (RestClient httpClient = clientBuilder.build()) {
            ElasticsearchTransport transport = new RestClientTransport(httpClient, new JacksonJsonpMapper());
            ElasticsearchClient client = new ElasticsearchClient(transport);

            // ApiTypeHelper.DANGEROUS_disableRequiredPropertiesCheck(true);
            NodesInfoResponse info = client.nodes().info();
            // ApiTypeHelper.DANGEROUS_disableRequiredPropertiesCheck(false);

            System.out.println("First node: " + info.nodes().values().iterator().next());
        }
    }
}
