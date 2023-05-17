package med.meditec.api.controller;

import jakarta.validation.Valid;
import med.meditec.api.domain.usuario.DatosAutenticacionUsuario;
import med.meditec.api.domain.usuario.Usuario;
import med.meditec.api.infra.security.DatosJWTToken;
import med.meditec.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosUsuario) {

        Authentication AuthToken = new UsernamePasswordAuthenticationToken(
                datosUsuario.nombre(),
                datosUsuario.clave());
        var usuarioAutenticado = authenticationManager.authenticate(AuthToken);
        var JWTtoken= tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }

}
