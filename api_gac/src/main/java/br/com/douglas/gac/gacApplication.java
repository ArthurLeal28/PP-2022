package br.com.douglas.gac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.douglas.gac.service.UsuarioService;
import br.com.douglas.gac.service.ArmarioService;
import br.com.douglas.gac.service.BlocoService;

@SpringBootApplication
public class gacApplication implements ApplicationRunner {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	BlocoService blocoService;

	@Autowired
	ArmarioService armarioService;

	
	public static void main(String[] args) {
		SpringApplication.run(gacApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}

}
