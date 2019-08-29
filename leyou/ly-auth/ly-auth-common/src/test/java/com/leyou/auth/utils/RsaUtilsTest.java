package com.leyou.auth.utils;


import com.leyou.auth.entity.UserInfo;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author wfl
 * @description
 */
public class RsaUtilsTest {

    private static final String pubKeyPath = "E:\\IDEA_txt\\secret\\rsa.pub";

    private static final String priKeyPath = "E:\\IDEA_txt\\secret\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }


    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU2Njk3NDQ4MH0.L-JJtyWy0PFSpFVlOGKsTjcJPU6UARZsUyl3746Kc_IWlsToZ8fgHWTMqQQa_H5Y70LH-csBd-1hFsaC9CXCaowmqGn-JrtMBh-0L2wa5vz4oW9Y-n2JQowIq86o2jwNjAKXYVTV4iq20DNVvZ1gytlD0sO_lSQL9odAjB2BVEA";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}