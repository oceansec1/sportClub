package com.sport.educms.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.sport.common_utils.R;
import com.sport.educms.entity.CrmBanner;
import com.sport.educms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-30
 */
@RestController
@CrossOrigin
@RequestMapping("/educms/banner")
public class BannerAdminController {
    @Autowired
    private CrmBannerService crmBannerService;
@GetMapping("pageBanner/{page}/{limit}")
    public R pageBanner(@PathVariable long page, @PathVariable long limit){
    Page<CrmBanner> pageBanner=new Page<>(page,limit);
    crmBannerService.page(pageBanner,null);
    return R.success().data("item",pageBanner.getRecords()).data("total",pageBanner.getTotal());
}
//添加
    @PostMapping("addBanner")
    public R addBanner(@RequestBody CrmBanner crmBanner){
    crmBannerService.save(crmBanner);
    return R.success();
    }
    @PutMapping("updateBanner")
    public R updateBanner(@RequestBody CrmBanner crmBanner){
    crmBannerService.updateById(crmBanner);
    return R.success();
    }
    @DeleteMapping("deleteBanner")
    public R updateBanner(@PathVariable String id){
    crmBannerService.removeById(id);
    return R.success();
    }
    //根据id查询
    @GetMapping("get/{id}")
    public R get(@PathVariable String id){
        CrmBanner banner = crmBannerService.getById(id);
        return R.success().data("item",banner);
    }
}

