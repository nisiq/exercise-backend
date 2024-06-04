package br.ETS.Feedback.model.instrutor;

import br.ETS.Feedback.model.informacoes.InstructorInformation;
import jakarta.persistence.*;
import lombok.*;

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
    private InstructorInformation instructorInformation;

    private boolean ferias;
    private boolean ativo;

    public Instrutor(InstructorRegistrationData instructorRegistrationData) {
        this.nome = instructorRegistrationData.nome();
        this.email = instructorRegistrationData.email();
        this.edv = instructorRegistrationData.edv();
        this.curso = instructorRegistrationData.curso();
        this.instructorInformation = new InstructorInformation(instructorRegistrationData.informacoes());
        this.ferias = instructorRegistrationData.ferias();
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
            this.instructorInformation.atualizar(dadosAtualizacaoInstrutor.informacoes());
        }

    }

    public void excluir(){
        this.ativo = false;
    }


}



