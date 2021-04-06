package com.edu.controller;

import com.edu.dao.UserDAO;
import com.edu.entity.User;
import com.edu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@PackageName:com.edu.controller
 *@ClassName:UserController
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-14 15:21
 */
@RestController
@CrossOrigin
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 处理用户登录
     */
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        try {
            User userDB = userService.login(user);
            map.put("status",true);
            map.put("msg","提示：登录成功");
            map.put("user",userDB);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",false);
            map.put("msg","提示："+e.getMessage());
        }
        return  map;
    }

}
