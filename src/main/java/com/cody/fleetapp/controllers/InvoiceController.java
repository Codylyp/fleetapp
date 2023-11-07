package com.cody.fleetapp.controllers;

import com.cody.fleetapp.models.Client;
import com.cody.fleetapp.models.Country;
import com.cody.fleetapp.models.Invoice;
import com.cody.fleetapp.models.InvoiceStatus;
import com.cody.fleetapp.services.ClientService;
import com.cody.fleetapp.services.CountryService;
import com.cody.fleetapp.services.InvoiceService;
import com.cody.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: InvoiceController
 * Package: com.cody.fleetapp.controllers
 * Description:
 *
 * @Author: Cody Liu
 * @Create: 2023/10/20 - 15:19
 * @Version: v1.0
 **/

@Controller
public class InvoiceController {
    
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/invoices")
    public String getInvoices(Model model){

        List<Invoice> invoiceList = invoiceService.getInvoices();
        model.addAttribute("invoices", invoiceList);

        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
        model.addAttribute("invoiceStatuses", invoiceStatusList);

        return "Invoice";
    }

    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping("invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(int id){
        return invoiceService.findById(id);
    }

    @RequestMapping(value = "/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
    
}
