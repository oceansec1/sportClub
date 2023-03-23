package com.sport.eduservice.entity.vo;

import lombok.Data;

@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String  subjectLevelOne;
    private  String SubjectLevelTwo;
    private  String teacherName;
    private  String price;
}
