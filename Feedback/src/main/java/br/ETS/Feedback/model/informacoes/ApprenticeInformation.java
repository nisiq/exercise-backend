package br.ETS.Feedback.model.informacoes;

import br.ETS.Feedback.model.apprentice.Shift;
import br.ETS.Feedback.model.instrutor.Curso;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class ApprenticeInformation {
    private String classroom;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    public ApprenticeInformation(ApprenticeDataInformation apprenticeDataInformation){
        this.classroom = apprenticeDataInformation.classroom();
        this.shift = apprenticeDataInformation.shift();
    }

    public void apprenticeUpdate(ApprenticeDataInformation apprenticeDataInformation){
        this.classroom = apprenticeDataInformation.classroom() != null ? apprenticeDataInformation.classroom() : this.classroom;
        this.shift = apprenticeDataInformation.shift() != null ? apprenticeDataInformation.shift() : this.shift;
    }

}
