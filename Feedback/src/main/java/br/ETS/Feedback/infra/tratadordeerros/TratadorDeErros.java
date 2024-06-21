package br.ETS.Feedback.infra.tratadordeerros;

import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityTypeException.class)
    public ResponseEntity Error404NotFound(){
        return ResponseEntity.notFound().build();
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity Error400BadRequest(MethodArgumentNotValidException){
//        var errors = e.getFieldErros();
//        return ResponseEntity.badRequest().body(
//                errors.stream().map
//        )
//    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity tratarRegraDaAplicacao(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
