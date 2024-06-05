package br.ETS.Feedback.model.informacoes;

import jakarta.validation.constraints.NotBlank;

public record ApprenticeDataInformation(

/**
 * @@NotBlank - Ensures the field is not null and is not empty stronger than @NotNull which still allows empty strings
 */
    @NotBlank String classroom,
    @NotBlank String shift) {
}
