package com.sport.eduservice.service.impl;

import com.sport.eduservice.entity.EduCourse;
import com.sport.eduservice.entity.EduCourseDescription;
import com.sport.eduservice.entity.vo.CourseInfoVo;
import com.sport.eduservice.mapper.EduCourseMapper;
import com.sport.eduservice.service.EduCourseDescriptionService;
import com.sport.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sport.exceptionhandler.SportException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-18
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
@Autowired
private EduCourseDescriptionService eduCourseDescriptionService;
    @Override
    public void saveCourseInfo(CourseInfoVo courseInfoVo) {
        //向课程表添加课程基本信息
        EduCourse eduCourse=new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if (insert<=0){
            throw new SportException(20001,"添加失败");
        }
        //向课程简介表添加数据
        EduCourseDescription courseDescription=new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        eduCourseDescriptionService.save(courseDescription);
    }
}
