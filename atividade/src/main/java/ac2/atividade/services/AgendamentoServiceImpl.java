package ac2.atividade.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.atividade.models.Agendamento;
import ac2.atividade.repositories.AgendamentoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {
    
    private final AgendamentoRepository agendamentoRepository;
    
    @Autowired
    public AgendamentoServiceImpl(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }
    
    @Override
    public List<Agendamento> findAll() {
        return agendamentoRepository.findAll();
    }
    
    @Override
    public Optional<Agendamento> findById(Long id) {
        return agendamentoRepository.findById(id);
    }
    
    @Override
    public List<Agendamento> findByProfessorId(Long professorId) {
        return agendamentoRepository.findByProfessorId(professorId);
    }
    
    @Override
    public List<Agendamento> findByCursoId(Long cursoId) {
        return agendamentoRepository.findByCursoId(cursoId);
    }
    
    @Override
    public List<Agendamento> findByCidadeAndEstado(String cidade, String estado) {
        return agendamentoRepository.findByCidadeAndEstado(cidade, estado);
    }
    
    @Override
    public List<Agendamento> findConflitosAgendamento(Long professorId, LocalDate dataInicio, LocalDate dataFim) {
        return agendamentoRepository.findConflitosAgendamento(professorId, dataInicio, dataFim);
    }
    
    @Override
    public boolean verificarDisponibilidadeProfessor(Long professorId, LocalDate dataInicio, LocalDate dataFim) {
        List<Agendamento> conflitos = findConflitosAgendamento(professorId, dataInicio, dataFim);
        return conflitos.isEmpty();
    }
    
    @Override
    public Agendamento save(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }
    
    @Override
    public void deleteById(Long id) {
        agendamentoRepository.deleteById(id);
    }
}