package project.a3.com.jenelinha.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.a3.com.jenelinha.entity.Postagem;
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

    @PostMapping
    public ResponseEntity<Postagem> createdPost(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }

}
