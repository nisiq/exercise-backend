package br.ETS.Feedback.controller;

import br.ETS.Feedback.infra.security.DadosTokenJWT;
import br.ETS.Feedback.infra.security.TokenService;
import br.ETS.Feedback.model.usuario.DadosAutenticacao;
import br.ETS.Feedback.model.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dadosAutenticacao){
        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());
        var authentication = manager.authenticate(token);

        var tokenJWT = tokenService.gerarToken((Usuario)authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

    }
}
