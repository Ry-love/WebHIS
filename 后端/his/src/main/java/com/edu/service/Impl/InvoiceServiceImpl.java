package com.edu.service.Impl;

import com.edu.dao.InvoiceDAO;
import com.edu.entity.Invoice;
import com.edu.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 *@PackageName:com.edu.service.Impl
 *@ClassName:InvoiceServiceImpl
 *@Description:
 *@Author:Rylove
 *@Date:2020-7-16 23:11
 */
@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceDAO invoiceDAO;

    //返回最大发票号
    @Override
    public int findMaxInvoiceNum() {
        return invoiceDAO.findMaxInvoiceNum();
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceDAO.save(invoice);
    }

    @Override
    public Invoice findInvoiceByRegistID_Id(Integer id) {
        return invoiceDAO.findInvoiceByRegistID_Id(id);
    }
}
