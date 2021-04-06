package com.edu.dao;

import com.edu.entity.Disease;
import com.edu.entity.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrugsDAO extends JpaRepository<Drugs,Integer> {
    //分页查询接口
    @Query(value = "select * from drugs limit ?,? ",nativeQuery = true)
    List<Drugs> findByPage(Integer start, Integer rows);

    List<Drugs> findDrugsByMnemonicCode(String checkName);
}
