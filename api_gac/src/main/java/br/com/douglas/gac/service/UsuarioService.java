package br.com.douglas.gac.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.douglas.gac.model.Usuario;
import br.com.douglas.gac.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> findById(long id){
        return usuarioRepository.findById(id);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public void delete(long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
