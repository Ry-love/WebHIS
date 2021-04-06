package com.edu.service.Impl;

import com.edu.dao.UserDAO;
import com.edu.entity.User;
import com.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/*
 *@PackageName:com.edu.service.Impl
 *@ClassName:UserService
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-14 15:47
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public User login(User user) {
        //根据用户输入的用户名进行查询
        User userDB =userDAO.findUserByUsername(user.getUsername());
        if(!ObjectUtils.isEmpty(userDB)){
            //比较密码
            if(userDB.getPassword().equals(user.getPassword())){
                return userDB;
            }else {
                throw new RuntimeException("密码输入不正确！");
            }
        }else{
            throw new RuntimeException("用户名输入错误！");
        }
    }
}
