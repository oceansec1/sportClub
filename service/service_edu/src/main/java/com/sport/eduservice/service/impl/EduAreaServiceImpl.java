package com.sport.eduservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sport.eduservice.entity.EduAreaEntity;
import com.sport.eduservice.mapper.EduAreaMapper;
import com.sport.eduservice.service.EduAreaService;

import org.springframework.stereotype.Service;

@Service
public class EduAreaServiceImpl extends ServiceImpl<EduAreaMapper, EduAreaEntity> implements EduAreaService {
}
