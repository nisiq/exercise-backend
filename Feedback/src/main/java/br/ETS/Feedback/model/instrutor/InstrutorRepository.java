package br.ETS.Feedback.model.instrutor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Integer> {

    Page <Instrutor> findAllByAtivoTrue(Pageable pageable);

}
