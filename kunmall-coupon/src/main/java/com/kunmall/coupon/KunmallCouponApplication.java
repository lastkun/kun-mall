package com.kunmall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KunmallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(KunmallCouponApplication.class, args);
    }

}
