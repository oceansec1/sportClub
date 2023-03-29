package com.sport.eduservice.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sport.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sport.eduservice.entity.subject.OneSubject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-15
 */
@Mapper
public interface EduSubjectMapper extends BaseMapper<EduSubject> {

    List<EduSubject> list(QueryWrapper<OneSubject> wrapperOne);
}
