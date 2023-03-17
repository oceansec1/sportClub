package com.sport.eduservice.controller;


import com.sport.common_utils.R;
import com.sport.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.success();
    }
}

