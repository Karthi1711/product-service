package com.oms.product;

import com.oms.common.security.config.EnableOMSSecurity;
import com.oms.common.security.config.OMSHttpRequestInterceptor;
import com.oms.common.web.EnableOMSCommonWeb;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
@EnableOMSCommonWeb
@EnableOMSSecurity
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public HttpClient getHttpClient() {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpRequestInterceptor interceptor = new OMSHttpRequestInterceptor();
        httpClient.addRequestInterceptor(interceptor);
        return httpClient;
    }

    @Bean
    public ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(getHttpClient());
        return factory;
    }
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        return restTemplate;
    }
}

