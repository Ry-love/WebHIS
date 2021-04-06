package com.edu.dao;

import com.edu.entity.Drugstemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugstemplateDAO extends JpaRepository<Drugstemplate,Integer> {
    List<Drugstemplate> findDrugstemplatesByName(String checkName);
}
