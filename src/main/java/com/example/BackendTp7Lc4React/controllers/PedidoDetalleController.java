package com.example.BackendTp7Lc4React.controllers;

import com.example.BackendTp7Lc4React.entities.Dto.CantidadPedidosInstrumentos.CantidadPedidosInstrumentoDto;
import com.example.BackendTp7Lc4React.services.PedidoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pedido_detalle")
public class PedidoDetalleController {

    @Autowired
    PedidoDetalleService pedidodDetalleService;

    @GetMapping("/cantidad-pedido")
    public List<CantidadPedidosInstrumentoDto> getCantidadPedidosInstrument(){
        return pedidodDetalleService.getCantidadPedidosInstrumentos();
    }

}
