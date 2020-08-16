package com.atguigu.vod.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date 2020/7/21-17:52
 */
@Component
public class ConstantVideoUtils implements InitializingBean {
    @Value("${aliyun.vod.file.keyid}")
    private String accessKey;
    @Value("${aliyun.vod.file.keysecret}")
    private String accessSecret;

    public static String ACCESS_KEY;
    public static String ACCESS_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY = accessKey;
        ACCESS_SECRET = accessSecret;
    }
}
