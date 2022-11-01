package project.a3.com.jenelinha.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.a3.com.jenelinha.entity.Usuario;
import project.a3.com.jenelinha.entity.UsuarioLogin;
import project.a3.com.jenelinha.repository.UsuarioRepository;
import project.a3.com.jenelinha.service.UsuarioService;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuario(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") String id){
        return usuarioRepository.findByUsuario(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario,
                                                 @PathVariable("id") String id){
        return usuarioRepository.findByUsuario(id)
                .map(record -> {
                    record.setNome(usuario.getNome());
                    record.setUsuario(usuario.getUsuario());
                    record.setSenha(usuario.getSenha());
                    Usuario update = usuarioRepository.save(record);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

   @PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.CadastrarUsuario(usuario));
	}

    @PostMapping("/logar")
    public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user) {
        return service.Logar(user).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

}
