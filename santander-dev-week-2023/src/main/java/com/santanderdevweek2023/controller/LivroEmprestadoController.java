package com.santanderdevweek2023.controller;

import com.santanderdevweek2023.model.LivroEmprestado;
import com.santanderdevweek2023.model.Usuario;
import com.santanderdevweek2023.repository.LivroEmprestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livrosemprestados")
public class LivroEmprestadoController {

    @Autowired
    private LivroEmprestadoRepository livroEmprestadoRepository;

    @GetMapping("/find/all")
    public List<LivroEmprestado> buscarTodos(){
        return livroEmprestadoRepository.findAll();
    }

    @DeleteMapping("/devolucao/{id_usuario}/{id_livro}")
    public void devolverLivro(@PathVariable("id_usuario") Integer id_usuario, @PathVariable("id_livro") Integer id_livro){
        livroEmprestadoRepository.deleteById(livroEmprestadoRepository.
                findByUsuarioIdAndLivroId(id_usuario, id_livro).getId());
    }
}
