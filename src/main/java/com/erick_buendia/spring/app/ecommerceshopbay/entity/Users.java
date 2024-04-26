package com.erick_buendia.spring.app.ecommerceshopbay.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    @Size(min = 5, max = 15)
    private String username;

    @NotBlank
    @Size(max = 60)
    private String passwoord;

    @NotBlank
    @Size(min = 1, max = 15)
    private String name;

    @NotBlank
    @Size(min = 1, max = 15)
    @Column(name = "last_name")
    private String lastName;

    @Email
    @Size(min = 1, max = 45)
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 10, max = 12)
    private String phone;

    private Boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<AddressUsers> addressUsers;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Roles> roles;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval =true)
    @JoinColumn(name = "user_id")
    private List<Buys> buys;

    public Users() {
    }

    public Users(String username, String passwoord, String name, String lastName, String email, String phone) {
        this.username = username;
        this.passwoord = passwoord;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswoord() {
        return passwoord;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<AddressUsers> getAddressUsers() {
        return addressUsers;
    }

    public void setAddressUsers(Set<AddressUsers> addressUsers) {
        this.addressUsers = addressUsers;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

}
