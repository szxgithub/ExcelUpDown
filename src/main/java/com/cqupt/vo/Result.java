package com.cqupt.vo;

import lombok.Data;

/**
 * Created by 孙钰山 on 2019/2/26 0026.
 */
@Data
public class Result<T> {
    //状态码
    private Integer code;
    //提示信息
    private String msg;
    //具体数据
    private T data;
}
