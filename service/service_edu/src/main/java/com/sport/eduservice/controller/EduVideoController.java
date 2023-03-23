package com.sport.eduservice.controller;


import com.sport.common_utils.R;
import com.sport.eduservice.entity.EduVideo;
import com.sport.eduservice.service.EduVideoService;
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
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {
@Autowired
    private EduVideoService eduVideoService;
//添加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        eduVideoService.save(eduVideo);
        return R.success();
    }
    //删除小节
    @DeleteMapping("deleteVideo/{id}")
    public R deleteVideo(@PathVariable String id){
        eduVideoService.removeById(id);
        return R.success();
    }
    //修改小节
    @PostMapping("updateVideo")
    public R updateVideo(){
        return R.success();
    }
}

