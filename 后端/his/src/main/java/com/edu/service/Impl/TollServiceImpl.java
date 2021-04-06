package com.edu.service.Impl;

import com.edu.dao.InvoiceDAO;
import com.edu.dao.PatientcostsDAO;
import com.edu.dao.PrescriptiondetailedDAO;
import com.edu.entity.Patientcosts;
import com.edu.entity.Prescriptiondetailed;
import com.edu.service.TollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 *@PackageName:com.edu.service.Impl
 *@ClassName:TollServiceImpl
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-19 14:58
 */
@Service
@Transactional
public class TollServiceImpl implements TollService {
    @Autowired
    private PrescriptiondetailedDAO prescriptiondetailedDAO;
    @Autowired
    private InvoiceDAO invoiceDAO;
    @Autowired
    private PatientcostsDAO patientcostsDAO;
    @Override
    public List<Prescriptiondetailed> findPrescriptiondetailedsByPrescriptionID_RegistID_CaseNumber(Integer caseNumber) {
        return prescriptiondetailedDAO.findPrescriptiondetailedsByPrescriptionID_RegistID_CaseNumber(caseNumber);
    }

    @Override
    public Integer findMaxInvoiceNum() {
        return invoiceDAO.findMaxInvoiceNum();
    }

    @Override
    public void saveCosts(List<Patientcosts> list) {
       patientcostsDAO.saveAll(list);
    }
}
