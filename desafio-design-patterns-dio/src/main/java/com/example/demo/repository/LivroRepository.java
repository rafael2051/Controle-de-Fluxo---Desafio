package com.example.demo.repository;

import com.example.demo.model.Livro;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {

    List<Livro> findByAutor(Integer autor);

    List<Livro> findByQtde(Integer qtde);

    List<Livro> findByGenero(String genero);
}
