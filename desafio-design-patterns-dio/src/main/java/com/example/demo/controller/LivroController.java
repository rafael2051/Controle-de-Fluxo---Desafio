package com.example.demo.controller;

import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;
import com.example.demo.service.LivroService;
import com.example.demo.service.impl.LivroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Querys utilizando tanto a tabela de livros
 * quanto a tabela de autores) e operções necessárias para salvar e buscar
 * dados em uma interface simples e coesa (API REST).
 *
 * @author rafael2051
 */

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/find/all")
    public List<Livro> buscarTodos(){
        return livroService.buscarTodos();
    }

    @GetMapping("/find/one/bytitulo/{titulo}")
    public Livro buscarPorId(@PathVariable("titulo") String titulo){
        return livroService.buscarPorId(titulo).get();
    }

    @GetMapping("/find/all/byautor/{autor}")
    public List<Livro> buscarPorAutor(@PathVariable("autor") String autor){
        return livroService.buscarPorAutor(autor);
    }

    @GetMapping("/find/all/bynacionalidadeautor/{nacionalidade}")
    public List<Livro> buscarPorNacionalidadeAutor(@PathVariable("nacionalidade")
                                                       String nacionalidade){
        return livroService.buscarPorNacionalidadeAutor(nacionalidade);
    }

    @GetMapping("find/all/byqtde/{qtde}")
    public List<Livro> buscarPorQtde(@PathVariable("qtde") Integer qtde){
        return livroService.buscarPorQtde(qtde);
    }

    @PostMapping("/save")
    public void inserir(@RequestBody Livro livro){
        livroService.inserir(livro);
    }

    @PutMapping("/update/{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Livro livro){
        livroService.atualizar(id, livro);
    }

    @DeleteMapping("/delete/{titulo}")
    public void deletar(@PathVariable("titulo") String titulo){
        livroService.deletar(titulo);
    }

}
