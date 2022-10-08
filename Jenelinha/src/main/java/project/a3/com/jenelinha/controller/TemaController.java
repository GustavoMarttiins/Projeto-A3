package project.a3.com.jenelinha.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.a3.com.jenelinha.entity.Postagem;
import project.a3.com.jenelinha.entity.Tema;
import project.a3.com.jenelinha.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@RequiredArgsConstructor
public class TemaController {

    @Autowired
    private TemaRepository repository;

    @PostMapping()
    public ResponseEntity<Tema> createdPost(@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
    }


}
