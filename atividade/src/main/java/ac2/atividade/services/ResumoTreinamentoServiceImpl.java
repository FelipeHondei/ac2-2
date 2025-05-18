package ac2.atividade.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.atividade.models.ResumoTreinamento;
import ac2.atividade.repositories.ResumoTreinamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResumoTreinamentoServiceImpl implements ResumoTreinamentoService {
    
    private final ResumoTreinamentoRepository resumoTreinamentoRepository;
    
    @Autowired
    public ResumoTreinamentoServiceImpl(ResumoTreinamentoRepository resumoTreinamentoRepository) {
        this.resumoTreinamentoRepository = resumoTreinamentoRepository;
    }
    
    @Override
    public List<ResumoTreinamento> findAll() {
        return resumoTreinamentoRepository.findAll();
    }
    
    @Override
    public Optional<ResumoTreinamento> findById(Long id) {
        return resumoTreinamentoRepository.findById(id);
    }
    
    @Override
    public List<ResumoTreinamento> findByAgendamentoId(Long agendamentoId) {
        return resumoTreinamentoRepository.findByAgendamentoId(agendamentoId);
    }
    
    @Override
    public List<ResumoTreinamento> findByAgendamentoProfessorId(Long professorId) {
        return resumoTreinamentoRepository.findByAgendamentoProfessorId(professorId);
    }
    
    @Override
    public ResumoTreinamento save(ResumoTreinamento resumoTreinamento) {
        return resumoTreinamentoRepository.save(resumoTreinamento);
    }
    
    @Override
    public void deleteById(Long id) {
        resumoTreinamentoRepository.deleteById(id);
    }
}