package com.sport.eduservice.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sport.common_utils.R;
import com.sport.eduservice.entity.EduCourse;
import com.sport.eduservice.entity.frontvo.CourseFrontVo;
import com.sport.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/coursefont")
//@CrossOrigin
public class CourseFrontController {
    @Autowired
    private EduCourseService courseService;
    //条件查询带分页
    @PostMapping("/getFrontCourseList/{page}/{limit}")
    public R getFrontCourseList(@PathVariable long page, @PathVariable long limit,@RequestBody(required = false) CourseFrontVo courseFrontVo) {
        Page<EduCourse> pageCourse = new Page<>(page,limit);
        Map<String,Object> map = this.courseService.getFrontCourseList(pageCourse,courseFrontVo);
        return R.success().data(map);
    }
}
