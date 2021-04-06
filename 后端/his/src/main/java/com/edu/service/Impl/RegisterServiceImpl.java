package com.edu.service.Impl;

import com.edu.dao.*;
import com.edu.entity.*;
import com.edu.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 *@PackageName:com.edu.service.Impl
 *@ClassName:RegisterServiceImpl
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-16 23:19
 */
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDAO registerDAO;
    @Autowired
    private ConstantitemDAO constantitemDAO;
    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private RegistelevelDAO registelevelDAO;
    @Autowired
    private SettlecategoryDAO settlecategoryDAO;
    @Autowired
    private UserDAO userDAO;
    @Override
    public int findMaxCaseNum() {
        return registerDAO.findMaxCaseNum();
    }

    @Override
    public List<Constantitem> findConstantitemsByConstantTypeID(Integer id) {
        return constantitemDAO.findConstantitemsByConstantTypeID_Id(id);
    }

    @Override
    public List<Department> findDepartmentsByTypeId(Integer id) {
        return departmentDAO.findDepartmentsByDeptCategoryID_Id(id);
    }

    @Override
    public List<Registlevel> findAllRegistlevel() {
        return registelevelDAO.findAll();
    }

    @Override
    public List<Settlecategory> findAllSettlecategory() {
        return settlecategoryDAO.findAll();
    }

    @Override
    public List<User> findAllDocByDeptID(Integer levID,Integer deptID) {
        return userDAO.findUsersByRegistLeID_IdAndDeptID_Id(levID,deptID);
    }

    @Override
    public List<Register> findRegistersByCaseNumber(Integer caseNumber) {
        return registerDAO.findRegistersByCaseNumber(caseNumber);
    }

    @Override
    public List<Register> findRegistersByUserID_Id(Integer id) {
        return registerDAO.findRegistersByUserID_Id(id);
    }

    @Override
    public List<Register> findRegistersByUserID_IdAndRealName(Integer id, String realName) {
        return registerDAO.findRegistersByUserID_IdAndRealName(id,realName);
    }

    @Override
    public int countAllByVisitStateAndUserID_Id(Integer state, Integer id) {
        return registerDAO.countAllByVisitStateAndUserID_Id(state,id);
    }

    @Override
    public void save(Register register) {
        registerDAO.save(register);
    }


}
