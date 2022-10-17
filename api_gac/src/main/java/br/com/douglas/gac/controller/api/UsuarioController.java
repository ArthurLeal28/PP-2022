package br.com.douglas.gac.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import br.com.douglas.gac.model.Usuario;
import br.com.douglas.gac.service.UsuarioService;

@Controller
@RequestMapping("api/usuario")
public class UsuarioController {
    
    private static UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
       UsuarioController.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable long id){
        Optional<Usuario> usuarioOp = usuarioService.findById(id);
        if(usuarioOp.isPresent()){
            return ResponseEntity.ok().body(usuarioOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        List<Usuario> usuarioList = usuarioService.findAll();
        if(usuarioList.size() > 0){
            return ResponseEntity.ok().body(usuarioList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
        if(usuario.getIdUsuario() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid usuario id");
        }
        usuario = usuarioService.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        if(usuario.getIdUsuario() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario id can't exists");
        }
        usuario = usuarioService.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable long id){
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }

