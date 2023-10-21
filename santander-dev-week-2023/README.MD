# Santander Dev Week 2023
___

## Diagrama de Classes

```mermaid
classDiagram
    class Livro {
        id: Integer
        titulo: String
        autor_id: Integer
        ano_publicacao: String
        genero: String
    }

    class Autor {
        id: Integer
        nome: String
        nacionalidade: String
    }

    class Usuario {
        id: Integer
        nome: String
    }

    class LivroEmprestado {
        id: Integer
        id_usuario: Integer
        id_livro: Integer
    }

    Autor "1" *-- "N" Livro
    Usuario "1" -- "0, N" LivroEmprestado : tem
    Usuario -- Livro : faz_empréstimo

```
