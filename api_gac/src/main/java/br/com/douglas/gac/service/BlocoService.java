package br.com.douglas.gac.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.douglas.gac.model.Bloco;
import br.com.douglas.gac.model.Armario;
import br.com.douglas.gac.repository.BlocoRepository;

@Service
public class BlocoService {
    
    @Autowired
    BlocoRepository BlocoRepository;

    @Autowired
    ArmarioService ArmarioService;

    public Optional<Bloco> findById(long id){
        return BlocoRepository.findById(id);
    }

    public List<Bloco> findAll(){
        return BlocoRepository.findAll();
    }

    public void delete(long id){
        BlocoRepository.deleteById(id);
    }

    public Bloco save(Bloco bloco){
        bloco = BlocoRepository.save(bloco);
        for(int i = 1; i <= bloco.getColunaBloco(); i++){
            for(int j = 1; j <= bloco.getLinhaBloco(); j++){
                ArmarioService.save(new Armario(bloco, i, j));
            }
        }
        return bloco;
    }
}
