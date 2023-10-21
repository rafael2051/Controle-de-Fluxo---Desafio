package com.santanderdevweek2023.controller;

import com.santanderdevweek2023.model.Autor;
import com.santanderdevweek2023.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/find/all")
    public List<Autor> buscarTodos(){
        return autorRepository.findAll();
    }

    @GetMapping("/find/one/byid/{id}")
    public Autor buscarPorId(@PathVariable("id") Integer id){
        return autorRepository.findById(id).get();
    }

    @GetMapping("/find/one/bynome/{nome}")
    public Autor buscarPorNome(@PathVariable("nome") String nome){
        return autorRepository.findByNome(nome);
    }

    @GetMapping("/find/all/bynacionalidade/{nacionalidade}")
    public List<Autor> buscarPorNacionalidade(@PathVariable("nacionalidade")
                                              String nacionalidade){
        return autorRepository.findByNacionalidade(nacionalidade);
    }

    @PostMapping("/save")
    public void inserir(@RequestBody Autor autor){
        autorRepository.save(autor);
    }

    @PutMapping("/update/{id}")
    public void atualizar(@PathVariable("id") Integer id, @RequestBody Autor autor){
        if(autorRepository.findById(id) != null) {
            autorRepository.deleteById(id);
            autorRepository.save(autor);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable("id") Integer id){
        autorRepository.deleteById(id);
    }
}
