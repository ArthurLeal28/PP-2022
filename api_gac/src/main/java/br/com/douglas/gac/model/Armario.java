package br.com.douglas.gac.model;

import javax.persistence.ForeignKey;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
@Entity(name = "tbArmario")
public class Armario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idBloco", nullable = false, foreignKey = @ForeignKey(name = "fk_bloco_armario"))
    private Bloco bloco;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = true, foreignKey = @ForeignKey(name = "fk_usuario_armario"))
    private Usuario usuario;

    @Column(length = 90)
    private String descricao;

    @Column(length = 45, nullable = false)
    private String status;

    @Column(nullable = false)
    private int linhaArmario;

    @Column(nullable = false)
    private int colunaArmario;

    @Column(nullable = false)
    private double preco;

    public Armario(Bloco bloco, Usuario usuario, String status, int linhaArmario, int colunaArmario) {
        this.bloco = bloco;
        this.usuario = usuario;
        this.status = status;
        this.linhaArmario = linhaArmario;
        this.colunaArmario = colunaArmario;
    }

    public Armario(Bloco bloco, Usuario usuario,int linhaArmario, int colunaArmario) {
        this.bloco = bloco;
        this.usuario = usuario;
        this.status = "livre";
        this.linhaArmario = linhaArmario;
        this.colunaArmario = colunaArmario;
    }

    public Armario(Bloco bloco, int linha, int coluna){
        this.bloco = bloco;
        this.linhaArmario = linha;
        this.colunaArmario = coluna;

        this.status = "livre";
        this.usuario = null;
    }
}
