package com.example.BackendTp7Lc4React.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "pedido_detalle")
public class PedidoDetalle extends Base {

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "instrumento_id")
    private Instrumento instrumento;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnore //Evita la recursivdad stackoverflow
    private Pedido pedido;

}
