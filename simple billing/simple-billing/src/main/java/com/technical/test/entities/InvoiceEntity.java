package com.technical.test.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "scheme_billing.scbi_invoices")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoices_seq")
    @SequenceGenerator(
            name = "invoices_seq",
            sequenceName = "scheme_billing.scbi_invoices_seq",
            schema = "scheme_billing",
            allocationSize = 1
    )
    @Column(name = "invoices_id")
    private Long invoicesId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "invoice_date", nullable = false)
    private LocalDateTime invoiceDate;

    @Column(name = "total", nullable = false)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, insertable = false, updatable = false)
    private CustomerEntity customer;

    // Getters and Setters

    public Long getInvoicesId() {
        return invoicesId;
    }

    public void setInvoicesId(Long invoicesId) {
        this.invoicesId = invoicesId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
