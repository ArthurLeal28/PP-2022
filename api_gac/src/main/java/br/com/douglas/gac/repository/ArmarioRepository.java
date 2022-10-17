package br.com.douglas.gac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.douglas.gac.model.Armario;

@Repository
public interface ArmarioRepository extends JpaRepository<Armario, Long> {

}
