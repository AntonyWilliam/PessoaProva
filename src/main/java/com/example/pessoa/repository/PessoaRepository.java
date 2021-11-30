package com.example.pessoa.repository;

import com.example.pessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    //Todas as requisiçõs do banco feitas pelo service passarão pelo Repository
    Pessoa findByNome(String nome);
    Pessoa findByCurso(String curso);
    Pessoa deleteById(Long id);
}
