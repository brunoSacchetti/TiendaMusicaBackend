package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.Usuario;
import com.example.BackendTp7Lc4React.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UsuarioServiceImplementation implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        // Encriptar la contraseña antes de guardarla en la base de datos
        String claveEncriptada = encriptarClave(usuario.getClave());
        usuario.setClave(claveEncriptada);
        return usuarioRepository.save(usuario);
    }

    public Usuario findByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public String encriptarClave(String clave) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(clave.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Manejo de la excepción, podría lanzar una excepción personalizada o simplemente devolver la clave sin encriptar
            return clave;
        }
    }

    public Boolean verificarClave(Long idUsuario, String clave) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario == null) {
            return false; // Usuario no encontrado
        }
        // Aquí podrías verificar si la contraseña en texto plano coincide con la contraseña encriptada en la base de datos
        return usuario.getClave().equals(encriptarClave(clave));
    }

    public boolean existenUsuarios() {
        return usuarioRepository.count() > 0;
    }

}
