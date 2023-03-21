package com.sport.eduservice.service;

import com.sport.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sport.eduservice.entity.vo.CourseInfoVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-18
 */
public interface EduCourseService extends IService<EduCourse> {
    //添加课程基本信息
    String saveCourseInfo(CourseInfoVo courseInfoVo);

}
