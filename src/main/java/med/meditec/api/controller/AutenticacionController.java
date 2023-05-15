package med.meditec.api.controller;

import med.meditec.api.domain.usuario.DatosAutenticacionUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity autenticarUsuario(DatosAutenticacionUsuario datosUsuario) {

        Authentication token = new UsernamePasswordAuthenticationToken(
                datosUsuario.nombre(),
                datosUsuario.clave());
        authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }

}
