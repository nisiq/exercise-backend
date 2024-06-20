package br.ETS.Feedback.model.apprentice.dto;

import br.ETS.Feedback.model.apprentice.Apprentice;
import br.ETS.Feedback.model.informacoes.ApprenticeInformation;
import br.ETS.Feedback.model.Curso;

public record ApprenticeDataListing(
        String nome,
        String email,
        String edv,
        Boolean vacation,
        Curso curso,
        ApprenticeInformation apprenticeInformation
) {

    public ApprenticeDataListing(Apprentice apprentice){
        this(apprentice.getNome(),
                apprentice.getEmail(),
                apprentice.getEdv(),
                apprentice.isVacation(),
                apprentice.getCurso(),
                apprentice.getApprenticeInformation()
        );
    }
}
