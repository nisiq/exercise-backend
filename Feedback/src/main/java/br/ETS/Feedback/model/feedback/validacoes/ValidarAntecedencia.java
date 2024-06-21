package br.ETS.Feedback.model.feedback.validacoes;

import br.ETS.Feedback.model.feedback.DTO.DadosAgendamentoFeedback;
import br.ETS.Feedback.model.feedback.ValidarAgendamentoDeFeedback;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidarAntecedencia implements ValidarAgendamentoDeFeedback {

    @Override
    public void validar(DadosAgendamentoFeedback dadosAgendamentoFeedback) {
        var dataFeedback = dadosAgendamentoFeedback.dateTime();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataFeedback).toMinutes();

        if (diferencaEmMinutos<30){
            throw new RuntimeException("Feedback deve ser agendado com antecedencia de 30 minutos");
        }
    }
}
