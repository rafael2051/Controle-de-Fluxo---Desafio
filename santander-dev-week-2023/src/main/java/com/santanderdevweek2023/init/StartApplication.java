package com.santanderdevweek2023.init;

import com.santanderdevweek2023.model.Autor;
import com.santanderdevweek2023.model.Livro;
import com.santanderdevweek2023.model.Usuario;
import com.santanderdevweek2023.repository.UsuarioRepository;
import com.santanderdevweek2023.repository.LivroRepository;
import com.santanderdevweek2023.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Autor tolkien = new Autor();
        tolkien.setNome("J.R.R. TOLKIEN");
        tolkien.setNacionalidade("BRITANICO");
        autorRepository.save(tolkien);

        Autor csLewis = new Autor();
        csLewis.setNome("C.S. LEWIS");
        csLewis.setNacionalidade("BRITANICO");
        autorRepository.save(csLewis);

        Autor danBrown = new Autor();
        danBrown.setNome("DAN BROWN");
        danBrown.setNacionalidade("AMERICANO");
        autorRepository.save(danBrown);

        Autor stephenKing = new Autor();
        stephenKing.setNome("STEPHEN KING");
        stephenKing.setNacionalidade("AMERICANO");
        autorRepository.save(stephenKing);

        Autor machadoDeAssis = new Autor();
        machadoDeAssis.setNome("MACHADO DE ASSIS");
        machadoDeAssis.setNacionalidade("BRASILEIRO");
        autorRepository.save(machadoDeAssis);

        Autor miguelDeCervantes = new Autor();
        miguelDeCervantes.setNome("MIGUEL DE CERVANTES");
        miguelDeCervantes.setNacionalidade("ESPANHOL");
        autorRepository.save(miguelDeCervantes);

        Livro sda1 = new Livro();
        sda1.setTitulo("O SENHOR DOS ANEIS - A SOCIEDADE DO ANEL");
        sda1.setAutor_id(tolkien.getId());
        sda1.setGenero("FANTASIA");
        sda1.setAno_publicacao("1954");
        livroRepository.save(sda1);

        Livro sda2  = new Livro();
        sda2.setTitulo("O SENHOR DOS ANEIS - AS DUAS TORRES");
        sda2.setAutor_id(tolkien.getId());
        sda2.setGenero("FANTASIA");
        sda2.setAno_publicacao("1954");
        livroRepository.save(sda2);

        Livro sda3 = new Livro();
        sda3.setTitulo("O SENHOR DOS ANEIS - O RETORNO DO REI");
        sda3.setAutor_id(tolkien.getId());
        sda3.setGenero("FANTASIA");
        sda3.setAno_publicacao("1954");
        livroRepository.save(sda3);

        Livro oHobbit  = new Livro();
        oHobbit.setTitulo("O HOBBIT");
        oHobbit.setAutor_id(tolkien.getId());
        oHobbit.setGenero("FANTASIA");
        oHobbit.setAno_publicacao("1937");
        livroRepository.save(oHobbit);

        Livro narnia  = new Livro();
        narnia.setTitulo("AS CRONICAS DE NARNIA");
        narnia.setAutor_id(csLewis.getId());
        narnia.setGenero("AVENTURA");
        narnia.setAno_publicacao("1949");
        livroRepository.save(narnia);

        Livro cartas  = new Livro();
        cartas.setTitulo("CARTAS DE UM DIABO A SEU APRENDIZ");
        cartas.setAutor_id(csLewis.getId());
        cartas.setGenero("ROMANCE");
        cartas.setAno_publicacao("1942");
        livroRepository.save(cartas);

        Livro vinci = new Livro();
        vinci.setTitulo("O CODIGO DA VINCI");
        vinci.setAutor_id(danBrown.getId());
        vinci.setGenero("ROMANCE POLICIAL");
        vinci.setAno_publicacao("2003");
        livroRepository.save(vinci);

        Livro colecionador = new Livro();
        colecionador.setTitulo("O COLECIONADOR");
        colecionador.setAutor_id(stephenKing.getId());
        colecionador.setGenero("SUSPENSE");
        colecionador.setAno_publicacao("1963");
        livroRepository.save(colecionador);

        Livro brasCubas = new Livro();
        brasCubas.setTitulo("MEMORIAS POSTUMAS DE BRAS CUBAS");
        brasCubas.setAutor_id(machadoDeAssis.getId());
        brasCubas.setGenero("ROMANCE");
        brasCubas.setAno_publicacao("1881");
        livroRepository.save(brasCubas);

        Livro quixote = new Livro();
        quixote.setTitulo("DOM QUIXOTE");
        quixote.setAutor_id(miguelDeCervantes.getId());
        quixote.setGenero("ROMANCE");
        quixote.setAno_publicacao("1605");
        livroRepository.save(quixote);

        Usuario user1 = new Usuario();
        user1.setNome("Pedro");
        usuarioRepository.save(user1);

        Usuario user2 = new Usuario();
        user2.setNome("Maria");
        usuarioRepository.save(user2);

        Usuario user3 = new Usuario();
        user3.setNome("João");
        usuarioRepository.save(user3);

        Usuario user4 = new Usuario();
        user4.setNome("Sara");
        usuarioRepository.save(user4);

    }
}

