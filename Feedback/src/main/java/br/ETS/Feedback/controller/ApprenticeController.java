package br.ETS.Feedback.controller;


import br.ETS.Feedback.model.apprentice.Apprentice;
import br.ETS.Feedback.model.apprentice.ApprenticeRegistrationData;
import br.ETS.Feedback.model.apprentice.ApprenticeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/apprentice")
public class ApprenticeController {

    // Start interface
    @Autowired
    private ApprenticeRepository apprenticeRepository;

    @PostMapping
    public void RegisterApprentice(@RequestBody @Valid ApprenticeRegistrationData apprenticeRegistrationData){
        apprenticeRepository.save(new Apprentice(apprenticeRegistrationData));
    }
}
