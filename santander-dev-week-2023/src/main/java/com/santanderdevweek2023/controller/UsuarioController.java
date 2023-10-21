package com.santanderdevweek2023.controller;

import com.santanderdevweek2023.model.Livro;
import com.santanderdevweek2023.model.LivroEmprestado;
import com.santanderdevweek2023.model.Usuario;
import com.santanderdevweek2023.repository.LivroEmprestadoRepository;
import com.santanderdevweek2023.repository.LivroRepository;
import com.santanderdevweek2023.repository.UsuarioRepository;
import com.santanderdevweek2023.service.IdLivroEmprestadoGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroEmprestadoRepository livroEmprestadoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private IdLivroEmprestadoGenerator idLivroEmprestadoGenerator;

    @GetMapping("/find/all")
    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/find/one/byid/{id}")
    public Usuario buscarPorId(@Param("id") Integer id){
        return usuarioRepository.findById(id).get();
    }

    @GetMapping("/find/one/bynome/{nome}")
    public Usuario buscarPorNome(@Param("nome") String nome){
        return usuarioRepository.findByNome(nome);
    }

    @GetMapping("find/all/livros_emprestados/{id}")
    public List<Livro> buscarLivrosEmprestados(@PathVariable("id") Integer id){
        List<Livro> lista_livros_emprestados = new ArrayList<>();
        for(LivroEmprestado livroEmprestado : livroEmprestadoRepository.findAllByUsuarioId(id)){
            lista_livros_emprestados.add(
                    livroRepository.findById(livroEmprestado.getLivroId()).get() );
        }

        return lista_livros_emprestados;
    }

    @PostMapping("pegar_emprestado/{id}/{titulo}")
    public void pegarEmprestado(@PathVariable("id") Integer id, @PathVariable("titulo") String titulo){
        LivroEmprestado livroEmprestado = new LivroEmprestado();
        livroEmprestado.setId(idLivroEmprestadoGenerator.getNextId());
        livroEmprestado.setUsuarioId(id);
        livroEmprestado.setLivroId(livroRepository.findByTitulo(titulo).getId());
        livroEmprestadoRepository.save(livroEmprestado);
    }
}
