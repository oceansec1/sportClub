package com.sport.eduservice.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sport.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sport.eduservice.entity.chapter.ChapterVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-18
 */
@Mapper
public interface EduChapterMapper extends BaseMapper<EduChapter> {

//    List<EduChapter> selectList(QueryWrapper<ChapterVo> wrapperChapter);
}
