package project.a3.com.jenelinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.a3.com.jenelinha.entity.Postagem;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, String> {

}