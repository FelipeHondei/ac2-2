package ac2.atividade.services;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import ac2.atividade.models.Agendamento;

public interface AgendamentoService {
    List<Agendamento> findAll();
    
    Optional<Agendamento> findById(Long id);
    
    List<Agendamento> findByProfessorId(Long professorId);
    
    List<Agendamento> findByCursoId(Long cursoId);
    
    List<Agendamento> findByCidadeAndEstado(String cidade, String estado);
    
    List<Agendamento> findConflitosAgendamento(Long professorId, LocalDate dataInicio, LocalDate dataFim);
    
    boolean verificarDisponibilidadeProfessor(Long professorId, LocalDate dataInicio, LocalDate dataFim);
    
    Agendamento save(Agendamento agendamento);
    
    void deleteById(Long id);
}