package com.erick_buendia.spring.app.ecommerceshopbay.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erick_buendia.spring.app.ecommerceshopbay.entity.AddressUsers;
import com.erick_buendia.spring.app.ecommerceshopbay.entity.Users;
import com.erick_buendia.spring.app.ecommerceshopbay.repository.AddreesUsersRepository;
import com.erick_buendia.spring.app.ecommerceshopbay.repository.UsersRepository;

@Service
public class AddressUsersServiceImpl implements AddressUsersService {

    @Autowired
    AddreesUsersRepository repository;

    @Autowired
    UsersRepository usersRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<AddressUsers> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public ResponseEntity<?> create(Long id, AddressUsers addressUsers) {
        Optional<Users> user = usersRepository.findById(id);
        if (user.isPresent()) {
            Users userAddressAdd = user.orElseThrow();
            userAddressAdd.getAddressUsers().add(addressUsers);
            return ResponseEntity.status(HttpStatus.CREATED).body(usersRepository.save(userAddressAdd));
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @Override
    public Optional<AddressUsers> update(Long id, AddressUsers addressUsers) {
        Optional<AddressUsers> addressDb = repository.findById(id);
        if (addressDb.isPresent()) {
            AddressUsers addressUsersAdd = addressDb.orElseThrow();
            addressUsersAdd.setEstado(addressUsers.getEstado());
            addressUsersAdd.setMunicipio(addressUsers.getMunicipio());
            addressUsersAdd.setCodigoPosta(addressUsers.getCodigoPosta());
            addressUsersAdd.setCalle(addressUsers.getCalle());
            addressUsersAdd.setNumeroExterior(addressUsers.getNumeroExterior());
            addressUsersAdd.setNumeroExterior(addressUsers.getNumeroExterior());
            addressUsersAdd.setDescripcion(addressUsers.getDescripcion());
            repository.save(addressUsersAdd);
        }

        return addressDb;
    }

    @Transactional
    @Override
    public Optional<AddressUsers> delete(Long id) {
        Optional<AddressUsers> addressDb = repository.findById(id);
        if (addressDb.isPresent()) {
            repository.delete(addressDb.orElseThrow());
        }
        return addressDb;
    }

}
