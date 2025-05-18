package ac2.atividade.services;



import java.util.List;
import java.util.Optional;

import ac2.atividade.models.Usuario;

public interface UsuarioService {
    List<Usuario> findAll();
    
    Optional<Usuario> findById(Long id);
    
    Optional<Usuario> findByUsername(String username);
    
    Optional<Usuario> findByProfessorId(Long professorId);
    
    Usuario save(Usuario usuario);
    
    void deleteById(Long id);
}