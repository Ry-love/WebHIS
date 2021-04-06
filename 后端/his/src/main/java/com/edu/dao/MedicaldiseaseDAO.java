package com.edu.dao;

import com.edu.entity.Medicaldisease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicaldiseaseDAO extends JpaRepository<Medicaldisease,Integer> {
    Medicaldisease findMedicaldiseaseByRegistID_Id(Integer id);
}
