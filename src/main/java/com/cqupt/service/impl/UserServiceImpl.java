package com.cqupt.service.impl;

import cn.afterturn.easypoi.cache.manager.POICacheManager;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExcelToHtmlParams;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.cqupt.dao.UserMapper;
import com.cqupt.pojo.User;
import com.cqupt.service.IUserService;
import com.cqupt.util.ResultUtil;
import com.cqupt.vo.Result;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by 孙钰山 on 2019/2/25 0025.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public Result excelImport(MultipartFile file){
        List<User> userList = null;
        try {
            userList = ExcelImportUtil.importExcel(file.getInputStream(), User.class, new ImportParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (User user : userList) {
            System.out.println(user);
        }
        boolean flag = userMapper.importUser(userList);
        if (flag) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error();
        }
    }

    @Override
    public void excelExport(HttpServletResponse response) throws IOException {
        List<User> userList = userMapper.selectAllUser();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("账户信息表",""),User.class,userList);

        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("用户数据表","UTF-8") + ".xls");
        //编码
        response.setCharacterEncoding("UTF-8");
        workbook.write(response.getOutputStream());
    }

    @Override
    public void previewExcel(MultipartFile file,HttpServletResponse response){
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!inputStream.markSupported()) {
            inputStream = new PushbackInputStream(inputStream, 8);
        }
        try{
            if (POIFSFileSystem.hasPOIFSHeader(inputStream)) {
                System.out.println("2003及以下");
                ExcelToHtmlParams params = new ExcelToHtmlParams(WorkbookFactory.create(inputStream),true,"yes");
                response.getOutputStream().write(ExcelXorHtmlUtil.excelToHtml(params).getBytes());
            }else {
                System.out.println("2007及以上");
                ExcelToHtmlParams params = new ExcelToHtmlParams(WorkbookFactory.create(inputStream));
                response.getOutputStream().write(ExcelXorHtmlUtil.excelToHtml(params).getBytes());
            }
        }catch(IOException e){
            e.printStackTrace();
        }catch(InvalidFormatException e){
            e.printStackTrace();
        }
    }

    /**
     * 07 版本EXCEL预览
     */
    public void toHtmlOf07Base(HttpServletResponse response) throws IOException, InvalidFormatException {
        ExcelToHtmlParams params = new ExcelToHtmlParams(WorkbookFactory.create(POICacheManager.getFile("exceltohtml/testExportTitleExcel.xlsx")));
        response.getOutputStream().write(ExcelXorHtmlUtil.excelToHtml(params).getBytes());
    }

    /**
     * 03 版本EXCEL预览
     */
    public void toHtmlOf03Img(HttpServletResponse response) throws IOException, InvalidFormatException {
        ExcelToHtmlParams params = new ExcelToHtmlParams(WorkbookFactory.create(POICacheManager.getFile("exceltohtml/exporttemp_img.xls")),true,"yes");
        response.getOutputStream().write(ExcelXorHtmlUtil.excelToHtml(params).getBytes());
    }
}
