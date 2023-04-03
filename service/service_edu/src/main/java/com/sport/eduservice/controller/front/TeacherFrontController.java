package com.sport.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sport.common_utils.R;
import com.sport.eduservice.entity.EduCourse;
import com.sport.eduservice.entity.EduTeacher;
import com.sport.eduservice.service.EduCourseService;
import com.sport.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/teacherFront")
@CrossOrigin
public class TeacherFrontController {

@Autowired
    private EduTeacherService teacherService;
@Autowired
private EduCourseService courseService;
    //分页查询讲师的方法
    @PostMapping("/getTeacherFrontList/{page}/{limit}")
    public R getTeacherFrontList(@PathVariable long page,@PathVariable long limit) {
        Page<EduTeacher> pageTeacher = new Page<>(page,limit);
        Map<String,Object> map = this.teacherService.getTeacherFrontList(pageTeacher);
        //返回分页里的所有数据
        return R.success().data(map);
    }

    //讲师详情查询
    @GetMapping("/getTeacherFrontInfo/{teacherId}")
    public R getTeacherFrontInfo(@PathVariable String teacherId) {
        //根据讲师id查询讲师基本信息
        EduTeacher eduTeacher = this.teacherService.getById(teacherId);
        //根据讲师id查询所有课程
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id",teacherId);
        List<EduCourse> eduList = this.courseService.list(wrapper);

        return R.success().data("teacher",eduTeacher).data("courseList",eduList);
    }
}
