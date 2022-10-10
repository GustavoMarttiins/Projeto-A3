package project.a3.com.jenelinha.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.a3.com.jenelinha.entity.Postagem;
import project.a3.com.jenelinha.entity.Tema;
import project.a3.com.jenelinha.repository.TemaRepository;

import java.util.List;

@RestController
@RequestMapping("/tema")
@RequiredArgsConstructor
public class TemaController {

    @Autowired
    private TemaRepository repository;

    @GetMapping
    public ResponseEntity<List<Tema>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getId(@PathVariable Long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping()
    public ResponseEntity<Tema> createdPost(@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Tema tema) {
        return repository.findById(id)
                .map(record -> {
                    record.setDescricao(tema.getDescricao());
                    Tema updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteTema(@PathVariable("id") Long id){
      repository.deleteById(id);
    }

}
