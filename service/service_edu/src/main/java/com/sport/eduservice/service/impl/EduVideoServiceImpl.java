package com.sport.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sport.eduservice.entity.EduChapter;
import com.sport.eduservice.entity.EduVideo;
import com.sport.eduservice.mapper.EduVideoMapper;
import com.sport.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-18
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Override
    public List<EduVideo> list(QueryWrapper<EduChapter> wrapperVideo) {
        return null;
    }
}
