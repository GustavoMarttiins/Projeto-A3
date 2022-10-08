package project.a3.com.jenelinha.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioLogin {

    private String nome;

    private String usuario;

    private String senha;

    private String token;

}
