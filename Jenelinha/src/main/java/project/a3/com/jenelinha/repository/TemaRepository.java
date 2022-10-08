package project.a3.com.jenelinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.a3.com.jenelinha.entity.Tema;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
    public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
