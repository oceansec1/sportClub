package com.sport.eduservice.controller;


import com.sport.common_utils.R;
import com.sport.eduservice.entity.chapter.ChapterVo;
import com.sport.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class EduChapterController {
@Autowired
    private EduChapterService chapterService;
    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId){
        List<ChapterVo> list =chapterService.getChapterByCourseId(courseId);
        return R.success().data("allChapterVideo",list);
}
}

