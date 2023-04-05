package com.sport.service.Imp;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.baomidou.mybatisplus.extension.api.R;
import com.sport.service.MsmService;
import com.sport.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MsmServiceImpl implements MsmService {
    @Override
    public Boolean send(Map<String, Object> param, String phone) {

        if(StringUtils.isEmpty(phone)) return false;
        DefaultProfile profile =
                DefaultProfile.getProfile("default", "LTAI5tNEWzJZtaMRQLKCBsuZ",
                        "S6HGuslH5LbnFpk9CTOUsSCCrI9GoJ");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        //设置发送相关参数
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "运动管理俱乐部");
        request.putQueryParameter("TemplateCode", "SMS_275210412");
        request.putQueryParameter("TemplateParam",JSONObject.toJSONString(param));
       try{
           CommonResponse response=client.getCommonResponse(request);
           boolean success=response.getHttpResponse().isSuccess();
           return success;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }


    }

}
