package com.sport.educenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sport.common_utils.JwtUtils;
import com.sport.common_utils.MD5;
import com.sport.educenter.entity.EduUser;
import com.sport.educenter.entity.vo.RegisterVo;
import com.sport.educenter.mapper.EduUserMapper;
import com.sport.educenter.service.EduUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sport.exceptionhandler.SportException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 学员表 服务实现类
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-04-01
 */
@Service
public class EduUserServiceImpl extends ServiceImpl<EduUserMapper, EduUser> implements EduUserService {

    @Override
    public String login(EduUser user) {
        String mobile = user.getMobile();
        String password = user.getPassword();
        //非空判断
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            throw  new SportException(20001,"登陆失败");
        }
        QueryWrapper<EduUser> wrapper=new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        EduUser mobileUser = baseMapper.selectOne(wrapper);
        //是否为空
        if (mobileUser == null){
            throw  new SportException(20001,"手机号不存在");
        }

        if (!password.equals(user.getPassword())){
            throw  new SportException(20001,"密码错误");
        }
        //登录成功，生成token字符串
        String jwtToken = JwtUtils.getJwtToken(user.getId(), user.getNickName());
        return jwtToken;
    }
    //注册方法
    @Override
    public void register(RegisterVo registerVo) {
        //获取注册的数据
        String code = registerVo.getCode();
        String mobile = registerVo.getMobile();
        String nickname = registerVo.getNickname();
        String password = registerVo.getPassword();
        //判断是否为空
        if(StringUtils.isEmpty(mobile) ||
                StringUtils.isEmpty(nickname) ||
                StringUtils.isEmpty(password)) {
            throw new SportException(20001,"error");
        }
        //获取验证码


        //判断手机号是否重复
        QueryWrapper<EduUser> wrapper=new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        Integer count = baseMapper.selectCount(wrapper);
        if (count>0){
            throw new SportException(20001,"已被注册过");
        }
        EduUser  user=new EduUser();
        user.setMobile(mobile);
        user.setPassword(MD5.encrypt(password));
        user.setNickName(nickname);
        user.setIsDisabled(false);
        user.setAvatar("");
        baseMapper.insert(user);
    }
}
