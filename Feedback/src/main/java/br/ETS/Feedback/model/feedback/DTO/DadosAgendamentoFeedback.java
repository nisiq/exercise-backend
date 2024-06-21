package br.ETS.Feedback.model.feedback.DTO;

import br.ETS.Feedback.model.Curso;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoFeedback(@NotNull int idInstrutror,
                                       @NotNull int idAprendiz,
                                       @NotNull @Future LocalDateTime dateTime,
                                       Curso curso       ) {

}
