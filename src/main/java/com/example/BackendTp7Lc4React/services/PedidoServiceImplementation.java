package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.Dto.PedidoPorMesDto.PedidoPorMesDto;
import com.example.BackendTp7Lc4React.entities.PedidoDetalle;
import com.example.BackendTp7Lc4React.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImplementation implements PedidoService{
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoPorMesDto> getPedidosPorMes() {
        return pedidoRepository.findPedidosGroupedByMonthAndYear();
    }

}
