package ac2.atividade.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ac2.atividade.models.Professor;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByCpf(String cpf);
    
    @Query("SELECT p FROM Professor p JOIN p.especializacoes e WHERE e.curso.id = :cursoId")
    List<Professor> findProfessoresByCursoId(@Param("cursoId") Long cursoId);
}