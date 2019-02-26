package com.cqupt;

import com.cqupt.dao.UserMapper;
import com.cqupt.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 孙钰山 on 2019/2/25 0025.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestMyBatis {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMybatis(){
        int id = 1;
        User user = userMapper.selectUser(id);
        System.out.println(user);
    }

}
