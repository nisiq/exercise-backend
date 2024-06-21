package br.ETS.Feedback.controller;

import br.ETS.Feedback.model.feedback.AgendaDeFeedback;
import br.ETS.Feedback.model.feedback.DTO.DadosAgendamentoFeedback;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feedback")
@SecurityRequirement(name = "bearer-key") //swagger
public class FeedbackController {

    @Autowired
    private AgendaDeFeedback agendaDeFeedback;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoFeedback dadosAgendamentoFeedback){
        agendaDeFeedback.agendar(dadosAgendamentoFeedback);
        return ResponseEntity.ok().build();
    }
}
