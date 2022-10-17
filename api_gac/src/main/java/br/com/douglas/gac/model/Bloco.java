package br.com.douglas.gac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tbBloco")
public class Bloco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloco;

    @Column(nullable = false)
    private int linhaBloco;

    @Column(nullable = false)
    private int colunaBloco;

    public Bloco(int linhaBloco, int colunaBloco) {
        this.linhaBloco = linhaBloco;
        this.colunaBloco = colunaBloco;
    }
}
