package br.ETS.Feedback.model.instrutor;

import br.ETS.Feedback.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface InstructorRepository extends JpaRepository<Instrutor, Integer> {

    Page <Instrutor> findAllByAtivoTrue(Pageable pageable);

    @Query("""
            select i from Instrutor i
            where 
            i.ativo = true
            and
            i.curso = :curso
            and
            i.id not in(
                        select f.instrutor.id from Feedback f
                        where 
                        f.dateTime = :dateTime
                        )
                        order by rand()
                        limit 1
            """)
    Instrutor escolherInstrutorAleatorioLivreNaData(Curso curso, LocalDateTime dateTime);


}
