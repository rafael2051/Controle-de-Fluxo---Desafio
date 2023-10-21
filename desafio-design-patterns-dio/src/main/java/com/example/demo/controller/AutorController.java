package com.example.demo.controller;

import com.example.demo.model.Autor;
import com.example.demo.service.AutorService;
import com.example.demo.service.impl.AutorServiceImpl;
import com.example.demo.repository.AutorRepository;
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
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/find/all")
    public List<Autor> buscarTodos(){
        return autorService.buscarTodos();
    }

    @GetMapping("/find/one/byid/{id}")
    public Autor buscarPorId(@PathVariable("id") Integer id){
        return autorService.buscarPorId(id).get();
    }

    @GetMapping("/find/one/bynome/{nome}")
    public Autor buscarPorNome(@PathVariable("nome") String nome){
        return autorService.buscarPorNome(nome);
    }

    @GetMapping("/find/all/bynacionalidade/{nacionalidade}")
    public List<Autor> buscarPorNacionalidade(@PathVariable("nacionalidade")
                                              String nacionalidade){
        return autorService.buscarPorNacionalidade(nacionalidade);
    }

    @GetMapping("find/all/byqtde/{genero}")
    public List<Autor> buscarPorGenero(@PathVariable("genero") String genero){
        return autorService.buscarPorGenero(genero);
    }

    @PostMapping("/save")
    public void inserir(@RequestBody Autor autor){
        autorService.inserir(autor);
    }

    @PutMapping("/update/{id}")
    public void atualizar(@PathVariable("id") Integer id, @RequestBody Autor autor){
        autorService.atualizar(id, autor);
    }

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable("id") Integer id){
        autorService.deletar(id);
    }

}
