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

@RestController
@RequestMapping("/instrutor")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid InstructorRegistrationData instructorRegistrationData){
        instructorRepository.save(new Instrutor(instructorRegistrationData));
    }

    @GetMapping
    public Page<InstructorDataListing> listar(@PageableDefault(sort = {"nome"}) Pageable pageable){
//        http://localhost:8081/instrutor?size=3&page=1
//        http://localhost:8081/instrutor?sort=nome - ordernar por nome
        return instructorRepository.findAllByAtivoTrue(pageable).map(InstructorDataListing::new);
    }

    @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid InstructorUpdateData instructorUpdateData){
        var instrutor = instructorRepository.getReferenceById(instructorUpdateData.id());
        instrutor.atualizar(instructorUpdateData);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Instrutor> excluir(@PathVariable int id){
        var instrutor = instructorRepository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.noContent().build();
    }


// Transactional sincroniza com o banco


}