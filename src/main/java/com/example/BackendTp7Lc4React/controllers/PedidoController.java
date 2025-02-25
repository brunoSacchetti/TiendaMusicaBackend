package com.example.BackendTp7Lc4React.controllers;

import com.example.BackendTp7Lc4React.entities.Dto.FechasLimites.FechasLimitesDto;
import com.example.BackendTp7Lc4React.entities.Dto.PedidoInfoDto.PedidoInfoDto;
import com.example.BackendTp7Lc4React.entities.Dto.PedidoPorMesDto.PedidoPorMesDto;
import com.example.BackendTp7Lc4React.entities.Instrumento;
import com.example.BackendTp7Lc4React.entities.Pedido;
import com.example.BackendTp7Lc4React.entities.PedidoDetalle;
import com.example.BackendTp7Lc4React.repositories.InstrumentoRepository;
import com.example.BackendTp7Lc4React.repositories.PedidoDetalleRepository;
import com.example.BackendTp7Lc4React.repositories.PedidoRepository;
import com.example.BackendTp7Lc4React.services.PedidoDetalleService;
import com.example.BackendTp7Lc4React.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @Autowired
    private PedidoDetalleService pedidoDetalleService;

    @Autowired
    public PedidoService pedidoService;


    /*@PostMapping("/pedidos")
    public ResponseEntity<String> crearPedido(@RequestBody List<PedidoDetalle> detalles) {
        double total = 0;
        Pedido pedido = new Pedido();
        pedido.setFechaPedido(new Date());

        for (PedidoDetalle detalle : detalles) {
            Instrumento instrumento = instrumentoRepository.findById(detalle.getInstrumento().getId()).orElse(null);
            if (instrumento == null) {
                return ResponseEntity.badRequest().body("Instrumento no encontrado");
            }
            detalle.setInstrumento(instrumento);
            detalle.setPedido(pedido);
            total += instrumento.getPrecio() * detalle.getCantidad();
        }

        pedido.setTotalPedido(total);
        pedido.setPedidosDetalle(detalles);
        pedidoRepository.save(pedido);

        return ResponseEntity.ok("El pedido con id " + pedido.getId() + " se guardó correctamente");
    }*/

    /* @PostMapping("/pedidos")
    public ResponseEntity<Long> crearPedido(@RequestBody List<PedidoDetalle> detalles) {
        double total = 0;
        Pedido pedido = new Pedido();
        pedido.setFechaPedido(new Date());

        for (PedidoDetalle detalle : detalles) {
            Instrumento instrumento = instrumentoRepository.findById(detalle.getInstrumento().getId()).orElse(null);
            if (instrumento == null) {
                return ResponseEntity.badRequest().body(0l);
            }
            detalle.setInstrumento(instrumento);
            detalle.setPedido(pedido);
            total += instrumento.getPrecio() * detalle.getCantidad();
        }

        pedido.setTotalPedido(total);
        pedido.setPedidosDetalle(detalles);
        pedidoRepository.save(pedido);

        return ResponseEntity.ok(pedido.getId());
    } */

    @PostMapping("/pedidos")
    public ResponseEntity<Map<String, Object>> crearPedido(@RequestBody List<PedidoDetalle> detalles) {
        double total = 0;
        Pedido pedido = new Pedido();
        pedido.setFechaPedido(new Date());

        for (PedidoDetalle detalle : detalles) {
            Instrumento instrumento = instrumentoRepository.findById(detalle.getInstrumento().getId()).orElse(null);
            if (instrumento == null) {
                return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Instrumento no encontrado"));
            }
            detalle.setInstrumento(instrumento);
            detalle.setPedido(pedido);
            total += instrumento.getPrecio() * detalle.getCantidad();
        }

        pedido.setTotalPedido(total);
        pedido.setPedidosDetalle(detalles);
        pedidoRepository.save(pedido);

        Map<String, Object> response = new HashMap<>();
        response.put("id", pedido.getId());
        response.put("message", "El pedido se guardó correctamente");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/reporte-pedidos")
    public ResponseEntity<List<PedidoInfoDto>> getReportData(
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta
    )
    {
        List<PedidoInfoDto> reportData = pedidoDetalleService.getReportDataPorFecha(fechaDesde, fechaHasta);
        return ResponseEntity.ok(reportData);
    }



    @GetMapping("/all/reporte-pedidos")
    public ResponseEntity<List<PedidoInfoDto>> getReportDataAll() {
        List<PedidoInfoDto> reportData = pedidoDetalleService.getReportData();
        return ResponseEntity.ok(reportData);
    }


    @GetMapping("/pedidos/por-mes")
    public List<PedidoPorMesDto> getPedidosPorMes() {
        return pedidoService.getPedidosPorMes();
    }

    @GetMapping("/pedidos/limite-fechas")
    public FechasLimitesDto getFechasLimites() {
        return pedidoDetalleService.getFechasLimites();
    }

}
