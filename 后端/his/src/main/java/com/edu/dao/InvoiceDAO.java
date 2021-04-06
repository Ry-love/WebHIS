package com.edu.dao;

import com.edu.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceDAO extends JpaRepository<Invoice,Integer> {
    @Query(value = "select max(invoice.invoiceNum) from invoice",nativeQuery = true)
    int findMaxInvoiceNum();

    Invoice findInvoiceByRegistID_Id(Integer id);
}
