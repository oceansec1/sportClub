package com.sport.eduservice.controller;


import com.sport.common_utils.R;
import com.sport.eduservice.entity.EduChapter;
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
//添加章节
@PostMapping("addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter){
        chapterService.save(eduChapter);
        return R.success();
}
//根据id查询章节
@GetMapping("getChapterInfo/{chapterId}")
    public R getChapterInfo(@PathVariable String chapterId){
    EduChapter id = chapterService.getById(chapterId);
    return R.success().data("chapter",id);
}
    @PostMapping("updateChapterInfo")
    public R updateChapterInfo(@RequestBody EduChapter eduChapter){
        chapterService.updateById(eduChapter);
    return R.success();
    }
    @DeleteMapping("deleteChapter/{chapterId}")
    public R deleteChapter(@PathVariable String chapterId){
       boolean flag =chapterService.deleteChapter(chapterId);
       if (flag){
           return R.success();
       }
        else {
            return R.error();
       }
    }
}

