package br.ETS.Feedback.model.feedback.DTO;

import br.ETS.Feedback.model.feedback.Feedback;

import java.time.LocalDateTime;

public record DadosDetalhamentoFeedback(int id,
                                       int idInstrutor,
                                       int idAprendiz,
                                       LocalDateTime dateTime) {

    public DadosDetalhamentoFeedback(Feedback feedback){
        this(feedback.getId(),
            feedback.getInstrutor().getId(),
            feedback.getAprendiz().getId(),
            feedback.getDateTime());
    }


}
