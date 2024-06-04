package br.ETS.Feedback.controller;

import br.ETS.Feedback.model.instrutor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    // Inicializar a interface
    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastro dadosCadastro){
        instrutorRepository.save(new Instrutor(dadosCadastro));
    }

    @GetMapping
    public Page<DadosListagemInstrutor> listar(@PageableDefault(sort = {"nome"}) Pageable pageable){
//        http://localhost:8081/instrutor?size=3&page=1
//        http://localhost:8081/instrutor?sort=nome - ordernar por nome
        return instrutorRepository.findAllByAtivoTrue(pageable).map(DadosListagemInstrutor::new);
    }

    @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoInstrutor dadosAtualizacaoInstrutor){
        var instrutor = instrutorRepository.getReferenceById(dadosAtualizacaoInstrutor.id());
        instrutor.atualizar(dadosAtualizacaoInstrutor);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Instrutor> excluir(@PathVariable int id){
        var instrutor = instrutorRepository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.noContent().build();
    }


// Transactional sincroniza com o banco


}