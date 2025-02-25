package com.example.BackendTp7Lc4React.repositories;

import com.example.BackendTp7Lc4React.entities.Dto.PedidoPorMesDto.PedidoPorMesDto;
import com.example.BackendTp7Lc4React.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT NEW com.example.BackendTp7Lc4React.entities.Dto.PedidoPorMesDto.PedidoPorMesDto" +
            "(YEAR(p.fechaPedido), MONTH(p.fechaPedido), COUNT(p)) " +
            "FROM Pedido p GROUP BY YEAR(p.fechaPedido), MONTH(p.fechaPedido)")
    List<PedidoPorMesDto> findPedidosGroupedByMonthAndYear();



}
