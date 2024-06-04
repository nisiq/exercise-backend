package br.ETS.Feedback.model.informacoes;
import jakarta.validation.constraints.NotBlank;

public record InstructorDataInformation(
        @NotBlank String disciplina,
        @NotBlank String trilha,
        @NotBlank String faculdade,
        @NotBlank String turma) {
}
