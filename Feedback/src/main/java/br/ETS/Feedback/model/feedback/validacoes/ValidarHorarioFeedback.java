package br.ETS.Feedback.model.feedback.validacoes;

import br.ETS.Feedback.model.feedback.DTO.DadosAgendamentoFeedback;
import br.ETS.Feedback.model.feedback.ValidarAgendamentoDeFeedback;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidarHorarioFeedback implements ValidarAgendamentoDeFeedback {

    public void validar(DadosAgendamentoFeedback dadosAgendamentoFeedback){
        var dataFeedback = dadosAgendamentoFeedback.dateTime();
        var domingo = dataFeedback.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDoHorario = dataFeedback.getHour() < 8;
        var depoisDoHorario = dataFeedback.getHour() > 17;

        if (domingo || antesDoHorario || depoisDoHorario){
            throw new RuntimeException("Feedback agendado fora do horario.");
        }

    }
}
