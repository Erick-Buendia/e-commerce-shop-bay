package com.erick_buendia.spring.app.ecommerceshopbay.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.Roles;


public interface RolesRepository  extends CrudRepository<Roles, Long>{

    Optional<Roles> findByName(String name);
}
