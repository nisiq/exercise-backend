package br.ETS.Feedback.controller;

import br.ETS.Feedback.model.instrutor.*;
import br.ETS.Feedback.model.instrutor.dto.InstructorDataListing;
import br.ETS.Feedback.model.instrutor.dto.InstructorRegistrationData;
import br.ETS.Feedback.model.instrutor.dto.InstructorUpdateData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/instrutor")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    @PostMapping
    public ResponseEntity<InstructorDataListing> cadastrar(@RequestBody @Valid InstructorRegistrationData instructorRegistrationData, UriComponentsBuilder uriComponentsBuilder){
        var instrutor = new Instrutor(instructorRegistrationData);
        instructorRepository.save(instrutor);
        var uri= uriComponentsBuilder.path("/instrutor/{id}").buildAndExpand(instrutor.getId()).toUri();
        return ResponseEntity.created(uri).body(new InstructorDataListing(instrutor));
    }

    @GetMapping
    public ResponseEntity<Page<InstructorDataListing>> listar(@PageableDefault(sort = {"nome"}) Pageable pageable){
//        http://localhost:8081/instrutor?size=3&page=1
//        http://localhost:8081/instrutor?sort=nome - ordernar por nome
        var page = instructorRepository.findAllByAtivoTrue(pageable).map(InstructorDataListing::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<InstructorDataListing> atualizar (@RequestBody @Valid InstructorUpdateData instructorUpdateData){
        var instrutor = instructorRepository.getReferenceById(instructorUpdateData.id());
        instrutor.atualizar(instructorUpdateData);
        return ResponseEntity.ok(new InstructorDataListing(instrutor));
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