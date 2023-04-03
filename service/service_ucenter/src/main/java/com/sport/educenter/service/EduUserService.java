package com.sport.educenter.service;

import com.sport.educenter.entity.EduUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sport.educenter.entity.vo.RegisterVo;

/**
 * <p>
 * 学员表 服务类
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-04-01
 */
public interface EduUserService extends IService<EduUser> {

    String login(EduUser user);

    void register(RegisterVo registerVo);
}
