package com.edu.dao;


import com.edu.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegisterDAO extends JpaRepository<Register,Integer> {
    @Query(value = "select max(register.caseNumber) from register",nativeQuery = true)
    int findMaxCaseNum();

    int countAllByVisitStateAndUserID_Id(Integer state,Integer id);

    List<Register> findRegistersByCaseNumber(Integer caseNumber);

    //分页查询接口
    @Query(value = "select * from register where caseNumber = ? limit ?,? ",nativeQuery = true)
    List<Register> findByPage(Integer caseNumber,Integer start,Integer rows);

    //分页查询总数据
    int countAllByCaseNumber(Integer caseNumber);

    List<Register> findRegistersByUserID_Id(Integer id);
    List<Register> findRegistersByUserID_IdAndRealName(Integer id,String realName);
}
