package br.ETS.Feedback.model.apprentice;


import br.ETS.Feedback.model.informacoes.ApprenticeInformation;
import br.ETS.Feedback.model.instrutor.Curso;
import jakarta.persistence.*;
import lombok.*;


/**
Lombok | Annotation

 Methods of access
 @@Getter - generate the methods getter
 @@Setter - generate the methods setter


 @@AllArgsConstructor - generate a constructor of inicializer all campos of classe
 @@NoArgsConstructor - generate a constructor null parameters - constructor null
 @@EqualsAndHashCode - generate methods 'equal' e 'hashcode'

 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode


/**
 used in the JPA context (Java Persistence API) to map table class in a database


 */
@Entity(name = "Apprentices")
@Table(name = "tbapprentices")

public class Apprentice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String edv;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    private boolean vacation;
    private boolean active;

    @Embedded
    private ApprenticeInformation apprenticeInformation;

    public Apprentice(ApprenticeRegistrationData apprenticeRegistrationData) {
        this.nome = apprenticeRegistrationData.nome();
        this.email = apprenticeRegistrationData.email();
        this.edv = apprenticeRegistrationData.edv();
        this.curso = apprenticeRegistrationData.curso();
        this.vacation = apprenticeRegistrationData.vacation();
        this.active = true;
        this.apprenticeInformation = new ApprenticeInformation(apprenticeRegistrationData.information());
    }
}