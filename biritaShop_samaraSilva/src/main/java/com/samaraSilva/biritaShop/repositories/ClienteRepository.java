package com.samaraSilva.biritaShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samaraSilva.biritaShop.model.Cliente;


public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
    
}