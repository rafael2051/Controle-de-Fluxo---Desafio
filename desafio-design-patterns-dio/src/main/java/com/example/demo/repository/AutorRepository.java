package com.example.demo.repository;

import com.example.demo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    Autor findByNome(String nome);

    List<Autor> findByNacionalidade(String nacionalidade);
}
