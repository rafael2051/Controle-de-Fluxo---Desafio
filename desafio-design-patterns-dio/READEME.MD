#  Desafio-Design-Patterns
____

## Objetivo 
    Implementar um projeto que utilize os padrões de projeto singleto, facade e strategy, utilizando
    o Spring Framework.
## Projeto
    Modelei um banco de dados de uma biblioteca, com duas entidades, Livro e Autor. O banco de dados utilizado
    para armazenar as tabelas foi o PostgreSQL, e foram implementadas operações CRUD pertinentes às duas
    entidades, com o uso de uma API Rest para consumir requisições http de consulta ao db.

____

## Folder Structure
<pre>
.
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── example/
    │               └── demo/
    │                   ├── controller/
    │                   │   ├── AutorController.java
    │                   │   └── LivroController.java
    │                   ├── init/
    │                   │   └── StartApplication.java
    │                   ├── model/
    │                   │   ├── Autor.java
    │                   │   └── Livro.java
    │                   ├── repository/
    │                   │   ├── AutorRepository.java
    │                   │   └── LivroRepository.java
    │                   └── service/
    │                       ├── impl/
    │                       │   ├── AutorServiceImpl.java
    │                       │   └── LivroServiceImpl.java
    │                       ├── AutorService.java
    │                       └── LivroService.java
    └── test/
        └── java/
            └── com/
                └── example/
                    └── demo/
                        └── DemoApplicationTests.java
</pre>


> O padrão de projeto singleton foi explorado com o uso da anotação autorwired, com qual
explicitamos para o Spring injetar a nossa dependência. Já o strategy foi feito nas 
implementações das interfaces AutorService e LivroService, e utilizamos o Facade em nossa API
que permite uma integração entre as classes para gerenciar a tabela de autores e as classes
gerenciar para gerenciar livros, em requisições muito simples que precisam de apenas um
ou dois parâmetros.

## Dependency Management
* spring-boot-starter-web
* spring-boot-starter-data-jpa
* spring-boot-starter-test
* postgresql
* spring-boot-configuration-processor
* postgresql 42.6.0