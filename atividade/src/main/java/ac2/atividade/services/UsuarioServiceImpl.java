package ac2.atividade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.atividade.models.Usuario;
import ac2.atividade.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    private final UsuarioRepository usuarioRepository;
    
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    
    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }
    
    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
    
    @Override
    public Optional<Usuario> findByProfessorId(Long professorId) {
        return usuarioRepository.findByProfessorId(professorId);
    }
    
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}