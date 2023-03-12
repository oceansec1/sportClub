package com.sport.eduservice.controller;

import com.sport.common_utils.R;
import com.sport.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("eduservice/user")
@CrossOrigin//解决跨域
public class EduLoginController {
    @Autowired
    private EduTeacherService eduTeacherService;
    @PostMapping("login")
    public R login(){
        return R.success().data("token","admin");
    }
    @GetMapping("info")
    public R info(){
        return R.success().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
