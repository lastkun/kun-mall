package com.kunmall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KunmallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(KunmallOrderApplication.class, args);
    }

}
