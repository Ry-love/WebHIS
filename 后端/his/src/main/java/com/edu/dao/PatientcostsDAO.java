package com.edu.dao;

import com.edu.entity.Patientcosts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientcostsDAO extends JpaRepository<Patientcosts,Integer> {
}
