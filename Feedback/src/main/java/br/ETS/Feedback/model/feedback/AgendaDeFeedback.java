package br.ETS.Feedback.model.feedback;

import br.ETS.Feedback.model.apprentice.ApprenticeRepository;
import br.ETS.Feedback.model.feedback.DTO.DadosAgendamentoFeedback;
import br.ETS.Feedback.model.instrutor.InstructorRepository;
import br.ETS.Feedback.model.instrutor.Instrutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgendaDeFeedback {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private ApprenticeRepository apprenticeRepository;

    @Autowired
    private List<ValidarAgendamentoDeFeedback> validadores;


    @Transactional
    public void agendar(DadosAgendamentoFeedback dadosAgendamentoFeedback){
        if (!apprenticeRepository.existsById(dadosAgendamentoFeedback.idAprendiz())){
            throw new RuntimeException("ID do aprendiz informado não existe");
        }
        if (!instructorRepository.existsById(dadosAgendamentoFeedback.idInstrutror())){
            throw new RuntimeException("ID do instrutor informado não existe");
        }

        validadores.forEach(v -> v.validar(dadosAgendamentoFeedback));


        var aprendiz = apprenticeRepository.findById(dadosAgendamentoFeedback.idAprendiz()).get();
        var instrutor = instructorRepository.findById(dadosAgendamentoFeedback.idInstrutror()).get();
        var dateTime = dadosAgendamentoFeedback.dateTime();
        var feedback = new Feedback(instrutor, aprendiz, dateTime);
        feedbackRepository.save(feedback);
    }

    private Instrutor escolherInstrutor(DadosAgendamentoFeedback dadosAgendamentoFeedback){
        if (dadosAgendamentoFeedback.idInstrutror() != 0){
            return instructorRepository.getReferenceById(dadosAgendamentoFeedback.idInstrutror());
        }
        if (dadosAgendamentoFeedback.idAprendiz() !=0){

        }
        if (dadosAgendamentoFeedback.curso() != null){
            throw new RuntimeException("O curso é obrigatorio quando o instrutor nao foi selecionado");
        }

        return instructorRepository.escolherInstrutorAleatorioLivreNaData(dadosAgendamentoFeedback.curso(), dadosAgendamentoFeedback.dateTime());


    }


}
