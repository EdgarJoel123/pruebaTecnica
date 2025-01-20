package com.technical.test.entities;


import lombok.*;

import javax.persistence.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "scheme_billing.scbi_invoice_details")
public class InvoiceDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_detail_seq")
    @SequenceGenerator(
            name = "invoice_detail_seq",
            sequenceName = "scheme_billing.scbi_invoice_details_seq",
            schema = "scheme_billing",
            allocationSize = 1
    )
    @Column(name = "invoice_details_id")
    private Long invoiceDetailsId; // Sin "_"

    @Column(name = "invoice_id")
    private Long invoiceId; // Sin "_"

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false, insertable = false, updatable = false)
    private InvoiceEntity invoice;

    private Double total;


    // Getters and Setters

    public Long getInvoiceDetailsId() {
        return invoiceDetailsId;
    }

    public void setInvoiceDetailsId(Long invoiceDetailsId) {
        this.invoiceDetailsId = invoiceDetailsId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
