package br.ETS.Feedback.controller;

import br.ETS.Feedback.model.instrutor.DadosCadastro;
import br.ETS.Feedback.model.instrutor.Instrutor;
import br.ETS.Feedback.model.instrutor.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    // Inicializar a interface
    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastro dadosCadastro){
        instrutorRepository.save(new Instrutor(dadosCadastro));
    }

}