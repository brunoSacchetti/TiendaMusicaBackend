package com.example.BackendTp7Lc4React.entities.Dto.InstrumentoDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentoDto {

    private String instrumento;
    private String marca;
    private String modelo;
    private String imagen;
    private Double precio;
    private String costoEnvio;
    private int cantidadVendida;
    private String descripcion;
}
