package com.sport.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sport.eduservice.entity.EduSubject;
import com.sport.eduservice.entity.excel.SubjectData;
import com.sport.eduservice.entity.subject.OneSubject;
import com.sport.eduservice.entity.subject.TwoSubject;
import com.sport.eduservice.listener.SubjectExcelListener;
import com.sport.eduservice.mapper.EduSubjectMapper;
import com.sport.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.One;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
            EasyExcel.read(in, SubjectData.class,new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        }catch (Exception e){
    e.printStackTrace();
        }
    }

    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        //一级分类
        QueryWrapper<EduSubject> wrapperOne=new QueryWrapper<>();
        wrapperOne.eq("parent_id","0");
        List<EduSubject> oneSubjectList = baseMapper.selectList(wrapperOne);
        //二级分类
        QueryWrapper<EduSubject> wrapperTwo=new QueryWrapper<>();
        wrapperTwo.ne("parent_id","0");
        List<EduSubject> TwoSubjectList = baseMapper.selectList(wrapperTwo);
        List<OneSubject> finalSubject=new ArrayList<>();
        //封装一级分类
        for (int i = 0; i < oneSubjectList.size(); i++) {
            EduSubject eduSubject = oneSubjectList.get(i);
            OneSubject oneSubject=new OneSubject();
            BeanUtils.copyProperties(eduSubject,oneSubject);
            finalSubject.add(oneSubject);

            //二级分类
            List<TwoSubject> twoFinalSubjects=new ArrayList<>();
            for (int k = 0; k < TwoSubjectList.size(); k++) {
                EduSubject eduSubject1 = TwoSubjectList.get(k);
                //判断二级分类和一级分类的parent——id是否意义
                if (eduSubject1.getParentId().equals(eduSubject.getId())){
                    TwoSubject twoSubject=new TwoSubject();
                    BeanUtils.copyProperties(eduSubject1,twoSubject);
                    twoFinalSubjects.add(twoSubject);
                }
            }
            //把一级下面的所有的二级分类放到一级分类里面
            oneSubject.setChildren(twoFinalSubjects);
        }
        return finalSubject;
    }
}
