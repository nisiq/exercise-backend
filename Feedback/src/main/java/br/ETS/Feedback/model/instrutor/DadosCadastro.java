package br.ETS.Feedback.model.instrutor;

import br.ETS.Feedback.model.informacoes.DadosInformacoes;

public record DadosCadastro
        (String nome,
        String email,
        String edv,
        Curso curso,
         DadosInformacoes informacoes
         ) {
}
