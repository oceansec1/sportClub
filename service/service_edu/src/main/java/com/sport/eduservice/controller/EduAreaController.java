package com.sport.eduservice.controller;

import com.sport.common_utils.R;

import com.sport.eduservice.entity.EduAreaEntity;
import com.sport.eduservice.service.EduAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/site")
@CrossOrigin
public class EduAreaController {
//    @Autowired
//    private EduAreaService service;
//    @PostMapping("/save")
//    public R save(@RequestBody EduAreaEntity entity) {
//        boolean save = service.save(entity);
//        if (save){
//            return R.success();
//        }
//        else {
//            return R.error();
//        }
//    }
}
