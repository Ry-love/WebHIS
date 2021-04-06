package com.edu.service;

import com.edu.entity.*;

import java.util.List;

public interface PrescribeService {
    List<Drugstemplate>  findTemplatesAll();
    List<Drugstemplate> findDrugstemplatesByName(String checkName);
    List<Drugsdetailed> findDrugsdetailedsByDrugsTempID_Id(Integer id);
    List<Prescription> findPrescriptionsByRegistID_Id(Integer id);
    List<Prescriptiondetailed> findPrescriptiondetailedsByPrescriptionID_Id(Integer id);
    Prescription save(Prescription prescription);
    Medicalrecord findMedicalrecordByRegistID_Id(Integer id);
    List<Drugs> findByPage(Integer page, Integer rows);
    List<Drugs> findDrugsByMnemonicCode(String checkName);
    //查询总条数
    Long findTotals();
    void deleteCase(Integer id);
    void deletePrescriptiondetailedsByPrescriptionID_Id(Integer id);
    void savedetails(List<Prescriptiondetailed> prescriptionDetaileds);
    void savedetail(Prescriptiondetailed prescriptionDetailed);
    void deletedetail(Integer id);
}
