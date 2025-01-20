package com.technical.test.controller;

import com.technical.test.entities.CustomerEntity;
import com.technical.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/invoice_form")
    public String invoiceForm(Model model) {
        List<CustomerEntity> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers); // Enviar clientes al modelo
        return "invoice_form"; // Nombre del archivo Thymeleaf
    }
}
