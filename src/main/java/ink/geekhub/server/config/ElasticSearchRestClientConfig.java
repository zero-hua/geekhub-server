package ink.geekhub.server.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * elasticSearch客户端配置类
 * @author linghua
 */
@Configuration
public class ElasticSearchRestClientConfig extends AbstractElasticsearchConfiguration {
    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration =
                ClientConfiguration.builder()
                        .connectedTo("localhost:9200")
                        .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
