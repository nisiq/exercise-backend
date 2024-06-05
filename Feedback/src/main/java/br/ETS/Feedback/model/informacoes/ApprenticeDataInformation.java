package br.ETS.Feedback.model.informacoes;

import br.ETS.Feedback.model.apprentice.Shift;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ApprenticeDataInformation(

/**
 * @@NotBlank - Ensures the field is not null and is not empty stronger than @NotNull which still allows empty strings
 */
    @NotBlank String classroom,
    @NotNull Shift shift) {
}
