package com.example.BackendTp7Lc4React.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "pedido")
public class Pedido extends Base{

    private Date fechaPedido;

    private Double totalPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoDetalle> pedidosDetalle = new ArrayList<PedidoDetalle>();



}
