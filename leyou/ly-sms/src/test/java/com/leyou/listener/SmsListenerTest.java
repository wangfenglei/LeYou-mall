package com.leyou.listener;

import com.leyou.LySmsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wfl
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LySmsApplication.class)
public class SmsListenerTest {

    @Autowired
    private  AmqpTemplate amqpTemplate;

    @Test
    public void test() throws InterruptedException {
        Map<String,String> map = new HashMap<>();

        map.put("phone","15397183122");
        map.put("code","54321");
        amqpTemplate.convertAndSend("ly.sms.exchange","sms.verify.code",map);

        Thread.sleep(3000);
    }
}