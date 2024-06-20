package br.ETS.Feedback.model.instrutor.dto;

import br.ETS.Feedback.model.informacoes.InstructorInformation;
import br.ETS.Feedback.model.Curso;
import br.ETS.Feedback.model.instrutor.Instrutor;

public record InstructorDataListing(
        String nome,
        String email,
        String edv,
        Boolean ferias,
        Curso curso,
        InstructorInformation instructorInformation
) {

    public InstructorDataListing(Instrutor instrutor) {
        this(instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getEdv(),
                instrutor.isFerias(),
                instrutor.getCurso(),
                instrutor.getInstructorInformation()
                );
    }
}
