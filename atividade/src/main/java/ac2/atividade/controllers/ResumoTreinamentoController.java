package ac2.atividade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ac2.atividade.models.ResumoTreinamento;
import ac2.atividade.services.ResumoTreinamentoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/resumos")
@CrossOrigin(origins = "*")
public class ResumoTreinamentoController {
    
    private final ResumoTreinamentoServiceImpl resumoTreinamentoService;
    
    @Autowired
    public ResumoTreinamentoController(ResumoTreinamentoServiceImpl resumoTreinamentoService) {
        this.resumoTreinamentoService = resumoTreinamentoService;
    }
    
    @GetMapping
    public ResponseEntity<List<ResumoTreinamento>> getAllResumosTreinamento() {
        List<ResumoTreinamento> resumos = resumoTreinamentoService.findAll();
        return new ResponseEntity<>(resumos, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResumoTreinamento> getResumoTreinamentoById(@PathVariable Long id) {
        return resumoTreinamentoService.findById(id)
                .map(resumo -> new ResponseEntity<>(resumo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/agendamento/{agendamentoId}")
    public ResponseEntity<List<ResumoTreinamento>> getResumosByAgendamentoId(@PathVariable Long agendamentoId) {
        List<ResumoTreinamento> resumos = resumoTreinamentoService.findByAgendamentoId(agendamentoId);
        return new ResponseEntity<>(resumos, HttpStatus.OK);
    }
    
    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<ResumoTreinamento>> getResumosByProfessorId(@PathVariable Long professorId) {
        List<ResumoTreinamento> resumos = resumoTreinamentoService.findByAgendamentoProfessorId(professorId);
        return new ResponseEntity<>(resumos, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ResumoTreinamento> createResumoTreinamento(@RequestBody ResumoTreinamento resumoTreinamento) {
        ResumoTreinamento novoResumo = resumoTreinamentoService.save(resumoTreinamento);
        return new ResponseEntity<>(novoResumo, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ResumoTreinamento> updateResumoTreinamento(@PathVariable Long id, @RequestBody ResumoTreinamento resumoTreinamento) {
        return resumoTreinamentoService.findById(id)
                .map(existingResumo -> {
                    resumoTreinamento.setId(id);
                    return new ResponseEntity<>(resumoTreinamentoService.save(resumoTreinamento), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResumoTreinamento(@PathVariable Long id) {
        return resumoTreinamentoService.findById(id)
                .map(resumo -> {
                    resumoTreinamentoService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}