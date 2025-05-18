package ac2.atividade.services;



import java.util.List;
import java.util.Optional;

import ac2.atividade.models.ResumoTreinamento;

public interface ResumoTreinamentoService {
    List<ResumoTreinamento> findAll();
    
    Optional<ResumoTreinamento> findById(Long id);
    
    List<ResumoTreinamento> findByAgendamentoId(Long agendamentoId);
    
    List<ResumoTreinamento> findByAgendamentoProfessorId(Long professorId);
    
    ResumoTreinamento save(ResumoTreinamento resumoTreinamento);
    
    void deleteById(Long id);
}