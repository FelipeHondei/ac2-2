package ac2.atividade.services;



import java.util.List;
import java.util.Optional;

import ac2.atividade.models.Especializacao;

public interface EspecializacaoService {
    List<ac2.atividade.models.Especializacao> findAll();
    
    Optional<Especializacao> findById(Long id);
    
    List<Especializacao> findByProfessorId(Long professorId);
    
    List<Especializacao> findByCursoId(Long cursoId);
    
    Optional<Especializacao> findByProfessorIdAndCursoId(Long professorId, Long cursoId);
    
    Especializacao save(Especializacao especializacao);
    
    void deleteById(Long id);
}