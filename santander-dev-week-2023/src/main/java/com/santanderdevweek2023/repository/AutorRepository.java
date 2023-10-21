package com.santanderdevweek2023.repository;

import com.santanderdevweek2023.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

    Autor findByNome(String nome);

    List<Autor> findByNacionalidade(String nacionalidade);
}
