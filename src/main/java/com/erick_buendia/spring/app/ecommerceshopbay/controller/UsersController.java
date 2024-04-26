package com.erick_buendia.spring.app.ecommerceshopbay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.AddressUsers;
import com.erick_buendia.spring.app.ecommerceshopbay.entity.Users;
import com.erick_buendia.spring.app.ecommerceshopbay.service.AddressUsersService;
import com.erick_buendia.spring.app.ecommerceshopbay.service.UsersService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/user")
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    AddressUsersService addressUsersService;

    @GetMapping()
    public List<Users> getUser() {
        return usersService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<Users> user = usersService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> postAddUser(@Valid @RequestBody Users user, BindingResult error) {
        if (error.hasFieldErrors()) {
            return validation(error);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putMethodName(@Valid @PathVariable Long id, @RequestBody Users users, BindingResult error) {
        if (error.hasFieldErrors()) {
            return validation(error);
            
        }
        Optional<Users> user = usersService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(usersService.update(id, users));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<Users> user = usersService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(usersService.delete(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/direccion/{id}")
    public ResponseEntity<?> postAddressUser(@Valid @PathVariable Long id, @RequestBody AddressUsers addressUsers, BindingResult error) {
        if (error.hasFieldErrors()) {
            return validation(error);
            
        }
        return addressUsersService.create(id, addressUsers);
    }

    @PutMapping("/direccion/{id}")
    public ResponseEntity<?> updateAddrees(@Valid @PathVariable Long id, @RequestBody AddressUsers addressUsers, BindingResult error) {
        if (error.hasFieldErrors()) {
            return validation(error);
            
        }
        Optional<AddressUsers> address = addressUsersService.findById(id);
        if (address.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addressUsersService.update(id, addressUsers));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/direccion/{id}")
    public ResponseEntity<?> deleteDireccionUser(@PathVariable Long id) {
        Optional<AddressUsers> addressUser = addressUsersService.findById(id);
        if (addressUser.isPresent()) {
            return ResponseEntity.ok(addressUsersService.delete(id));
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getField() + " " + error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
