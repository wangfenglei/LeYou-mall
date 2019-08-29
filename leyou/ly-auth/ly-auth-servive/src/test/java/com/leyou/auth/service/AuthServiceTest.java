package com.leyou.auth.service;

import com.leyou.auth.LeyouAuthApplication;
import com.leyou.user.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wfl
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeyouAuthApplication.class)
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    public void testService(){

        String login = authService.login("wflit", "123456");
        System.out.println("login = " + login);
    }
}