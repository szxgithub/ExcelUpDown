package com.cqupt.service;

import com.cqupt.vo.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 孙钰山 on 2019/2/25 0025.
 */

public interface IUserService {
    public Result excelImport(MultipartFile file);
    public void excelExport(HttpServletResponse response)throws IOException;
    public void previewExcel(MultipartFile file,HttpServletResponse response);
}
