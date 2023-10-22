package com.santanderdevweek2023.repository;

import com.santanderdevweek2023.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByNome(String nome);

}
