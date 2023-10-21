package com.example.demo.init;

import com.example.demo.model.Autor;
import com.example.demo.model.Livro;
import com.example.demo.service.AutorService;
import com.example.demo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private LivroService livroService;
    @Autowired
    private AutorService autorService;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        autorService.limparTabela();
        Autor tolkien = new Autor();
        tolkien.setNome("J.R.R. TOLKIEN");
        tolkien.setNacionalidade("BRITANICO");
        autorService.inserir(tolkien);

        Autor csLewis = new Autor();
        csLewis.setNome("C.S. LEWIS");
        csLewis.setNacionalidade("BRITANICO");
        autorService.inserir(csLewis);

        Autor danBrown = new Autor();
        danBrown.setNome("DAN BROWN");
        danBrown.setNacionalidade("AMERICANO");
        autorService.inserir(danBrown);

        Autor stephenKing = new Autor();
        stephenKing.setNome("STEPHEN KING");
        stephenKing.setNacionalidade("AMERICANO");
        autorService.inserir(stephenKing);

        Autor machadoDeAssis = new Autor();
        machadoDeAssis.setNome("MACHADO DE ASSIS");
        machadoDeAssis.setNacionalidade("BRASILEIRO");
        autorService.inserir(machadoDeAssis);

        Autor miguelDeCervantes = new Autor();
        miguelDeCervantes.setNome("MIGUEL DE CERVANTES");
        miguelDeCervantes.setNacionalidade("ESPANHOL");
        autorService.inserir(miguelDeCervantes);

        livroService.limparTabela();
        Livro sda1 = new Livro();
        sda1.setTitulo("O SENHOR DOS ANEIS - A SOCIEDADE DO ANEL");
        sda1.setAutor_id(tolkien.getId());
        sda1.setGenero("FANTASIA");
        sda1.setAno_publicacao("1954");
        sda1.setQtde(20);
        livroService.inserir(sda1);

        Livro sda2  = new Livro();
        sda2.setTitulo("O SENHOR DOS ANEIS - AS DUAS TORRES");
        sda2.setAutor_id(tolkien.getId());
        sda2.setGenero("FANTASIA");
        sda2.setAno_publicacao("1954");
        sda2.setQtde(20);
        livroService.inserir(sda2);

        Livro sda3 = new Livro();
        sda3.setTitulo("O SENHOR DOS ANEIS - O RETORNO DO REI");
        sda3.setAutor_id(tolkien.getId());
        sda3.setGenero("FANTASIA");
        sda3.setQtde(20);
        sda3.setAno_publicacao("1954");
        livroService.inserir(sda3);

        Livro oHobbit  = new Livro();
        oHobbit.setTitulo("O HOBBIT");
        oHobbit.setAutor_id(tolkien.getId());
        oHobbit.setGenero("FANTASIA");
        oHobbit.setAno_publicacao("1937");
        oHobbit.setQtde(20);
        livroService.inserir(oHobbit);

        Livro narnia  = new Livro();
        narnia.setTitulo("AS CRONICAS DE NARNIA");
        narnia.setAutor_id(csLewis.getId());
        narnia.setGenero("AVENTURA");
        narnia.setAno_publicacao("1949");
        narnia.setQtde(20);
        livroService.inserir(narnia);

        Livro cartas  = new Livro();
        cartas.setTitulo("CARTAS DE UM DIABO A SEU APRENDIZ");
        cartas.setAutor_id(csLewis.getId());
        cartas.setGenero("ROMANCE");
        cartas.setQtde(20);
        cartas.setAno_publicacao("1942");

        Livro vinci = new Livro();
        vinci.setTitulo("O CODIGO DA VINCI");
        vinci.setAutor_id(danBrown.getId());
        vinci.setGenero("ROMANCE POLICIAL");
        vinci.setAno_publicacao("2003");
        vinci.setQtde(20);
        livroService.inserir(vinci);

        Livro colecionador = new Livro();
        colecionador.setTitulo("O COLECIONADOR");
        colecionador.setAutor_id(stephenKing.getId());
        colecionador.setGenero("SUSPENSE");
        colecionador.setAno_publicacao("1963");
        colecionador.setQtde(20);
        livroService.inserir(colecionador);

        Livro brasCubas = new Livro();
        brasCubas.setTitulo("MEMORIAS POSTUMAS DE BRAS CUBAS");
        brasCubas.setAutor_id(machadoDeAssis.getId());
        brasCubas.setGenero("ROMANCE");
        brasCubas.setAno_publicacao("1881");
        brasCubas.setQtde(20);
        livroService.inserir(brasCubas);

        Livro quixote = new Livro();
        quixote.setTitulo("DOM QUIXOTE");
        quixote.setAutor_id(miguelDeCervantes.getId());
        quixote.setGenero("ROMANCE");
        quixote.setAno_publicacao("1605");
        quixote.setQtde(20);
        livroService.inserir(quixote);
    }
}
