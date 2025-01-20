package com.technical.test.controller;

import com.technical.test.entities.InvoiceDTO;
import com.technical.test.entities.InvoiceDetailEntity;
import com.technical.test.entities.InvoiceEntity;
import com.technical.test.service.CustomerService;
import com.technical.test.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public String createInvoice(@RequestParam Long customerId, @ModelAttribute InvoiceDTO invoiceDTO) {
        invoiceService.createInvoice(customerId, invoiceDTO.getDetails());
        return "redirect:/menu";
    }
}


