package com.erick_buendia.spring.app.ecommerceshopbay.entity;

import java.sql.Date;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "buys")
public class Buys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_busys")
    private Date dateBusys;

    private Date deadile;

    private boolean delivered;


    // @ManyToMany(cascade = CascadeType.ALL)
    // @JoinTable(
    //     name = "list_products_busys"
    //    // joinColumns = @JoinColumn(name = ""),

    // )
    // private Set<Products> products;

    

    public Buys() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateBusys() {
        return dateBusys;
    }

    public void setDateBusys(Date dateBusys) {
        this.dateBusys = dateBusys;
    }

    public Date getDeadile() {
        return deadile;
    }

    public void setDeadile(Date deadile) {
        this.deadile = deadile;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }


    

}
