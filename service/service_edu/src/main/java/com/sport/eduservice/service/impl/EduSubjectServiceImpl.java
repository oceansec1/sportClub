package com.sport.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.sport.eduservice.entity.EduSubject;
import com.sport.eduservice.entity.excel.SubjectData;
import com.sport.eduservice.listener.SubjectExcelListener;
import com.sport.eduservice.mapper.EduSubjectMapper;
import com.sport.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.InputStream;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-03-15
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file,EduSubjectService eduSubjectService) {
        try{
            InputStream in=file.getInputStream();
            EasyExcel.read(in, SubjectData.class,new SubjectExcelListener()).sheet().doRead();
        }catch (Exception e){
    e.printStackTrace();
        }
    }
}
