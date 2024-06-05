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
    @@Entity - define a class in a JPA entity that must be mapped to a table in the database
    @@Table - details about the table (name, diagrams, indexes)
 */
@Entity(name = "Apprentices")
@Table(name = "tbapprentices")

public class Apprentice {

    /**
     * @@GeneratedValeu (strategy....) - The primary key is automatically generated
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String edv;

    /**
     * @@Enumerated - Store the enum values as String, corresponding to the names of the enum values.
     */
    @Enumerated(EnumType.STRING)
    private Curso curso;

    private boolean vacation;
    private boolean active;

    /**
     *  @@Embedded - The Apprentice Information instance is a built-in class and its fields must be mapped
     *  as columns in the Apprentice entity table.
     */
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

    public void update(ApprenticeUpdateData apprenticeUpdateData){
        if (apprenticeUpdateData.nome() != null){
            this.nome = apprenticeUpdateData.nome();
        }
        if (apprenticeUpdateData.email() != null){
            this.email = apprenticeUpdateData.email();
        }
        if (apprenticeUpdateData.edv() != null){
            this.edv = apprenticeUpdateData.edv();
        }
        if (apprenticeUpdateData.curso() != null){
            this.curso = apprenticeUpdateData.curso();
        }
        if (apprenticeUpdateData.vacation() != null){
            this.vacation = apprenticeUpdateData.vacation();
        }
        if (apprenticeUpdateData.information() != null){
            this.apprenticeInformation.apprenticeUpdate(apprenticeUpdateData.information());
        }
    }

    public void disable(){
        this.active = false;
    }
}