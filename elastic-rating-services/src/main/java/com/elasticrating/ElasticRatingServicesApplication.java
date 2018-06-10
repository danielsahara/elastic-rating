package com.elasticrating;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class ElasticRatingServicesApplication {

	@Value("${elastic.host}")
	private String elasticHost;

	public static void main(String[] args) {
		SpringApplication.run(ElasticRatingServicesApplication.class, args);
	}

	@Bean
	public TransportClient createTransportClient() throws UnknownHostException {
		Settings settings = Settings.builder()
				.put("cluster.name", "elasticsearch")
				.build();
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(elasticHost), 9300));

		return client;
	}
}
