package ac2.atividade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ac2.atividade.models.Curso;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<ac2.atividade.models.Curso, Long> {
    List<Curso> findByDescricaoContainingIgnoreCase(String descricao);
    
    @Query("SELECT c FROM Curso c JOIN c.especializacoes e WHERE e.professor.id = :professorId")
    List<Curso> findCursosByProfessorId(@Param("professorId") Long professorId);
}