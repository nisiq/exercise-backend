package br.ETS.Feedback.model.apprentice;

import br.ETS.Feedback.model.informacoes.ApprenticeDataInformation;
import br.ETS.Feedback.model.instrutor.Curso;
import jakarta.validation.constraints.NotNull;

public record ApprenticeUpdateData(
        @NotNull int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        Boolean vacation,
        ApprenticeDataInformation information) {
}
