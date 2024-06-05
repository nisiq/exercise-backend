package br.ETS.Feedback.model.instrutor;

import br.ETS.Feedback.model.informacoes.InstructorDataInformation;
import jakarta.validation.constraints.NotNull;

public record InstructorUpdateData(
        @NotNull int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        Boolean ferias,
        InstructorDataInformation informacoes) {
}
