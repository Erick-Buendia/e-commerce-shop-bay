package com.erick_buendia.spring.app.ecommerceshopbay.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "list_products_busys")
public class ListProductsBusys implements Serializable {


    @EmbeddedId
    private ListProductsBusysPK id;

    @NotNull
    private int quantity;

    @NotNull
    @Column(name = "price_busys")
    private BigDecimal priceBusys;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceBusys() {
        return priceBusys;
    }

    public void setPriceBusys(BigDecimal priceBusys) {
        this.priceBusys = priceBusys;
    } 
    
    
}
