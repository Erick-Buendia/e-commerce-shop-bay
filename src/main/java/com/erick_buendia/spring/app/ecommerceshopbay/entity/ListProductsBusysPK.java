package com.erick_buendia.spring.app.ecommerceshopbay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ListProductsBusysPK {

    @Column(name = "producst_id")
    private Long producstId;

    @Column(name = "buys_id")
    private Long buysId;
}
