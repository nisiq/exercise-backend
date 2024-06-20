package br.ETS.Feedback.controller;


import br.ETS.Feedback.model.apprentice.*;
import br.ETS.Feedback.model.apprentice.dto.ApprenticeDataListing;
import br.ETS.Feedback.model.apprentice.dto.ApprenticeRegistrationData;
import br.ETS.Feedback.model.apprentice.dto.ApprenticeUpdateData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 *  define and map controllers that handle HTTP requests.
 */
@RestController
@RequestMapping("/apprentice")
public class ApprenticeController {

    // Start interface
    @Autowired
    private ApprenticeRepository apprenticeRepository;


/**
 * @@RequestBody - Automatically converts the JSON data received in the request body in a java object
 */
    @PostMapping
    public void RegisterApprentice(@RequestBody @Valid ApprenticeRegistrationData apprenticeRegistrationData){
        apprenticeRepository.save(new Apprentice(apprenticeRegistrationData));
    }


    /**
     * @PageableDefault - set default values for paging parameters
     */
    @GetMapping
    public Page<ApprenticeDataListing> list(@PageableDefault(sort = {"nome"})Pageable pageable){
        return apprenticeRepository.findAll(pageable).map(ApprenticeDataListing::new);
    }

    @Transactional
    @PutMapping
    public void update(@RequestBody @Valid ApprenticeUpdateData apprenticeUpdateData){
        var apprentice = apprenticeRepository.getReferenceById(apprenticeUpdateData.id());
        apprentice.update(apprenticeUpdateData);
    }

    /**
     @@PathVariable - used to link a path variable contained in the URL to a parameter, pass id
     */
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Apprentice> disable(@PathVariable int id){
        var apprentice = apprenticeRepository.getReferenceById(id);
        apprentice.disable();
        return ResponseEntity.noContent().build();
    }
}
