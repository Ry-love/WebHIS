package com.edu.service.Impl;

import com.edu.dao.DiseaseDAO;
import com.edu.entity.Disease;
import com.edu.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 *@PackageName:com.edu.service.Impl
 *@ClassName:DiseaseServiceImpl
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-18 11:48
 */
@Service
@Transactional
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    private DiseaseDAO diseaseDAO;
    @Override
    public List<Disease> findDiseasesByDiseaseName(String diseaseName) {
        return diseaseDAO.findDiseasesByDiseaseName(diseaseName);
    }
}
