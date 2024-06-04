package br.ETS.Feedback.model.instrutor;

import br.ETS.Feedback.model.informacoes.DadosInformacoes;
import br.ETS.Feedback.model.informacoes.Informacoes;

public record DadosListagemInstrutor(
        String nome,
        String email,
        String edv,
        Boolean ferias,
        Curso curso,
        Informacoes informacoes
) {

    public DadosListagemInstrutor(Instrutor instrutor) {
        this(instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getEdv(),
                instrutor.isFerias(),
                instrutor.getCurso(),
                instrutor.getInformacoes()
                );
    }
}
