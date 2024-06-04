package br.ETS.Feedback.model.informacoes;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Embeddable
public class InstructorInformation {
    private String disciplina;
    private String trilha;
    private String faculdade;
    private String turma;

    // constructor
    public InstructorInformation(InstructorDataInformation instructorDataInformation){
        this.disciplina = instructorDataInformation.disciplina();
        this.trilha = instructorDataInformation.trilha();
        this.faculdade = instructorDataInformation.faculdade();
        this.turma = instructorDataInformation.turma();
    }

    public void atualizar(InstructorDataInformation instructorDataInformation){
        this.disciplina = instructorDataInformation.disciplina() != null ? instructorDataInformation.disciplina() : this.disciplina;
        this.trilha = instructorDataInformation.trilha() != null ? instructorDataInformation.trilha() : this.trilha;
        this.faculdade = instructorDataInformation.faculdade() != null ? instructorDataInformation.faculdade() : this.faculdade;
        this.turma = instructorDataInformation.turma() != null ? instructorDataInformation.turma() : this.turma;
    }
}
