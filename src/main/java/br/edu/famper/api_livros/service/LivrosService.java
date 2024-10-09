package br.edu.famper.api_livros.service;

import br.edu.famper.api_livros.model.Livros;
import br.edu.famper.api_livros.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    public Livros salvar(Livros livros) {
        return livrosRepository.save(livros);
    }

    public List<Livros> findAll(){
        return livrosRepository.findAll();
    }

    public Optional<Livros> findById(Long id) {
        return livrosRepository.findById(id);
    }


    public Livros update(Livros livros) {
        Livros salvo = livrosRepository.findById(livros.getCodigo()).orElseThrow(() -> new RuntimeException("Livro não encontrado!"));
        salvo.setTitulo(livros.getTitulo());
        salvo.setAutor(livros.getAutor());
        salvo.setAno_publicacao(livros.getAno_publicacao());
        salvo.setPreco(livros.getPreco());
        return livrosRepository.save(salvo);
    }

    public void delete(Long id) {
        livrosRepository.deleteById(id);
    }
}
