package com.example.BackendTp7Lc4React.entities.Dto.CantidadPedidosInstrumentos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CantidadPedidosInstrumentoDto {
    private Long cantidadPedidos;
    private String nombreInstrumento;
}
