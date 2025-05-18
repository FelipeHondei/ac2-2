package ac2.atividade.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ac2.atividade.models.Agendamento;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByProfessorId(Long professorId);
    
    List<Agendamento> findByCursoId(Long cursoId);
    
    @Query("SELECT a FROM Agendamento a WHERE a.professor.id = :professorId " +
           "AND ((a.dataInicio BETWEEN :dataInicio AND :dataFim) OR " +
           "(a.dataFim BETWEEN :dataInicio AND :dataFim) OR " +
           "(:dataInicio BETWEEN a.dataInicio AND a.dataFim) OR " +
           "(:dataFim BETWEEN a.dataInicio AND a.dataFim))")
    List<Agendamento> findConflitosAgendamento(
            @Param("professorId") Long professorId,
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim);
            
    List<Agendamento> findByCidadeAndEstado(String cidade, String estado);
}