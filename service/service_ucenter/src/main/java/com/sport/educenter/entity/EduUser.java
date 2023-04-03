package com.sport.educenter.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学员表
 * </p>
 *
 * @author WangHaiYang
 * @since 2023-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduUser对象", description="学员表")
public class EduUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学员ID")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "邮箱号")
    private String email;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "显示名 （昵称）")
    private String nickName;

    @ApiModelProperty(value = "性别  1男  2女")
    private Boolean sex;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "注册时间")
    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    @ApiModelProperty(value = "是否可用 1正常  2冻结")
    private Boolean isDisabled;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "个人中心用户背景图片")
    private String isDeleted;

    @ApiModelProperty(value = "站内信未读消息数")
    private String sign;


}
