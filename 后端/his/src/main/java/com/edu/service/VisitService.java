package com.edu.service;

import com.edu.entity.Disease;
import com.edu.entity.Medicaldisease;
import com.edu.entity.Medicalrecord;

import java.util.List;

public interface VisitService {
    //参数1：当前页 //参数2：每页显示的记录数
    List<Disease> findByPage(Integer page, Integer rows);

    //查询总条数
    Long findTotals();

    void saveMedicalRecord(Medicalrecord medicalrecord);
    void saveMedicalDisease(Medicaldisease medicaldisease);

    Medicaldisease findByRegistId(Integer id);
}
