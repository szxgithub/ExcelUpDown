package com.cqupt.dao;

import com.cqupt.pojo.User;

import java.util.List;

/**
 * Created by 孙钰山 on 2019/2/25 0025.
 */
public interface UserMapper {
    User selectUser(Integer id);
    List<User> selectAllUser();
    public boolean importUser(List<User> userList);
}
