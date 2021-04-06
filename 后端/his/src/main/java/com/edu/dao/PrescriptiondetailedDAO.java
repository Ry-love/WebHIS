package com.edu.dao;

import com.edu.entity.Prescriptiondetailed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptiondetailedDAO extends JpaRepository<Prescriptiondetailed,Integer> {
    List<Prescriptiondetailed> findPrescriptiondetailedsByPrescriptionID_Id(Integer id);
    void deletePrescriptiondetailedsByPrescriptionID_Id(Integer id);
    List<Prescriptiondetailed> findPrescriptiondetailedsByPrescriptionID_RegistID_CaseNumber(Integer caseNumber);
}
