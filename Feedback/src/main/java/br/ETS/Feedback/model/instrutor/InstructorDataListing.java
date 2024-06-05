package br.ETS.Feedback.model.instrutor;

import br.ETS.Feedback.model.informacoes.InstructorInformation;

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