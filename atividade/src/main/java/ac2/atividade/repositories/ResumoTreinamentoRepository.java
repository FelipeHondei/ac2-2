package ac2.atividade.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ac2.atividade.models.ResumoTreinamento;

import java.util.List;

@Repository
public interface ResumoTreinamentoRepository extends JpaRepository<ResumoTreinamento, Long> {
    List<ResumoTreinamento> findByAgendamentoId(Long agendamentoId);
    
    List<ResumoTreinamento> findByAgendamentoProfessorId(Long professorId);
}