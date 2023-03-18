package com.sport.eduservice.controller;


import com.sport.common_utils.R;
import com.sport.eduservice.entity.subject.OneSubject;
import com.sport.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-15
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.success();
    }
    @GetMapping("getAllSubject")
    public R getAllSubject(){
        List<OneSubject> list=eduSubjectService.getAllOneTwoSubject();
      return  R.success().data("list",list);
    }
}

