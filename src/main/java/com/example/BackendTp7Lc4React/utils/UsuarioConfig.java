package com.example.BackendTp7Lc4React.utils;

import com.example.BackendTp7Lc4React.entities.Enum.Rol;
import com.example.BackendTp7Lc4React.entities.Usuario;
import com.example.BackendTp7Lc4React.services.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    public CommandLineRunner cargarUsuarios(UsuarioService usuarioService) {
        return args -> {
            if (!usuarioService.existenUsuarios()) {
                Usuario admin = new Usuario();
                admin.setNombreUsuario("admin");
                admin.setClave("admin123"); // Esta contraseña debería ser encriptada en un entorno real
                admin.setRol(Rol.ADMIN);
                usuarioService.guardarUsuario(admin);

                Usuario operador = new Usuario();
                operador.setNombreUsuario("operador");
                operador.setClave("operador123"); // Esta contraseña debería ser encriptada en un entorno real
                operador.setRol(Rol.OPERADOR);
                usuarioService.guardarUsuario(operador);

                Usuario visor = new Usuario();
                visor.setNombreUsuario("visor");
                visor.setClave("visor123"); // Esta contraseña debería ser encriptada en un entorno real
                visor.setRol(Rol.VISOR);
                usuarioService.guardarUsuario(visor);

            }
            ;
        };
    }
}