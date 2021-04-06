package com.edu.service.Impl;

import com.edu.dao.InvoiceDAO;
import com.edu.dao.RegisterDAO;
import com.edu.entity.Invoice;
import com.edu.entity.Register;
import com.edu.service.BackSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 *@PackageName:com.edu.service.Impl
 *@ClassName:BackSignServiceImpl
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-17 17:38
 */
@Service
@Transactional
public class BackSignServiceImpl implements BackSignService {
    @Autowired
    private RegisterDAO registerDAO;
    @Autowired
    private InvoiceDAO invoiceDAO;
    @Override
    public List<Register> findByPage(Integer page, Integer rows,Integer caseNumber) {
        int start = (page-1)*rows;
        return registerDAO.findByPage(caseNumber,start,rows);
    }

    @Override
    public Integer findTotals(Integer caseNumber) {
        return registerDAO.countAllByCaseNumber(caseNumber);
    }

    @Override
    public int findMaxCaseNum() {
        return invoiceDAO.findMaxInvoiceNum();
    }


}
