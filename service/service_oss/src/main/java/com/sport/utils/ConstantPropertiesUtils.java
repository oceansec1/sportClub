package com.sport.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtils implements InitializingBean {
   @Value("${aliyun.oss.end-point")
    private String endpoint;
    @Value("${aliyun.oss.access-key-id")
    private String keyId;
    @Value("${aliyun.oss.access-key-secret")
    private String keySecret;
    @Value("${aliyun.oss.bucket-name")
    private String bucketName;
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT=endpoint;
        ACCESS_KEY_ID=keyId;
        ACCESS_KEY_SECRET=keySecret;
        BUCKET_NAME=bucketName;
    }
}
