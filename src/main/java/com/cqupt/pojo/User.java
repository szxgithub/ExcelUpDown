package com.cqupt.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by 孙钰山 on 2019/2/25 0025.
 */
@ExcelTarget("user")
@Data
public class User implements Serializable{
    @Excel(name = "UID")
    private Integer id;
    @Excel(name = "用户名")
    private String username;
    @Excel(name = "密码")
    private String password;
}
