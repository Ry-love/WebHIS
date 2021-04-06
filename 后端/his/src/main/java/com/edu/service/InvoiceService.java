package com.edu.service;

import com.edu.entity.Invoice;

public interface InvoiceService {
     int findMaxInvoiceNum();
     Invoice saveInvoice(Invoice invoice);
     Invoice findInvoiceByRegistID_Id(Integer id);

}
