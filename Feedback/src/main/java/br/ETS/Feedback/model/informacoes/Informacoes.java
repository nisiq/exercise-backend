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
public class Informacoes {
    private String disciplina;
    private String trilha;
    private String faculdade;
    private String turma;

    // constructor
    public Informacoes(DadosInformacoes dadosInformacoes){
        this.disciplina = dadosInformacoes.disciplina();
        this.trilha = dadosInformacoes.trilha();
        this.faculdade = dadosInformacoes.Faculdade();
        this.turma = dadosInformacoes.Turma();
    }
}
