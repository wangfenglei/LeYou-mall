package com.leyou.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.leyou.config.SmsProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author wfl
 * @description
 *
 * 发送阿里短信
 */

@Slf4j
@Component
@EnableConfigurationProperties(SmsProperties.class)
public class SmsUtils {

    @Autowired
    private SmsProperties prop;

    @Autowired
    private StringRedisTemplate redisTemplate;
    private static final String KEY_PREFIX = "sms:time";
    private static final long INTERVAL_MILLIS = 50000;
    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";


    public SendSmsResponse sendSms(String phoneNumber, String sigName, String templateCode, String templateParam) throws ClientException {

        String key  = KEY_PREFIX + phoneNumber;

        String lastTime = redisTemplate.opsForValue().get(key);
        if (StringUtils.isNotBlank(lastTime)){

            Long last = Long.valueOf(lastTime);
            if ((System.currentTimeMillis() - last) < INTERVAL_MILLIS){
                log.error("[短信服务] 发送验证码过于频繁,手机号{}", phoneNumber);

                return null;
            }
        }

        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");


        //初始化ascClient,暂时不支持多region（请勿修改）

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", prop.getAccessKeyId(), prop.getAccessKeySecret());
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);

        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();

        request.setMethod(MethodType.POST);
        request.setPhoneNumbers(phoneNumber);
        request.setSignName(sigName);
        request.setTemplateCode(templateCode);
        request.setTemplateParam(templateParam);

        request.setOutId("123456");
          //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
            log.error("[短信服务] 发送短信异常,手机号{}", phoneNumber, sendSmsResponse.getMessage());
        }
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            //请求成功
            System.out.println("返回信息" + sendSmsResponse.getMessage());
            redisTemplate.opsForValue().set(key,String.valueOf(System.currentTimeMillis()),5, TimeUnit.MINUTES);
        }

        return sendSmsResponse;
    }

}
