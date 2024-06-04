package br.ETS.Feedback.model.informacoes;

import jakarta.persistence.Embeddable;
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
    private String shift;

    public ApprenticeInformation(ApprenticeDataInformation apprenticeDataInformation){
        this.classroom = apprenticeDataInformation.classroom();
        this.shift = apprenticeDataInformation.shift();
    }

}
