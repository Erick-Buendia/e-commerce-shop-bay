package com.erick_buendia.spring.app.ecommerceshopbay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "address_users")
public class AddressUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 15)
    private String estado;

    @NotBlank
    @Size(min = 1, max = 25)
    private String municipio;

    @NotNull
    @Max(value = 99999)
    @Column(name = "codigo_postal")
    private Integer codigoPosta;

    @NotBlank
    @Size(min = 1, max = 20)
    private String calle;

    @NotBlank
    @Size(min = 1, max = 6)
    @Column(name = "numero_interior")
    private String numeroInterior; 

    @Size(max = 5)
    @Column(name = "numero_exterior")
    private String numeroExterior;

    @Size(max = 100)
    private String descripcion;

    public AddressUsers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getCodigoPosta() {
        return codigoPosta;
    }

    public void setCodigoPosta(Integer codigoPosta) {
        this.codigoPosta = codigoPosta;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
