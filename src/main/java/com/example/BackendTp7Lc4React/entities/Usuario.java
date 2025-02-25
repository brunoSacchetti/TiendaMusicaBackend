package com.example.BackendTp7Lc4React.entities;

import com.example.BackendTp7Lc4React.entities.Enum.Rol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
public class Usuario extends Base{

    @Column(unique = true)
    private String nombreUsuario;

    @Column(unique = true)
    private String clave;  //string encriptado;

    private Rol rol;

}
