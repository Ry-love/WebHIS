package com.edu.dao;

import com.edu.entity.Constantitem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConstantitemDAO  extends JpaRepository<Constantitem,Integer> {
    List<Constantitem> findConstantitemsByConstantTypeID_Id(Integer id);
}
