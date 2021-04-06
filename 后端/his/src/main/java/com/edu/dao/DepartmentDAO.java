package com.edu.dao;

import com.edu.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentDAO extends JpaRepository<Department,Integer> {
    List<Department> findDepartmentsByDeptCategoryID_Id(Integer id);
}
