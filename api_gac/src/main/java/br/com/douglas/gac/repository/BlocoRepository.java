package br.com.douglas.gac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.douglas.gac.model.Bloco;

@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Long> {

}
