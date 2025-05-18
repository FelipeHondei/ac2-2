package ac2.atividade.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ac2.atividade.models.Professor;
import ac2.atividade.services.ProfessorServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
@CrossOrigin(origins = "*")
public class ProfessorController {
    
    private final ProfessorServiceImpl professorService;
    
    @Autowired
    public ProfessorController(ProfessorServiceImpl professorService) {
        this.professorService = professorService;
    }
    
    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessores() {
        List<Professor> professores = professorService.findAll();
        return new ResponseEntity<>(professores, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        return professorService.findById(id)
                .map(professor -> new ResponseEntity<>(professor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Professor> getProfessorByCpf(@PathVariable String cpf) {
        return professorService.findByCpf(cpf)
                .map(professor -> new ResponseEntity<>(professor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Professor>> getProfessoresByCursoId(@PathVariable Long cursoId) {
        List<Professor> professores = professorService.findProfessoresByCursoId(cursoId);
        return new ResponseEntity<>(professores, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        Professor novoProfessor = professorService.save(professor);
        return new ResponseEntity<>(novoProfessor, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        return professorService.findById(id)
                .map(existingProfessor -> {
                    professor.setId(id);
                    return new ResponseEntity<>(professorService.save(professor), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        return professorService.findById(id)
                .map(professor -> {
                    professorService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}