package br.ETS.Feedback.model.feedback;

import br.ETS.Feedback.model.apprentice.Apprentice;
import br.ETS.Feedback.model.instrutor.Instrutor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Feedback")
@Table(name = "tbfeedback")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apprentice_id")
    private Apprentice aprendiz;

    private LocalDateTime dateTime;

    public Feedback(Instrutor instrutor, Apprentice aprendiz, LocalDateTime dateTime) {
        this.instrutor = instrutor;
        this.aprendiz = aprendiz;
        this.dateTime = dateTime;
    }
}
