package com.edu.service;

import com.edu.entity.Patientcosts;
import com.edu.entity.Prescriptiondetailed;

import java.util.List;

public interface TollService {
    List<Prescriptiondetailed> findPrescriptiondetailedsByPrescriptionID_RegistID_CaseNumber(Integer caseNumber);
    Integer findMaxInvoiceNum();
    void saveCosts(List<Patientcosts> list);
}
