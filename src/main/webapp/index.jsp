<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<html lang="en">
<title>导入导出Excel</title>
<meta charset="UTF-8">
<body>
<form id="form1" method="post" action="/user/import" enctype="multipart/form-data">
    <div style="margin: 10px;" class="btn btn-primary">
        <input id="file" type="file" name="file"/>
        <input id="excel_button1" type="submit" value="导入" />
        <div >
        </div>
    </div>
</form>
<form id="form2" method="post" action="/user/view" enctype="multipart/form-data">
    <div style="margin: 10px;" class="btn btn-primary">
        <input id="view" type="file" name="file"/>
        <input id="excel_button2" type="submit" value="预览" />
        <div >
        </div>
    </div>
</form>
<form id="form3" method="Get" action="/user/export" enctype="multipart/form-data">
    <div style="margin: 10px;" class="btn btn-primary">
        <input id="excel_button3" type="submit" value="导出" />
    </div>
</form>
</body>
</html>
