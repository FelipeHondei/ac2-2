package ac2.atividade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.atividade.models.Especializacao;
import ac2.atividade.repositories.EspecializacaoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EspecializacaoServiceImpl implements EspecializacaoService {
    
    private final EspecializacaoRepository especializacaoRepository;
    
    @Autowired
    public EspecializacaoServiceImpl(EspecializacaoRepository especializacaoRepository) {
        this.especializacaoRepository = especializacaoRepository;
    }
    
    @Override
    public List<Especializacao> findAll() {
        return especializacaoRepository.findAll();
    }
    
    @Override
    public Optional<Especializacao> findById(Long id) {
        return especializacaoRepository.findById(id);
    }
    
    @Override
    public List<Especializacao> findByProfessorId(Long professorId) {
        return especializacaoRepository.findByProfessorId(professorId);
    }
    
    @Override
    public List<Especializacao> findByCursoId(Long cursoId) {
        return especializacaoRepository.findByCursoId(cursoId);
    }
    
    @Override
    public Optional<Especializacao> findByProfessorIdAndCursoId(Long professorId, Long cursoId) {
        return especializacaoRepository.findByProfessorIdAndCursoId(professorId, cursoId);
    }
    
    @Override
    public Especializacao save(Especializacao especializacao) {
        return especializacaoRepository.save(especializacao);
    }
    
    @Override
    public void deleteById(Long id) {
        especializacaoRepository.deleteById(id);
    }
}