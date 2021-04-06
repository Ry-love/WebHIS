package com.edu.dao;

import com.edu.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiseaseDAO extends JpaRepository<Disease,Integer> {
    //分页查询接口
    @Query(value = "select * from disease limit ?,? ",nativeQuery = true)
    List<Disease> findByPage(Integer start, Integer rows);

    List<Disease> findDiseasesByDiseaseName(String diseaseName);
}
