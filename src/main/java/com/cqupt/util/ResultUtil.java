package com.cqupt.util;

import com.cqupt.vo.Result;

/**
 * Created by 孙钰山 on 2019/2/26 0026.
 */
//返回工具类
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(){
        return error(500,"失败");
    }

}
