package cn.segema.cloud.demo.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

    @Bean(name = "client")
    public TransportClient getClient() {

        InetSocketTransportAddress node = null;
        try {
            node = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);

        return client;
    }
}
