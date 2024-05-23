package br.ETS.Feedback.model.instrutor;

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

    public Instrutor(DadosCadastro dadosCadastro) {
        this.nome = dadosCadastro.nome();
        this.email = dadosCadastro.email();
        this.edv = dadosCadastro.edv();
        this.curso = dadosCadastro.curso();
        this.informacoes = new Informacoes(dadosCadastro.informacoes());
    }
}



