package com.cody.fleetapp.services;

import com.cody.fleetapp.models.Invoice;
import com.cody.fleetapp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: ClientService
 * Package: com.cody.fleetapp.services
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:28
 * @Version: v1.0
 **/

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    // return list of invoices
    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    // save new invoice
    public void save(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    // get by id
    public Optional<Invoice> findById(int id){
        return invoiceRepository.findById(id);
    }

    // delete
    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }
    
}
