package com.example.BackendTp7Lc4React.controllers;

import com.example.BackendTp7Lc4React.entities.LoginRequest;
import com.example.BackendTp7Lc4React.entities.Usuario;
import com.example.BackendTp7Lc4React.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {



    @Autowired
    protected UsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        // Encriptar la contraseña antes de guardarla en la base de datos
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    /* @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioService.findByNombreUsuario(request.getUsuario());
        if (usuario != null && usuario.getClave().equals(request.getPassword())) {
            // Autenticación exitosa, devolver el rol del usuario
            return ResponseEntity.ok(usuario.getRol());
        } else {
            // Autenticación fallida
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }*/

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioService.findByNombreUsuario(request.getUser());
        if (usuario != null && usuarioService.encriptarClave(request.getPassword()).equals(usuario.getClave())) {
            // Autenticación exitosa, devolver el rol del usuario
            return ResponseEntity.ok(usuario.getRol());
        } else {
            // Autenticación fallida
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }


    @GetMapping("/{nombreUsuario}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String nombreUsuario) {
        Usuario usuario = usuarioService.findByNombreUsuario(nombreUsuario);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/verificar-clave")
    public boolean verificarClave(@PathVariable Long id, @RequestParam String clave) {
        return usuarioService.verificarClave(id, clave);
    }



}
