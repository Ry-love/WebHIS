package com.edu.dao;

import com.edu.entity.Medicalrecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalrecordDAO extends JpaRepository<Medicalrecord,Integer> {
    Medicalrecord findMedicalrecordByRegistID_Id(Integer id);
}
