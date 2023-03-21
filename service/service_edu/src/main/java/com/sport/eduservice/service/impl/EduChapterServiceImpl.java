package com.sport.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sport.eduservice.entity.EduChapter;
import com.sport.eduservice.entity.EduVideo;
import com.sport.eduservice.entity.chapter.ChapterVo;
import com.sport.eduservice.entity.chapter.VideoVo;
import com.sport.eduservice.mapper.EduChapterMapper;
import com.sport.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sport.eduservice.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {
    @Autowired
    private EduVideoService eduVideoService;//注入小节的service
    @Override
    public List<ChapterVo> getChapterByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapperChapter=new QueryWrapper<>();
        wrapperChapter.eq("course_id",courseId);
        List<EduChapter> eduChapterList = baseMapper.selectList(wrapperChapter);

        //根据课程id查询课程里面的小节
        QueryWrapper<EduVideo> wrapperVideo=new QueryWrapper<>();
        wrapperVideo.eq("course_id",courseId);
        List<EduVideo> videoList = eduVideoService.list(wrapperVideo);
        //创建集合
        List<ChapterVo> finalList=new ArrayList<>();
        //封装
        for (int i = 0; i < eduChapterList.size(); i++) {
            EduChapter eduChapter=new EduChapter();
            ChapterVo chapterVo=new ChapterVo();
            BeanUtils.copyProperties(eduChapter,chapterVo);
            finalList.add(chapterVo);
            List<VideoVo> videoVoList=new ArrayList<>();
            for (int k = 0; k < videoList.size(); k++) {
                EduVideo eduVideo=videoList.get(k);
                //判断
                if (eduVideo.getChapterId().equals(eduChapter.getId())){
                    VideoVo videoVo=new VideoVo();
                    BeanUtils.copyProperties(eduVideo,videoVo);
                    videoVoList.add(videoVo);
                    }
            }
            chapterVo.setChildren(videoVoList);
        }

        return finalList;
    }
}