package com.example.BackendTp7Lc4React.repositories;

import com.example.BackendTp7Lc4React.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombreUsuario(String nombreUsuario);
}
