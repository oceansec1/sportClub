package com.sport.controller;


import com.sport.common_utils.R;
import com.sport.service.MsmService;

import com.sport.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/edumsm/msm")
@CrossOrigin
public class MsmController {
    @Autowired
    private MsmService msmService;
    @GetMapping(value = "/send/{phone}")
    public R code(@PathVariable String phone) {
        String code= RandomUtil.getFourBitRandom();
        Map<String,Object> param=new HashMap<>();
        param.put("code",code);
        Boolean isSend=msmService.send(param,phone);
        if (isSend){
            return R.success();
        }else{
            return R.error().message("发送失败");
        }

    }
}
