package com.sport.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduTeacher对象", description="讲师")
@TableName("edu_teacher")
public class EduTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教师ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "教师名称")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "教师资历,一句话说明老师")
    @TableField("EDUCATION")
    private String education;

    @ApiModelProperty(value = "教师简介")
    @TableField("CAREER")
    private String career;

    @ApiModelProperty(value = "头衔 1高级讲师2首席讲师")
    @TableField("IS_STAR")
    private Integer isStar;

    @ApiModelProperty(value = "图片路径")
    @TableField("PIC_PATH")
    private String picPath;

    @ApiModelProperty(value = "状态:0正常1删除")
    @TableField("STATUS")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private Date updateTime;

    @ApiModelProperty(value = "专业ID")
    @TableField("SUBJECT_ID")
    private Integer subjectId;

    @ApiModelProperty(value = "排序")
    @TableField("SORT")
    private Integer sort;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    @TableField(value = "is_deleted") // 和表的字段映射的
    private Integer deleted;
}
