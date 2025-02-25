package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
    Usuario findByNombreUsuario(String nombreUsuario);
    Usuario guardarUsuario(Usuario usuario);
    String encriptarClave(String clave);

    Boolean verificarClave(Long idUsuario, String clave);

    boolean existenUsuarios();
}
