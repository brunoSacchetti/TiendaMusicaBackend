package com.example.BackendTp7Lc4React.repositories;

import com.example.BackendTp7Lc4React.entities.Dto.CantidadPedidosInstrumentos.CantidadPedidosInstrumentoDto;
import com.example.BackendTp7Lc4React.entities.Dto.FechasLimites.FechasLimitesDto;
import com.example.BackendTp7Lc4React.entities.Dto.PedidoInfoDto.PedidoInfoDto;
import com.example.BackendTp7Lc4React.entities.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Long> {

    /* @Query("SELECT NEW com.example.BackendTp7Lc4React.entities.Dto.CantidadPedidosInstrumentos.CantidadPedidosInstrumentoDto " +
            "COUNT(*) as cantidadPedidos, instrmento.instrumento FROM pedido_detalle inner join instrumento" +
            "on pedido_detalle.instrumento_id = instrumento.id group by instrmento.instrumento") */

    @Query("SELECT NEW com.example.BackendTp7Lc4React.entities.Dto.CantidadPedidosInstrumentos.CantidadPedidosInstrumentoDto(" +
            "COUNT(p), p.instrumento.instrumento) " +
            "FROM PedidoDetalle p " +
            "GROUP BY p.instrumento.instrumento")
    List<CantidadPedidosInstrumentoDto> findCantidadPedidosGroupByInst();

    @Query("SELECT NEW com.example.BackendTp7Lc4React.entities.Dto.PedidoInfoDto.PedidoInfoDto(" +
            "pedido.id, function('date', pedido.fechaPedido), instrumento.instrumento, instrumento.marca, " +
            "instrumento.modelo, pedidoDetalle.cantidad, instrumento.precio, " +
            "(pedidoDetalle.cantidad * instrumento.precio)) " +
            "FROM PedidoDetalle pedidoDetalle " +
            "INNER JOIN pedidoDetalle.instrumento instrumento " +
            "INNER JOIN pedidoDetalle.pedido pedido " +
            "WHERE pedido.fechaPedido BETWEEN (:fechaDesde) AND (:fechaHasta)"+
            "ORDER BY pedido.id ASC")
    List<PedidoInfoDto> getReportDataPorFecha(Date fechaDesde, Date fechaHasta);

    @Query("SELECT NEW com.example.BackendTp7Lc4React.entities.Dto.PedidoInfoDto.PedidoInfoDto(" +
            "pedido.id, function('date', pedido.fechaPedido), instrumento.instrumento, instrumento.marca, " +
            "instrumento.modelo, pedidoDetalle.cantidad, instrumento.precio, " +
            "(pedidoDetalle.cantidad * instrumento.precio)) " +
            "FROM PedidoDetalle pedidoDetalle " +
            "INNER JOIN pedidoDetalle.instrumento instrumento " +
            "INNER JOIN pedidoDetalle.pedido pedido " +
            "ORDER BY pedido.id ASC")
    List<PedidoInfoDto> getReportData();

    @Query("SELECT NEW com.example.BackendTp7Lc4React.entities.Dto.FechasLimites.FechasLimitesDto(" +
            "min(p.fechaPedido) as fechaMinima, max(p.fechaPedido) as fechaMaxima) FROM Pedido p")
    FechasLimitesDto getFechasLimites();


}
