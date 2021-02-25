package com.kunmall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : kun
 * @date : 2021/2/25
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KunmallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(KunmallGatewayApplication.class,args);
    }
}
