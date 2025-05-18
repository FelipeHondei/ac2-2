package ac2.atividade.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ac2.atividade.models.Especializacao;

import java.util.List;
import java.util.Optional;

@Repository
public interface EspecializacaoRepository extends JpaRepository<Especializacao, Long> {
    List<Especializacao> findByProfessorId(Long professorId);
    
    List<Especializacao> findByCursoId(Long cursoId);
    
    Optional<Especializacao> findByProfessorIdAndCursoId(Long professorId, Long cursoId);
}