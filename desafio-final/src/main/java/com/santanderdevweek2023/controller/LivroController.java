package com.santanderdevweek2023.controller;

import com.santanderdevweek2023.model.Livro;
import com.santanderdevweek2023.repository.AutorRepository;
import com.santanderdevweek2023.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/find/all")
    public List<Livro> buscarTodos(){
        return livroRepository.findAll();
    }

    @GetMapping("/find/one/byid/{id}")
    public Livro buscarPorId(@PathVariable("id") Integer id){
        return livroRepository.findById(id).get();
    }

    @GetMapping("/find/one/bytitulo/{titulo}")
    public Livro buscarPorTitulo(@PathVariable("titulo") String titulo){
        return livroRepository.findByTitulo(titulo);
    }

    @GetMapping("/find/all/byautor/{autor}")
    public List<Livro> buscarPorAutor(@PathVariable("autor") String autor){
        return livroRepository.findByAutor(autorRepository.findByNome(autor).getId());
    }


    @PostMapping("/save")
    public void inserir(@RequestBody Livro livro){
        livroRepository.save(livro);
    }

    @PutMapping("/update/{id}")
    public void atualizar(@PathVariable("id") Integer id,
                          @RequestBody Livro livro){
        if(livroRepository.findById(id) != null){
            livroRepository.deleteById(id);
            livroRepository.save(livro);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable("titulo") Integer id){
        livroRepository.deleteById(id);
    }

}
