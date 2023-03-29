package com.sport.eduservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sport.eduservice.entity.EduChapter;
import com.sport.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-18
 */
public interface EduVideoService extends IService<EduVideo> {

    List<EduVideo> list(QueryWrapper<EduChapter> wrapperVideo);

    void removeVideByCourseId(String courseId);
}
