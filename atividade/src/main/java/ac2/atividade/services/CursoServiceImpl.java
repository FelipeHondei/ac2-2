package ac2.atividade.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.atividade.models.Curso;
import ac2.atividade.repositories.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {
    
    private final CursoRepository cursoRepository;
    
    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    
    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
    
    @Override
    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }
    
    @Override
    public List<Curso> findByDescricaoContaining(String descricao) {
        return cursoRepository.findByDescricaoContainingIgnoreCase(descricao);
    }
    
    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }
    
    @Override
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
    
    @Override
    public List<Curso> findCursosByProfessorId(Long professorId) {
        return cursoRepository.findCursosByProfessorId(professorId);
    }
}