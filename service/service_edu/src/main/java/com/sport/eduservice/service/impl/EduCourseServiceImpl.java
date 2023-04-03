package com.sport.eduservice.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sport.eduservice.entity.EduCourse;
import com.sport.eduservice.entity.EduCourseDescription;
import com.sport.eduservice.entity.frontvo.CourseFrontVo;
import com.sport.eduservice.entity.vo.CourseInfoVo;
import com.sport.eduservice.entity.vo.CoursePublishVo;
import com.sport.eduservice.mapper.EduCourseMapper;
import com.sport.eduservice.service.EduChapterService;
import com.sport.eduservice.service.EduCourseDescriptionService;
import com.sport.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sport.eduservice.service.EduVideoService;
import com.sport.exceptionhandler.SportException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
@Autowired
private EduVideoService eduVideoService;
@Autowired
private EduChapterService chapterService;
    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        //向课程表添加课程基本信息
        EduCourse eduCourse=new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if (insert<=0){
            throw new SportException(20001,"添加失败");
        }
        //获取添加之后的id
        String cid = eduCourse.getId();
        //向课程简介表添加数据
        EduCourseDescription courseDescription=new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        //设置描述id就是课程id
        courseDescription.setId(cid);
        eduCourseDescriptionService.save(courseDescription);
        return cid;
    }

    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        //查询课程表
        EduCourse eduCourse = baseMapper.selectById(courseId);
        CourseInfoVo courseInfoVo=new CourseInfoVo();
        BeanUtils.copyProperties(eduCourse,courseInfoVo);
        //查询描述表
        EduCourseDescription courseDescription = eduCourseDescriptionService.getById(courseId);
        courseInfoVo.setDescription(courseDescription.getDescription());
        return courseInfoVo;
    }

    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        //修改课程表
        EduCourse eduCourse=new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int update = baseMapper.updateById(eduCourse);
        if (update==0){
            throw  new SportException(20001,"修改失败");
        }
        //修改描述表
        EduCourseDescription eduCourseDescription=new EduCourseDescription();
        eduCourseDescription.setId(courseInfoVo.getId());
        eduCourseDescription.setDescription(courseInfoVo.getDescription());
        eduCourseDescriptionService.updateById(eduCourseDescription);
    }

    @Override
    public CoursePublishVo publishCourseInfo(String id) {
        //调用mapper
        CoursePublishVo publishCourseInfo = baseMapper.getPublishCourseInfo(id);
        return publishCourseInfo;
    }
//删除课程
    @Override
    public void removeCourse(String courseId) {
        eduVideoService.removeVideByCourseId(courseId);
        chapterService.removeChapterByCourseId(courseId);
        eduCourseDescriptionService.removeById(courseId);
        int result = baseMapper.deleteById(courseId);
        if (result==0){
            throw  new SportException(20001,"删除失败");
        }
    }

    @Override
    public Map<String, Object> getFrontCourseList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo) {
        return null;
    }
}
