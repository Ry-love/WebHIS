package com.edu.dao;

import com.edu.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionDAO extends JpaRepository<Prescription,Integer> {
    List<Prescription> findPrescriptionsByRegistID_Id(Integer id);
}
