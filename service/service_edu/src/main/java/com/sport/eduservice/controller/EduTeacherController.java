package com.sport.eduservice.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sport.common_utils.R;
import com.sport.eduservice.entity.EduTeacher;
import com.sport.eduservice.entity.vo.TeacherQuery;
import com.sport.eduservice.service.impl.EduTeacherServiceImpl;
import com.sport.exceptionhandler.SportException;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-02-25
 */
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin//跨域
public class EduTeacherController {
    @Autowired
    private EduTeacherServiceImpl eduTeacherService;
    @GetMapping("findAll")
    public R findAllTeacher(){
        //调用service方法
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.success().data("items",list);
}
//逻辑删除
@DeleteMapping("/{id}")
    public R removeTeacher(@PathVariable Integer id){
    boolean result = eduTeacherService.removeById(id);
    if (result=true){
        return R.success();
    }else {
    } return  R.error();
}
//分页查询
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,@PathVariable long limit){
        //创建配置对象
        Page<EduTeacher> pageTeacher=new Page<>(current,limit);
        try {
            int i=10/0;
        }catch (Exception e){
            throw new SportException(2001,"执行了特定异常");
        }
        //调用方法
        eduTeacherService.page(pageTeacher,null);
        //总条数
        long total = pageTeacher.getTotal();
        //list数据集合
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.success().data("total",total).data("records",records);
    }
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public  R pageTeacherCondition(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> page=new Page<>(current,limit);
        //条件构造器
        QueryWrapper<EduTeacher> queryWrapper=new QueryWrapper<>();

        //动态SQL
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件值是否为空
        if (!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level)){
            queryWrapper.eq("IS_STAR",level);
        }
        if (!StringUtils.isEmpty(begin)){
            queryWrapper.gt("CREATE_TIME",begin);
        }
        if (!StringUtils.isEmpty(end)){
            queryWrapper.le("CREATE_TIME",end);
        }
        //排序
        queryWrapper.orderByDesc("CREATE_TIME");
        eduTeacherService.page(page,queryWrapper);
        //总条数
        long total = page.getTotal();
        //list数据集合
        List<EduTeacher> records = page.getRecords();
        return R.success().data("total",total).data("records",records);
    }
    //添加
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if (save){
            return R.success();
        }
        else {
            return R.error();
        }
    }
    //根据讲师id查询
    @GetMapping("getTeacher/{id}")
        public R getTeacher(@PathVariable String id){
        EduTeacher byId = eduTeacherService.getById(id);
        return R.success().data("teacher",byId);
    }
    //修改/
    @PostMapping("updateTeacher")
        public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if (flag){
            return R.success();
        }
        else {
            return R.error();
        }
    }

}

