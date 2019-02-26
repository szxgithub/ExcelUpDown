<<<<<<< HEAD
## 项目介绍
---
开发人员：孙钰山
开发工具：idea2015
框架技术：SPring + SpringMVC + MyBatis + easyPoi
时间：2019-02-25

---

>本项目实现了Excel文件的导入、导出、在线预览
导入从磁盘导入Excel文件，Excel文件格式列字段需要与数据库表对应
即实体类对应表关系
导出从数据库中将表中所有记录导出成Excel文件
在线预览即浏览器加载Excel文件，渲染出HTML页面

---
部署说明：
idea导入项目，打开整个项目文件夹或者pom.xml文件

创建数据库uploadexcel,建表如下:
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

配置Tomcat启动项目即可

---

=======
