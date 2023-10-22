package com.santanderdevweek2023.repository;

import com.santanderdevweek2023.model.Livro;
import com.santanderdevweek2023.model.LivroEmprestado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroEmprestadoRepository extends JpaRepository<LivroEmprestado, Integer> {

    List<LivroEmprestado> findAllByUsuarioId(Integer id);

    LivroEmprestado findByUsuarioIdAndLivroId(Integer usuarioId, Integer livroId);

}
