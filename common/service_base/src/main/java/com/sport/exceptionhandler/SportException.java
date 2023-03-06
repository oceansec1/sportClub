package com.sport.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor  //生成无参数构造方法
public class SportException extends RuntimeException{
    //状态码
    private Integer code;
    //异常信息
    private String msg;

}
