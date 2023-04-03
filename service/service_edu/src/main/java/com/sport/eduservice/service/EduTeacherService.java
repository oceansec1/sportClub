package com.sport.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sport.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-02-25
 */
public interface EduTeacherService extends IService<EduTeacher> {

    Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher);
}
