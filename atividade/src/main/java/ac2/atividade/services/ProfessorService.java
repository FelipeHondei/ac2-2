package ac2.atividade.services;

import java.util.List;
import java.util.Optional;

import ac2.atividade.models.Professor;

public interface ProfessorService {
    List<Professor> findAll();
    
    Optional<Professor> findById(Long id);
    
    Optional<Professor> findByCpf(String cpf);
    
    Professor save(Professor professor);
    
    void deleteById(Long id);
    
    List<Professor> findProfessoresByCursoId(Long cursoId);
}