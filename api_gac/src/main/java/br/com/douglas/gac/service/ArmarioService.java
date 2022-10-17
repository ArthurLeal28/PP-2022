package br.com.douglas.gac.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.douglas.gac.model.Armario;
import br.com.douglas.gac.repository.ArmarioRepository;

@Service
public class ArmarioService {
    
    @Autowired
    ArmarioRepository armarioRepository;

    public Optional<Armario> findById(long id){
        return armarioRepository.findById(id);
    }

    public List<Armario> findAll(){
        return armarioRepository.findAll();
    }

    public void delete(long id){
        armarioRepository.deleteById(id);
    }

    public Armario save(Armario armario){
        armario = armarioRepository.save(armario);
        return armario;
    }
}
