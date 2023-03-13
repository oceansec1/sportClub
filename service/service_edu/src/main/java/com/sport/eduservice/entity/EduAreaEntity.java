package com.sport.eduservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("edu_area_order")
public class EduAreaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    private String areaId;

    private String area;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String remark;

    private int status;

    @TableField(fill = FieldFill.INSERT)
    private Date cancelTime;

    private String cencelReason;
}