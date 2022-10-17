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

import br.com.douglas.gac.model.Bloco;
import br.com.douglas.gac.service.BlocoService;

@Controller
@RequestMapping("api/bloco")
public class BlocoController {
    
    private static BlocoService blocoService;

    public BlocoController(BlocoService blocoService){
       BlocoController.blocoService = blocoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloco> getBloco(@PathVariable long id){
        Optional<Bloco> blocoOp = blocoService.findById(id);
        if(blocoOp.isPresent()){
            return ResponseEntity.ok().body(blocoOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Bloco>> getBlocos(){
        List<Bloco> petList = blocoService.findAll();
        if(petList.size() > 0){
            return ResponseEntity.ok().body(petList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Bloco> update(@RequestBody Bloco bloco){
        if(bloco.getIdBloco() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid bloco id");
        }
        bloco = blocoService.save(bloco);
        return ResponseEntity.ok().body(bloco);
    }

    @PostMapping("/")
    public ResponseEntity<Bloco> create(@RequestBody Bloco bloco){
        if(bloco.getIdBloco() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bloco id can't exists");
        }
        bloco = blocoService.save(bloco);
        return ResponseEntity.ok().body(bloco);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable long id){
            blocoService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }

