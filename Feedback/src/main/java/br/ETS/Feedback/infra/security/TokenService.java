package br.ETS.Feedback.infra.security;

import br.ETS.Feedback.model.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("{api.security.token.secret}")
    private String secret;
    public String gerarToken(Usuario usuario){
        try{
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create().withSubject(usuario.getLogin())
                    .withIssuer("Feedback")
                    .withExpiresAt(dataDeExpiracao())
                    .sign(algoritmo);

        }catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    private Instant dataDeExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
