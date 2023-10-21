package com.example.demo.service;

import com.example.demo.model.Autor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AutorService {

    /**
     * Método que busca todos os autores no db
     * @return List<Autor>
     */
    List<Autor> buscarTodos();

    /**
     * Método que busca um autor pelo id
     * @return Autor
     */
    public Optional<Autor> buscarPorId(Integer id);
    /**
     * Método que busca um autor pelo nome
     * @return Autor
     */
    Autor buscarPorNome(String nome);

    /**
     * Método que busca todos os autor com a nacionalidade
     * especificada
     * @return List<Autor>
     */
    List<Autor> buscarPorNacionalidade(String nacionalide);

    /**
     * Método que busca todos os autores pelo gênero
     * de livros especificado. Aqui temos uma
     * integração com o sistema responsável
     * pelos livros
     * @return List<Autor>
     */
    List<Autor> buscarPorGenero(String genero);

    /**
     * Método que insere um autor no db
     * @return void
     */
    void inserir(Autor autor);

    /**
     * Método que atualiza um livro no db
     * @return void
     */
    void atualizar(Integer id, Autor autor);

    /**
     * Método que deleta um autor do db. Essa ação deletará
     * todos os livros com esse autor no db. Aqui temos
     * outra aplicação do padrão facade, já que só é
     * necessário passar o id do autor, e toda uma
     * operação mais complexa de buscar os livros
     * do db com esse autor e apagá-los é
     * escondida do usuário
     * @return void
     */
    void deletar(Integer id);

    /**
     * Método para uso interno da aplicação
     * @return void
     */
    void limparTabela();
}
