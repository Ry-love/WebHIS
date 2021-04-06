package com.edu.service;

import com.edu.entity.*;

import java.util.List;

public interface RegisterService {
    int findMaxCaseNum();
    List<Constantitem> findConstantitemsByConstantTypeID(Integer id);
    List<Department> findDepartmentsByTypeId(Integer id);
    List<Registlevel> findAllRegistlevel();
    List<Settlecategory> findAllSettlecategory();
    List<User> findAllDocByDeptID(Integer levID,Integer deptID);
    List<Register> findRegistersByCaseNumber(Integer caseNumber);
    List<Register> findRegistersByUserID_Id(Integer id);
    List<Register> findRegistersByUserID_IdAndRealName(Integer id,String realName);
    int countAllByVisitStateAndUserID_Id(Integer state,Integer id);
    void save(Register register);

}
