package com.example.demo.service.impl;

import com.example.demo.model.Autor;
import com.example.demo.model.Livro;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.LivroRepository;
import com.example.demo.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link AutorService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author rafael2051
 */

@Service
public class AutorServiceImpl implements AutorService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.
    @Override
    public List<Autor> buscarTodos() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> buscarPorId(Integer id) {
        return autorRepository.findById(id);
    }

    @Override
    public Autor buscarPorNome(String nome) {
        return autorRepository.findByNome(nome);
    }

    @Override
    public List<Autor> buscarPorNacionalidade(String nacionalide) {
        return autorRepository.findByNacionalidade(nacionalide);
    }

    @Override
    public List<Autor> buscarPorGenero(String genero) {

        List<Autor> lista_autor_genero = new LinkedList<Autor>();
        boolean contains;

        for(Livro livro : livroRepository.findByGenero(genero)){
            contains = false;
            Optional<Autor> autor = autorRepository.findById(livro.getAutor_id());

            // Temos que verificar se o autor já não foi adicionado em na lista
            // para não retornar autores repetidos
            for(Autor autor_aux : lista_autor_genero){
                if(autor_aux.getNome() == autor.get().getNome()){
                    contains = true;
                }
            }
            if(!contains){
                lista_autor_genero.add(autor.get());
            }
        }

        return lista_autor_genero;
    }

    @Override
    public void inserir(Autor autor) {

        boolean contains = false;
        for(Autor autor_aux : autorRepository.findAll()){
            if(autor_aux.getNome() == autor.getNome()){
                contains = true;
            }
        }

        if(!contains){
            autorRepository.save(autor);
        }
    }

    @Override
    public void atualizar(Integer id, Autor autor) {
        Optional<Autor> autorBd = autorRepository.findById(id);
        if(autorBd.isPresent()){
            autorRepository.deleteById(id);
            autorRepository.save(autor);
        }
    }

    @Override
    public void deletar(Integer id) {

        // Antes de remover o autor  da tabela de autores
        // vamos remover cada livro da tabela de livros
        // escrito por esse autor usando a chave
        // estrangeira autor_id nos livros
        for(Livro livro : livroRepository.findByAutor(id)){
            livroRepository.deleteById(livro.getTitulo());
        }
        autorRepository.deleteById(id);
    }

    public void limparTabela(){
        autorRepository.deleteAll();
    }
}
