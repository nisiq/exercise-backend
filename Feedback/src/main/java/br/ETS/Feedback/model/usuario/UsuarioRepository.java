package br.ETS.Feedback.model.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    UserDetails findByLogin(String username);
}