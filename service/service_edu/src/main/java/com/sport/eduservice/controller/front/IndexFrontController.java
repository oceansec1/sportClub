package com.sport.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sport.common_utils.R;
import com.sport.eduservice.entity.EduCourse;
import com.sport.eduservice.entity.EduTeacher;
import com.sport.eduservice.service.EduCourseService;
import com.sport.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eduservice/indexfront")
@CrossOrigin
public class IndexFrontController {
    @Autowired
    private EduCourseService courseService;
    @Autowired
    private EduTeacherService teacherService;
    @GetMapping("getAllBanner")
    public R index(){
        //查询前八条热门课程
        QueryWrapper<EduCourse> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("id");
        wrapper.last("limit 8");
        List<EduCourse> eduList = courseService.list(wrapper);
        //查询前四条名师
        QueryWrapper<EduTeacher> teacherQueryWrapper=new QueryWrapper<>();
        wrapper.orderByDesc("id");
        wrapper.last("limit 4");
        List<EduTeacher> teacherList = teacherService.list(teacherQueryWrapper);
        return R.success().data("eduList",eduList).data("teacherList",teacherList);
    }
}
