package br.ETS.Feedback.model.instrutor.dto;

import br.ETS.Feedback.model.informacoes.InstructorDataInformation;
import br.ETS.Feedback.model.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record InstructorRegistrationData
        (@NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank @Pattern(regexp = "\\d{8}") String edv,
        @NotNull Curso curso,
        @NotNull @Valid InstructorDataInformation informacoes,
         @NotNull Boolean ferias
         ) {
}
