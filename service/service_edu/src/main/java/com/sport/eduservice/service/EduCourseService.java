package com.sport.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sport.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sport.eduservice.entity.frontvo.CourseFrontVo;
import com.sport.eduservice.entity.vo.CourseInfoVo;
import com.sport.eduservice.entity.vo.CoursePublishVo;

import java.util.Map;

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

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    void removeCourse(String courseId);

    Map<String, Object> getFrontCourseList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo);
}
