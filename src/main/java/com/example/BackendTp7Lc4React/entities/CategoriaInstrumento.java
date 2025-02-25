package com.example.BackendTp7Lc4React.entities;


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
@Table(name = "categorias_instrumentos")
public class CategoriaInstrumento extends Base{

    private String denominacion;


}
