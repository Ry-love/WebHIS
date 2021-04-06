package com.edu.service.Impl;

import com.edu.dao.*;
import com.edu.entity.*;
import com.edu.service.PrescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 *@PackageName:com.edu.service.Impl
 *@ClassName:PrescribeServiceImpl
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 17:04
 */
@Service
@Transactional
public class PrescribeServiceImpl implements PrescribeService {
    @Autowired
    private DrugstemplateDAO drugstemplateDAO;
    @Autowired
    private DrugsdetailedDAO drugsdetailedDAO;
    @Autowired
    private PrescriptionDAO prescriptionDAO;
    @Autowired
    private PrescriptiondetailedDAO prescriptiondetailedDAO;
    @Autowired
    private MedicalrecordDAO medicalrecordDAO;
    @Autowired
    private DrugsDAO drugsDAO;
    @Override
    public List<Drugstemplate> findTemplatesAll() {
        return drugstemplateDAO.findAll();
    }

    @Override
    public List<Drugstemplate> findDrugstemplatesByName(String checkName) {
        return drugstemplateDAO.findDrugstemplatesByName(checkName);
    }

    @Override
    public List<Drugsdetailed> findDrugsdetailedsByDrugsTempID_Id(Integer id) {
        return drugsdetailedDAO.findDrugsdetailedsByDrugsTempID_Id(id);
    }

    @Override
    public List<Prescription> findPrescriptionsByRegistID_Id(Integer id) {
        return prescriptionDAO.findPrescriptionsByRegistID_Id(id);
    }

    @Override
    public List<Prescriptiondetailed> findPrescriptiondetailedsByPrescriptionID_Id(Integer id) {
        return prescriptiondetailedDAO.findPrescriptiondetailedsByPrescriptionID_Id(id);
    }

    @Override
    public Prescription save(Prescription prescription) {
       return prescriptionDAO.save(prescription);
    }

    @Override
    public Medicalrecord findMedicalrecordByRegistID_Id(Integer id) {
        return medicalrecordDAO.findMedicalrecordByRegistID_Id(id);
    }

    @Override
    public List<Drugs> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return drugsDAO.findByPage(start,rows);
    }

    @Override
    public List<Drugs> findDrugsByMnemonicCode(String checkName) {
        return drugsDAO.findDrugsByMnemonicCode(checkName);
    }

    @Override
    public Long findTotals() {
        return drugsDAO.count();
    }

    @Override
    public void deleteCase(Integer id) {
        prescriptionDAO.deleteById(id);
    }

    @Override
    public void deletePrescriptiondetailedsByPrescriptionID_Id(Integer id) {
        prescriptiondetailedDAO.deletePrescriptiondetailedsByPrescriptionID_Id(id);
    }

    @Override
    public void savedetails(List<Prescriptiondetailed> prescriptionDetaileds) {
        prescriptiondetailedDAO.saveAll(prescriptionDetaileds);
    }

    @Override
    public void savedetail(Prescriptiondetailed prescriptionDetailed) {
        prescriptiondetailedDAO.save(prescriptionDetailed);
    }

    @Override
    public void deletedetail(Integer id) {
        prescriptiondetailedDAO.deleteById(id);
    }
}
