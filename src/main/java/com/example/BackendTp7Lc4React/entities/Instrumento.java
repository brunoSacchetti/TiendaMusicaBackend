package com.example.BackendTp7Lc4React.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "instrumento")
public class Instrumento extends Base{


    private String instrumento;

    private String marca;

    private String modelo;

    private String imagen;

    private Double precio;

    private String costoEnvio;

    private int cantidadVendida;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaInstrumento categoria;

    @OneToMany(mappedBy = "instrumento", cascade = CascadeType.ALL)
    @JsonIgnore//Evita la recursivdad stackoverflow
    private List<PedidoDetalle> pedidos = new ArrayList<>();

}
