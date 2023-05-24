package com.samaraSilva.biritaShop.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samaraSilva.biritaShop.model.Dependente;


@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {
  
}