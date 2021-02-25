package com.kunmall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.kunmall.member.feign")
public class KunmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(KunmallMemberApplication.class, args);
    }

}
