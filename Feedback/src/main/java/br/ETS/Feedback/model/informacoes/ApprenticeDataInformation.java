package br.ETS.Feedback.model.informacoes;

import jakarta.validation.constraints.NotBlank;

public record ApprenticeDataInformation(
    @NotBlank String classroom,
    @NotBlank String shift) {
}
