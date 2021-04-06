package com.edu.dao;

import com.edu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer> {
    List<User> findUsersByRegistLeID_IdAndDeptID_Id(Integer levID,Integer deptID);
    User findUserByUsername(String username);
}
