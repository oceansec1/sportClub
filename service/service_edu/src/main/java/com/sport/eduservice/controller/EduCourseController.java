package com.sport.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sport.eduservice.entity.EduCourse;
import com.sport.common_utils.R;
import com.sport.eduservice.entity.EduTeacher;
import com.sport.eduservice.entity.vo.CourseInfoVo;
import com.sport.eduservice.entity.vo.CoursePublishVo;
import com.sport.eduservice.entity.vo.CourseQuery;
import com.sport.eduservice.entity.vo.TeacherQuery;
import com.sport.eduservice.service.EduCourseService;
import com.sport.exceptionhandler.SportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-18
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {
@Autowired
//TODO 带条件查询
    private EduCourseService courseService;
        @GetMapping
        public R getCourseList(){
            List<EduCourse> list=courseService.list(null);
            return R.success().data("list",list);
        }
@PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
    //返回添加之后的id

     String id=courseService.saveCourseInfo(courseInfoVo);
    return R.success().data("courseId",id);
}
//根据课程id查询课程
@GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId){
   CourseInfoVo courseInfoVo =courseService.getCourseInfo(courseId);
    return R.success().data("courseInfoVo",courseInfoVo);
}
    //修改
    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
    courseService.updateCourseInfo(courseInfoVo);

    return R.success();
    }
    //根据课程id查询课程确认信息
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPubshiCourseInfo(@PathVariable String id){
   CoursePublishVo coursePublishVo= courseService.publishCourseInfo(id);
return R.success().data("publishCourse",coursePublishVo);
}
//修改课程发布状态
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id){
    EduCourse eduCourse=new EduCourse();
    eduCourse.setId(id);
    eduCourse.setStatus("1");
    courseService.updateById(eduCourse);
    return R.success();
    }
    //删除课程
    @DeleteMapping("{courseId}")
    public R deleteCourse(@PathVariable String courseId){
            courseService.removeCourse(courseId);
            return R.success();
    }
    //分页查询
    @GetMapping("pageCourse/{current}/{limit}")
    public R pageListCourse(@PathVariable long current,@PathVariable long limit){
        //创建配置对象
        Page<EduCourse> pageCourse=new Page<>(current,limit);
//        try {
//            int i=10/0;
//        }catch (Exception e){
//            throw new SportException(2001,"执行了特定异常");
//        }
        //调用方法
        courseService.page(pageCourse,null);
        //总条数
//        long total = pageTeacher.getTotal();
        long total = pageCourse.getTotal();
        //list数据集合
//        List<EduTeacher> records = pageTeacher.getRecords();
        List<EduCourse> records = pageCourse.getRecords();
        return R.success().data("total",total).data("records",records);
    }
    @PostMapping("pageCourseCondition/{current}/{limit}")
    public  R pageCourseCondition(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) CourseQuery courseQuery){
        Page<EduCourse> page=new Page<>(current,limit);
        //条件构造器
        QueryWrapper<EduCourse> queryWrapper=new QueryWrapper<>();

        //动态SQL
        String title = courseQuery.getTitle();
        String status = courseQuery.getStatus();
        //判断条件值是否为空
        if (!StringUtils.isEmpty(title)){
            queryWrapper.like("title",title);
        }
        if (!StringUtils.isEmpty(status)){
            queryWrapper.eq("status",status);
        }
        //排序
        queryWrapper.orderByDesc("create_time");
        courseService.page(page,queryWrapper);
        //总条数
        long total = page.getTotal();
        //list数据集合
        List<EduCourse> records = page.getRecords();
        return R.success().data("total",total).data("records",records);
    }
}

