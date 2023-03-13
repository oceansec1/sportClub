package com.sport.eduservice.controller;

import com.sport.common_utils.R;

import com.sport.eduservice.entity.EduAreaEntity;
import com.sport.eduservice.service.EduAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/site")
public class EduAreaController {
    @Autowired
    private EduAreaService service;

    @PostMapping("/save")
    public R sava(@RequestBody EduAreaEntity entity) {
       service.save(entity);
        return R.success();
    }
}
