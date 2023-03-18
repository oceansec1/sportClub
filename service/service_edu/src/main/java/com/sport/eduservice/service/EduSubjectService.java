package com.sport.eduservice.service;

import com.sport.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sport.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-15
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);

    List<OneSubject> getAllOneTwoSubject();
}
