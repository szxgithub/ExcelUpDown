package com.cqupt.controller;

import cn.afterturn.easypoi.cache.manager.POICacheManager;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExcelToHtmlParams;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.cqupt.util.ResultUtil;
import com.cqupt.dao.UserMapper;
import com.cqupt.pojo.User;
import com.cqupt.service.IUserService;
import com.cqupt.vo.Result;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by 孙钰山 on 2019/2/25 0025.
 */
@ResponseBody
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private UserMapper userMapper;

    //导入Excel文件
    @RequestMapping(value = "/import",method = RequestMethod.POST)
    public Result excelImport(MultipartFile file) {
        return userService.excelImport(file);
    }

    //导出Excel文件
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public void excelExport(HttpServletResponse response){
        try {
            userService.excelExport(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //选择Excel文件预览
    @RequestMapping(value = "/view",method = RequestMethod.POST)
    public void previewExcel(MultipartFile file,HttpServletResponse response){
        userService.previewExcel(file,response);
    }

}
