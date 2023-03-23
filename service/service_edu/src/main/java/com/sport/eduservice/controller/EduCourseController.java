package com.sport.eduservice.controller;


import com.sport.eduservice.entity.EduCourse;
import com.sport.common_utils.R;
import com.sport.eduservice.entity.vo.CourseInfoVo;
import com.sport.eduservice.entity.vo.CoursePublishVo;
import com.sport.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private EduCourseService courseService;
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
    @GetMapping("getPubshiCourseInfo/{id}")
    public R getPubshiCourseInfo(@PathVariable String id){
   CoursePublishVo coursePublishVo= courseService.publishCourseInfo(id);
return R.success().data("publishCourse",coursePublishVo);
}
}

