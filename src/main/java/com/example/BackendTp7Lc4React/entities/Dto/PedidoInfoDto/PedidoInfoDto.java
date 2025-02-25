package com.example.BackendTp7Lc4React.entities.Dto.PedidoInfoDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoInfoDto {

    private Long numeroPedido;
    private Date fecha_pedido;
    private String instrumento;
    private String marca;
    private String modelo;
    private int cantidad;
    private Double precio;
    private Double subtotal;

}
