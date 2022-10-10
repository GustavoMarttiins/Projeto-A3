package project.a3.com.jenelinha.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.a3.com.jenelinha.entity.Postagem;
import project.a3.com.jenelinha.entity.Tema;
import project.a3.com.jenelinha.repository.PostagemRepository;

import java.util.List;

@RestController
@RequestMapping("/postagem")
@RequiredArgsConstructor
public class PostagemController {

    @Autowired
    private PostagemRepository repository;


    @GetMapping
    public ResponseEntity<List<Postagem>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getId(@PathVariable String id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") String id,
                                 @RequestBody Postagem postagem) {
        return repository.findById(id)
                .map(record -> {
                    record.setTitulo(postagem.getTitulo());
                    record.setConteudo(postagem.getConteudo());
                    Postagem updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Postagem> createdPost(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }

    @DeleteMapping("/{id}")
    public void deletePostagem(@PathVariable("id") String id){
        repository.deleteById(id);
    }

}
