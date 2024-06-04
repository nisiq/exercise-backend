package br.ETS.Feedback.model.instrutor;

import br.ETS.Feedback.model.informacoes.DadosInformacoes;
import br.ETS.Feedback.model.informacoes.Informacoes;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity(name = "Instrutor")
@Table(name = "tbinstrutores")
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String edv;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @Embedded
    private Informacoes informacoes;

    private boolean ferias;
    private boolean ativo;

    public Instrutor(DadosCadastro dadosCadastro) {
        this.nome = dadosCadastro.nome();
        this.email = dadosCadastro.email();
        this.edv = dadosCadastro.edv();
        this.curso = dadosCadastro.curso();
        this.informacoes = new Informacoes(dadosCadastro.informacoes());
        this.ferias = dadosCadastro.ferias();
        this.ativo = true;
    }

    public void atualizar(DadosAtualizacaoInstrutor dadosAtualizacaoInstrutor){
        if (dadosAtualizacaoInstrutor.nome() != null){
            this.nome = dadosAtualizacaoInstrutor.nome();
        }
        if (dadosAtualizacaoInstrutor.email() != null){
            this.email = dadosAtualizacaoInstrutor.email();
        }
        if (dadosAtualizacaoInstrutor.edv() != null){
            this.edv = dadosAtualizacaoInstrutor.edv();
        }
        if (dadosAtualizacaoInstrutor.curso() != null){
            this.curso = dadosAtualizacaoInstrutor.curso();
        }
        if (dadosAtualizacaoInstrutor.ferias() != null){
            this.ferias = dadosAtualizacaoInstrutor.ferias();
        }
        if (dadosAtualizacaoInstrutor.informacoes() != null){
            this.informacoes.atualizar(dadosAtualizacaoInstrutor.informacoes());
        }

    }

    public void excluir(){
        this.ativo = false;
    }





}



