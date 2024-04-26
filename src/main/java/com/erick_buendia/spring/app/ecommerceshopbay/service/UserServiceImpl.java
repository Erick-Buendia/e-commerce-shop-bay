package com.erick_buendia.spring.app.ecommerceshopbay.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.Roles;
import com.erick_buendia.spring.app.ecommerceshopbay.entity.Users;
import com.erick_buendia.spring.app.ecommerceshopbay.repository.RolesRepository;
import com.erick_buendia.spring.app.ecommerceshopbay.repository.UsersRepository;

@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    UsersRepository repository;

    @Autowired
    RolesRepository rolesRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Users> findAll() {
        return (List<Users>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Users> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Users save(Users users) {
        Optional<Roles> roles = rolesRepository.findByName("ROLE_USER");
        roles.ifPresent(rol -> {
            Set<Roles> rolAdd = new HashSet<>();
            rolAdd.add(rol);
            users.setRoles(rolAdd);
        });

        return repository.save(users);
    }

    @Transactional
    @Override
    public Optional<Users> update(Long id, Users users) {

        Optional<Users> userDb = repository.findById(id);
        if (userDb.isPresent()) {
            Users usersUpdate = userDb.orElseThrow();
            usersUpdate.setName(users.getName());
            usersUpdate.setLastName(users.getLastName());
            usersUpdate.setPhone(users.getPhone());
            return Optional.of(repository.save(usersUpdate));
        }
        return userDb;
    }

    @Transactional
    @Override
    public Optional<Users> delete(Long id) {
        Optional<Users> userdb = repository.findById(id);
        if (userdb.isPresent()) {
            repository.delete(userdb.orElseThrow());
        }
        return userdb;
    }

}
