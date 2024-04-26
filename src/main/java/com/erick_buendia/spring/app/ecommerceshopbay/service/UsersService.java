package com.erick_buendia.spring.app.ecommerceshopbay.service;

import java.util.List;
import java.util.Optional;
import com.erick_buendia.spring.app.ecommerceshopbay.entity.Users;

public interface UsersService {

    List<Users> findAll();

    Optional<Users> findById(Long id);

    Users save(Users users);

    Optional<Users> update(Long id, Users users);

    Optional<Users> delete(Long id);
}

