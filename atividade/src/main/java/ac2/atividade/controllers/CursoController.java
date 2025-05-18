package ac2.atividade.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ac2.atividade.models.Curso;
import ac2.atividade.services.CursoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
public class CursoController {
    
    private final CursoServiceImpl cursoService;
    
    @Autowired
    public CursoController(CursoServiceImpl cursoService) {
        this.cursoService = cursoService;
    }
    
    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos() {
        List<Curso> cursos = cursoService.findAll();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        return cursoService.findById(id)
                .map(curso -> new ResponseEntity<>(curso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Curso>> getCursosByDescricao(@RequestParam String descricao) {
        List<Curso> cursos = cursoService.findByDescricaoContaining(descricao);
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
    
    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<Curso>> getCursosByProfessorId(@PathVariable Long professorId) {
        List<Curso> cursos = cursoService.findCursosByProfessorId(professorId);
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        Curso novoCurso = cursoService.save(curso);
        return new ResponseEntity<>(novoCurso, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.findById(id)
                .map(existingCurso -> {
                    curso.setId(id);
                    return new ResponseEntity<>(cursoService.save(curso), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        return cursoService.findById(id)
                .map(curso -> {
                    cursoService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}