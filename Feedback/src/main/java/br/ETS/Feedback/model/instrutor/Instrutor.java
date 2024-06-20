package br.ETS.Feedback.model.instrutor;

import br.ETS.Feedback.model.Curso;
import br.ETS.Feedback.model.informacoes.InstructorInformation;
import br.ETS.Feedback.model.instrutor.dto.InstructorRegistrationData;
import br.ETS.Feedback.model.instrutor.dto.InstructorUpdateData;
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

    public void atualizar(InstructorUpdateData instructorUpdateData){
        if (instructorUpdateData.nome() != null){
            this.nome = instructorUpdateData.nome();
        }
        if (instructorUpdateData.email() != null){
            this.email = instructorUpdateData.email();
        }
        if (instructorUpdateData.edv() != null){
            this.edv = instructorUpdateData.edv();
        }
        if (instructorUpdateData.curso() != null){
            this.curso = instructorUpdateData.curso();
        }
        if (instructorUpdateData.ferias() != null){
            this.ferias = instructorUpdateData.ferias();
        }
        if (instructorUpdateData.informacoes() != null){
            this.instructorInformation.atualizar(instructorUpdateData.informacoes());
        }

    }

    public void excluir(){
        this.ativo = false;
    }


}



