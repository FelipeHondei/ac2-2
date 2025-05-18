package ac2.atividade.services;



import java.util.List;
import java.util.Optional;

import ac2.atividade.models.Curso;

public interface CursoService {
    List<Curso> findAll();
    
    Optional<Curso> findById(Long id);
    
    List<Curso> findByDescricaoContaining(String descricao);
    
    Curso save(Curso curso);
    
    void deleteById(Long id);
    
    List<Curso> findCursosByProfessorId(Long professorId);
}