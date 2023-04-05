package com.sport.educenter.controller;


import com.sport.common_utils.JwtUtils;
import com.sport.common_utils.R;
import com.sport.educenter.entity.EduUser;
import com.sport.educenter.entity.vo.RegisterVo;
import com.sport.educenter.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 学员表 前端控制器
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-04-01
 */
@RestController
@RequestMapping("/educenter/eduuser")
@CrossOrigin
public class EduUserController {
@Autowired
    private EduUserService userService;
@PostMapping("login")
public R login(@RequestBody EduUser user){
    String token= userService.login(user);
    return R.success().data("token",token);
}
//注册
    @PostMapping("register")
    public R register(@RequestBody RegisterVo registerVo){
        userService.register(registerVo);
        return R.success();
    }
    //获取用户信息
    @GetMapping("getUserInfo")
    public R getUserInfo(HttpServletRequest request){
        String userId = JwtUtils.getMemberIdByJwtToken(request);
        EduUser userInfo = userService.getById(userId);
        return R.success().data("userInfo",userInfo);
    }
}

