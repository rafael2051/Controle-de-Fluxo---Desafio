package com.example.demo.service;

import com.example.demo.model.Livro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio do livro. Dessa
 * forma, caso nos seja conveniente, poderemos criar várias implementações
 * para serem injetadas posteriormente no contexto.
 *
 * @author rafael2051
 */

public interface LivroService {
    /**
     * Método que busca todos os livros no db
     * @return List<Livro>
     */
    List<Livro> buscarTodos();

    /**
     * Método que busca um livro pelo seu id
     *
     * @return Livro
     */
    Optional<Livro> buscarPorId(String titulo);

    /**
     * Método que busca todos os livros com o autor
     * especificado. Aqui temos uma integração
     * com o sistema responsável pela tabela
     * do autor e usaremos o padrão facade
     * para criar uma abstração ao usuário
     * @return List<Livro>
     */
    List<Livro> buscarPorAutor(String autor);

    /**
     * Método que retorna uma lista de todos livros no db
     * escritos por autores de nacionalidade x. Outra vez
     * ytilizamos o padrão facade para integrar os dois
     * sistemas e fornecer uma abstração ao usuário em
     * que ele só precisa informar a nacionalidade
     * @return List<Livro>
     */
    List<Livro> buscarPorNacionalidadeAutor(String nacionalidade);

    /**
     * Método que busca todos os livros com
     * a quantidade disponível especificada
     * @return List<Livro>
     */
    List<Livro> buscarPorQtde(Integer qtde);

    /**
     * Método que busca todos os livros com
     * o gênero especificado
     * @return List<Livro>
     */
    List<Livro> buscarPorGenero(String genero);

    /**
     * Método que insere um livro no db
     * @return void
     */
    void inserir(Livro livro);

    /**
     * Método que atualiza um livro no db
     * @return void
     */
    void atualizar(String titulo, Livro livro);

    /**
     * Método que deleta um livro do db
     * @return void
     */
    void deletar(String titulo);

    /**
     * Método para uso interno da aplicação
     * @return void
     */
    void limparTabela();
}
