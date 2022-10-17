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

import br.com.douglas.gac.model.Armario;
import br.com.douglas.gac.service.ArmarioService;

@Controller
@RequestMapping("api/armario")
public class ArmarioController {
    
    private static ArmarioService armarioService;

    public ArmarioController(ArmarioService armarioService){
       ArmarioController.armarioService = armarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Armario> getArmario(@PathVariable long id){
        Optional<Armario> armarioOp = armarioService.findById(id);
        if(armarioOp.isPresent()){
            return ResponseEntity.ok().body(armarioOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Armario>> getArmarios(){
        List<Armario> armarioList = armarioService.findAll();
        if(armarioList.size() > 0){
            return ResponseEntity.ok().body(armarioList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Armario> update(@RequestBody Armario armario){
        if(armario.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid armario id");
        }
        armario = armarioService.save(armario);
        return ResponseEntity.ok().body(armario);
    }

    @PostMapping("/")
    public ResponseEntity<Armario> create(@RequestBody Armario armario){
        if(armario.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Armario id can't exists");
        }
        armario = armarioService.save(armario);
        return ResponseEntity.ok().body(armario);
    }

    @DeleteMapping("/{id}") 
        public ResponseEntity<Void> delete(@PathVariable long id){
            armarioService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }

