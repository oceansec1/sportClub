package com.sport.eduservice.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sport.common_utils.JwtUtils;
import com.sport.common_utils.R;
import com.sport.eduservice.entity.EduCourse;
import com.sport.eduservice.entity.chapter.ChapterVo;
import com.sport.eduservice.entity.frontvo.CourseFrontVo;
import com.sport.eduservice.entity.frontvo.CourseWebVo;
import com.sport.eduservice.service.EduChapterService;
import com.sport.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/coursefront")
@CrossOrigin
public class CourseFrontController {
    @Autowired
    private EduCourseService courseService;
    @Autowired
    private EduChapterService chapterService;
    //条件查询带分页
    @PostMapping("/getFrontCourseList/{page}/{limit}")
    public R getFrontCourseList(@PathVariable long page, @PathVariable long limit,@RequestBody(required = false) CourseFrontVo courseFrontVo) {
        Page<EduCourse> pageCourse = new Page<>(page,limit);
        Map<String,Object> map = this.courseService.getFrontCourseList(pageCourse,courseFrontVo);
        return R.success().data(map);
    }
    //查询课程的详细信息
    @GetMapping("/getFrontCourseInfo/{courseId}")
    public R getFrontCourseInfo(@PathVariable String courseId, HttpServletRequest request) {
        //根据课程id查询课程信息
        CourseWebVo courseWebVo = this.courseService.getBaseCourseInfo(courseId);
        //根据课程id查询章节和小节
        List<ChapterVo> chapterVideoList = this.chapterService.getChapterVideoByCourseId(courseId);
        //根据课程id和用户id查询当前课程是否已经支付过了
//        String memberIdByJwtToken = JwtUtils.getMemberIdByJwtToken(request);
//        if(memberIdByJwtToken!=null) {
//            Boolean buyCourse = this.ordersClient.isBuyCourse(courseId, memberIdByJwtToken);
//            return R.success().data("courseWebVo",courseWebVo).data("chapterVideoList",chapterVideoList).data("isBuy",buyCourse);
//        }else{
//            return R.success().data("courseWebVo",courseWebVo).data("chapterVideoList",chapterVideoList);
//        }
        return R.success().data("courseWebVo",courseWebVo).data("chapterVideoList",chapterVideoList);
    }
}
