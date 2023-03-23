package com.sport.eduservice.mapper;

import com.sport.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sport.eduservice.entity.vo.CoursePublishVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-18
 */
@Mapper
public interface EduCourseMapper extends BaseMapper<EduCourse> {
public CoursePublishVo getPublishCourseInfo(String courseId);
}
