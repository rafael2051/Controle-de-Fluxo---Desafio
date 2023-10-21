# Santander Dev Week 2023
___

## Diagrama de Classes

```mermaid
classDiagram
    class Livro {
        id: String
        titulo: String
        autor_id: String
        ano_publicacao: String
        genero: String
    }

    class Autor {
        id: String
        nome: String
        nacionalidade: String
    }

    class Usuario {
        id: String
        nome: String
    }

    class LivrosEmprestados {
        id_usuario: String
        id_livro: String
    }

    Autor "1" *-- "N" Livro
    Usuario "1" -- "0, N" LivrosEmprestados : tem
    

```
