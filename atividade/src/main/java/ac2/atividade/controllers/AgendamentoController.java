
package ac2.atividade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ac2.atividade.models.Agendamento;
import ac2.atividade.services.AgendamentoServiceImpl;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {
    
    private final AgendamentoServiceImpl agendamentoService;
    
    @Autowired
    public AgendamentoController(AgendamentoServiceImpl agendamentoService) {
        this.agendamentoService = agendamentoService;
    }
    
    @GetMapping
    public ResponseEntity<List<Agendamento>> getAllAgendamentos() {
        List<Agendamento> agendamentos = agendamentoService.findAll();
        return new ResponseEntity<>(agendamentos, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> getAgendamentoById(@PathVariable Long id) {
        return agendamentoService.findById(id)
                .map(agendamento -> new ResponseEntity<>(agendamento, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<Agendamento>> getAgendamentosByProfessorId(@PathVariable Long professorId) {
        List<Agendamento> agendamentos = agendamentoService.findByProfessorId(professorId);
        return new ResponseEntity<>(agendamentos, HttpStatus.OK);
    }
    
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Agendamento>> getAgendamentosByCursoId(@PathVariable Long cursoId) {
        List<Agendamento> agendamentos = agendamentoService.findByCursoId(cursoId);
        return new ResponseEntity<>(agendamentos, HttpStatus.OK);
    }
    
    @GetMapping("/local")
    public ResponseEntity<List<Agendamento>> getAgendamentosByCidadeAndEstado(
            @RequestParam String cidade, @RequestParam String estado) {
        List<Agendamento> agendamentos = agendamentoService.findByCidadeAndEstado(cidade, estado);
        return new ResponseEntity<>(agendamentos, HttpStatus.OK);
    }
    
    @GetMapping("/verificar-disponibilidade")
    public ResponseEntity<Boolean> verificarDisponibilidadeProfessor(
            @RequestParam Long professorId,
            @RequestParam String dataInicio,
            @RequestParam String dataFim) {
        LocalDate inicio = LocalDate.parse(dataInicio);
        LocalDate fim = LocalDate.parse(dataFim);
        boolean disponivel = agendamentoService.verificarDisponibilidadeProfessor(professorId, inicio, fim);
        return new ResponseEntity<>(disponivel, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Agendamento> createAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.save(agendamento);
        return new ResponseEntity<>(novoAgendamento, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> updateAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        return agendamentoService.findById(id)
                .map(existingAgendamento -> {
                    agendamento.setId(id);
                    return new ResponseEntity<>(agendamentoService.save(agendamento), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamento(@PathVariable Long id) {
        return agendamentoService.findById(id)
                .map(agendamento -> {
                    agendamentoService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}