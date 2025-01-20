package com.technical.test.service;


import com.technical.test.entities.InvoiceDetailEntity;
import com.technical.test.entities.InvoiceEntity;
import com.technical.test.repository.InvoiceDetailRepository;
import com.technical.test.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    @Qualifier("invoiceRepository")
    private InvoiceRepository invoiceRepository;

    @Autowired
    @Qualifier("invoiceDetailRepository")
    private InvoiceDetailRepository detailRepository;

    @Transactional
    public InvoiceEntity createInvoice(Long customerId, List<InvoiceDetailEntity> details) {
        // Crear la factura
        InvoiceEntity invoice = new InvoiceEntity();
        invoice.setCustomerId(customerId); // Usar el nombre actualizado
        invoice.setInvoiceDate(LocalDateTime.now());

        // Calcular el total
        double total = details.stream().mapToDouble(d -> d.getUnitPrice() * d.getQuantity()).sum();
        invoice.setTotal(total);

        // Guardar la factura
        InvoiceEntity savedInvoice = invoiceRepository.save(invoice);

        // Asignar detalles de la factura
        details.forEach(detail -> {
            detail.setInvoiceId(savedInvoice.getInvoicesId()); // Usar el nombre actualizado
            detail.setTotal(detail.getUnitPrice() * detail.getQuantity());
            detailRepository.save(detail);
        });

        return savedInvoice;
    }
}