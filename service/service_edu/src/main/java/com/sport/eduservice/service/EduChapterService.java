package com.sport.eduservice.service;

import com.sport.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sport.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-18
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterByCourseId(String courseId);

    boolean deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);

    List<ChapterVo> getChapterVideoByCourseId(String courseId);
}
