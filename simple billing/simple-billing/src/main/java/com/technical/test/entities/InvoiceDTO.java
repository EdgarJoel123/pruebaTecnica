package com.technical.test.entities;


import java.util.List;

public class InvoiceDTO {
    private List<InvoiceDetailEntity> details;

    public List<InvoiceDetailEntity> getDetails() {
        return details;
    }

    public void setDetails(List<InvoiceDetailEntity> details) {
        this.details = details;
    }
}