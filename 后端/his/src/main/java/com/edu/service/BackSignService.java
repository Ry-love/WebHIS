package com.edu.service;

import com.edu.entity.Invoice;
import com.edu.entity.Register;

import java.util.List;

public interface BackSignService {
    //参数1：当前页 //参数2：每页显示的记录数
    List<Register> findByPage(Integer caseNumber,Integer page, Integer rows);

    //查询总条数
    Integer findTotals(Integer caseNumber);
    int findMaxCaseNum();

}
