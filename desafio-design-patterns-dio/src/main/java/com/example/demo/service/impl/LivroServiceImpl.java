package com.example.demo.service.impl;

import com.example.demo.model.Autor;
import com.example.demo.model.Livro;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.LivroRepository;
import com.example.demo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link LivroService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired ). Com isso, como essa classe é um
 * {@link Service }, ela será tratada como um <b>Singleton</b>.
 *
 * @author rafael2051
 */

@Service
public class LivroServiceImpl implements LivroService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    LivroRepository livroRepository;
    @Autowired
    AutorRepository autorRepository;

    @Override
    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    @Override
    public Optional<Livro> buscarPorId(String titulo) {
        return livroRepository.findById(titulo);
    }

    @Override
    public List<Livro> buscarPorAutor(String autor) {
        return livroRepository.findByAutor(autorRepository.findByNome(autor).getId());
    }

    @Override
    public List<Livro> buscarPorNacionalidadeAutor(String nacionalidade){

        // Aqui instanciamos uma linked list que recerá com todos os livros de
        // autores com a nacionalidade especificada. O motivo para usarmos
        // uma lista ligada é que só faremos inserções nessa lista, e a
        // a complexidade temporal de inserção em uma lista ligada é
        // O(1). Dessa forma, o procedimento fica mais eficiente
        List<Livro> lista_livro_nacionalidade = new LinkedList<>();

        // O método findByNacionalidade de autorRepository retorna todos autores
        // com a nacionalidade especificada. Devemos então percorrer cada autor
        // e usar o método findByAutor_id para retornar todos livros do autor
        // em uma lista auxiliar, e então adicionar esses livros em
        // lista_livro
        for(Autor autor : autorRepository.findByNacionalidade(nacionalidade)){
            List<Livro> lista_livro_autor = livroRepository.findByAutor(autor.getId());

            for(Livro livro : lista_livro_autor){
                lista_livro_nacionalidade.add(livro);
            }

        }

        return lista_livro_nacionalidade;
    }

    @Override
    public List<Livro> buscarPorQtde(Integer qtde) {
        return livroRepository.findByQtde(qtde);
    }

    @Override
    public List<Livro> buscarPorGenero(String genero) {
        return livroRepository.findByGenero(genero);
    }

    @Override
    public void inserir(Livro livro) {
        livroRepository.save(livro);
    }

    @Override
    public void atualizar(String titulo, Livro livro) {
        Optional<Livro> livroBd = livroRepository.findById(titulo);
        if(livroBd.isPresent()){
            livroRepository.deleteById(titulo);
            livroRepository.save(livro);
        }
    }

    @Override
    public void deletar(String titulo) {
        livroRepository.deleteById(titulo);
    }

    public void limparTabela(){
        livroRepository.deleteAll();
    }
}
