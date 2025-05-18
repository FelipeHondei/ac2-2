package ac2.atividade.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.atividade.models.Professor;
import ac2.atividade.repositories.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    
    private final ProfessorRepository professorRepository;
    
    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
    
    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
    
    @Override
    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }
    
    @Override
    public Optional<Professor> findByCpf(String cpf) {
        return professorRepository.findByCpf(cpf);
    }
    
    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }
    
    @Override
    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }
    
    @Override
    public List<Professor> findProfessoresByCursoId(Long cursoId) {
        return professorRepository.findProfessoresByCursoId(cursoId);
    }
}