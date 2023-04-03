package com.sport.educms.controller;

import com.sport.common_utils.R;
import com.sport.educms.entity.CrmBanner;
import com.sport.educms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/educms/front")
@CrossOrigin
public class BannerFrontController {
    @Autowired
    private CrmBannerService   bannerService;
    //查询所有banner
    @GetMapping("getAllBanner")
    public R getAllBanner(){
       List<CrmBanner> list= bannerService.selectAllBanner();
        return R.success().data("list",list);
    }
}
