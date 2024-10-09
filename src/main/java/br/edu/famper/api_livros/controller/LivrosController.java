package br.edu.famper.api_livros.controller;

import br.edu.famper.api_livros.model.Livros;
import br.edu.famper.api_livros.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/livros")
public class LivrosController {
    @Autowired
    private LivrosService livrosService;

    @GetMapping
    public ResponseEntity<List<Livros>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(livrosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Livros>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(livrosService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Livros> create(@RequestBody Livros livros){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(livrosService.salvar(livros));
    }
    @PutMapping
    public ResponseEntity<Livros> update(@RequestBody Livros livros){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(livrosService.update(livros));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        livrosService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
