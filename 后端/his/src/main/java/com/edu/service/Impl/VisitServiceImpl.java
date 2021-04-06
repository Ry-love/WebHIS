package com.edu.service.Impl;

import com.edu.dao.DiseaseDAO;
import com.edu.dao.MedicaldiseaseDAO;
import com.edu.dao.MedicalrecordDAO;
import com.edu.entity.Disease;
import com.edu.entity.Medicaldisease;
import com.edu.entity.Medicalrecord;
import com.edu.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 *@PackageName:com.edu.service.Impl
 *@ClassName:VisitServiceImpl
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 10:48
 */
@Service
@Transactional
public class VisitServiceImpl implements VisitService {
    @Autowired
    private DiseaseDAO diseaseDAO;
    @Autowired
    private MedicaldiseaseDAO medicaldiseaseDAO;
    @Autowired
    private MedicalrecordDAO medicalrecordDAO;
    @Override
    public List<Disease> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return diseaseDAO.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return diseaseDAO.count();
    }

    @Override
    public void saveMedicalRecord(Medicalrecord medicalrecord) {
        medicalrecordDAO.save(medicalrecord);
    }

    @Override
    public void saveMedicalDisease(Medicaldisease medicaldisease) {
        medicaldiseaseDAO.save(medicaldisease);
    }

    @Override
    public Medicaldisease findByRegistId(Integer id) {
        return medicaldiseaseDAO.findMedicaldiseaseByRegistID_Id(id);
    }
}
