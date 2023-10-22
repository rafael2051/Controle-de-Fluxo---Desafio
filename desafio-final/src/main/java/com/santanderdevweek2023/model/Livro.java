package com.santanderdevweek2023.model;

import jakarta.persistence.*;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(length = 50, nullable = false)
    private String titulo;

    @Column(name="autor_id",nullable = false)
    private Integer autor;
    @Column(length = 4, nullable = false)
    private String ano_publicacao;
    @Column(length = 20, nullable = false)
    private String genero;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAutor_id() {
        return autor;
    }

    public void setAutor_id(Integer autor) {
        this.autor = autor;
    }

    public String getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(String ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
