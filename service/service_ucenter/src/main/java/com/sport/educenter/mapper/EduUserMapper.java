package com.sport.educenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sport.educenter.entity.EduUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学员表 Mapper 接口
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-04-01
 */
@Mapper
public interface EduUserMapper extends BaseMapper<EduUser> {

}
