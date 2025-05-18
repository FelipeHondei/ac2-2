package ac2.atividade.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ac2.atividade.models.Especializacao;
import ac2.atividade.services.EspecializacaoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/especializacoes")
@CrossOrigin(origins = "*")
public class EspecializacaoController {
    
    private final EspecializacaoServiceImpl especializacaoService;
    
    @Autowired
    public EspecializacaoController(EspecializacaoServiceImpl especializacaoService) {
        this.especializacaoService = especializacaoService;
    }
    
    @GetMapping
    public ResponseEntity<List<Especializacao>> getAllEspecializacoes() {
        List<Especializacao> especializacoes = especializacaoService.findAll();
        return new ResponseEntity<>(especializacoes, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Especializacao> getEspecializacaoById(@PathVariable Long id) {
        return especializacaoService.findById(id)
                .map(especializacao -> new ResponseEntity<>(especializacao, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<Especializacao>> getEspecializacoesByProfessorId(@PathVariable Long professorId) {
        List<Especializacao> especializacoes = especializacaoService.findByProfessorId(professorId);
        return new ResponseEntity<>(especializacoes, HttpStatus.OK);
    }
    
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Especializacao>> getEspecializacoesByCursoId(@PathVariable Long cursoId) {
        List<Especializacao> especializacoes = especializacaoService.findByCursoId(cursoId);
        return new ResponseEntity<>(especializacoes, HttpStatus.OK);
    }
    
    @GetMapping("/professor/{professorId}/curso/{cursoId}")
    public ResponseEntity<Especializacao> getEspecializacaoByProfessorIdAndCursoId(
            @PathVariable Long professorId, @PathVariable Long cursoId) {
        return especializacaoService.findByProfessorIdAndCursoId(professorId, cursoId)
                .map(especializacao -> new ResponseEntity<>(especializacao, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<Especializacao> createEspecializacao(@RequestBody Especializacao especializacao) {
        Especializacao novaEspecializacao = especializacaoService.save(especializacao);
        return new ResponseEntity<>(novaEspecializacao, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Especializacao> updateEspecializacao(@PathVariable Long id, @RequestBody Especializacao especializacao) {
        return especializacaoService.findById(id)
                .map(existingEspecializacao -> {
                    especializacao.setId(id);
                    return new ResponseEntity<>(especializacaoService.save(especializacao), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecializacao(@PathVariable Long id) {
        return especializacaoService.findById(id)
                .map(especializacao -> {
                    especializacaoService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}