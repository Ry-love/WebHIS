package com.edu.dao;

import com.edu.entity.Drugsdetailed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugsdetailedDAO extends JpaRepository<Drugsdetailed,Integer> {
    List<Drugsdetailed> findDrugsdetailedsByDrugsTempID_Id(Integer id);
}
