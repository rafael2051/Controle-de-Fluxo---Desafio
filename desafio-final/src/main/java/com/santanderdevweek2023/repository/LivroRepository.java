package com.santanderdevweek2023.repository;

import com.santanderdevweek2023.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    Livro findByTitulo(String titulo);

    List<Livro> findByAutor(Integer autor_id);

}
