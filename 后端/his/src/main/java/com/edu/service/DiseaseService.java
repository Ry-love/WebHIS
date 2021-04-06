package com.edu.service;

import com.edu.entity.Disease;

import java.util.List;

public interface DiseaseService {
    List<Disease> findDiseasesByDiseaseName(String diseaseName);
}
