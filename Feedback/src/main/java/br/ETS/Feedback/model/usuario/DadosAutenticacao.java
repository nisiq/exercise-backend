package br.ETS.Feedback.model.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(
        @NotNull String login,
        @NotNull String senha
) {

}
