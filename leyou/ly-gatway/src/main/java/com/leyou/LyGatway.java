package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wfl
 * @date
 * @description
 */


@SpringCloudApplication
@EnableZuulProxy
public class LyGatway {
    public static void main(String[] args){
        SpringApplication.run(LyGatway.class);
    }
}
