package br.ETS.Feedback.model.instrutor;

import br.ETS.Feedback.model.informacoes.DadosInformacoes;
import br.ETS.Feedback.model.informacoes.Informacoes;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoInstrutor(
        @NotNull int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        Boolean ferias,
        DadosInformacoes informacoes) {
}
