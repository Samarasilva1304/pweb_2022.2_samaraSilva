package br.com.samara.cadpessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.samara.cadpessoas.model.Pessoa;

@Repository
public interface PessoaRepository
    extends JpaRepository<Pessoa, Long>{
    
}
