package com.erick_buendia.spring.app.ecommerceshopbay.service;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.erick_buendia.spring.app.ecommerceshopbay.entity.AddressUsers;

public interface AddressUsersService {

    Optional<AddressUsers> findById(Long id);

    ResponseEntity<?> create(Long id, AddressUsers addressUsers);

    Optional<AddressUsers> update(Long id, AddressUsers addressUsers);

    Optional<AddressUsers> delete(Long id);
 
}
