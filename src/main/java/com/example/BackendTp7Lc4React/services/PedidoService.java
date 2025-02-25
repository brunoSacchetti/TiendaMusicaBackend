package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.Dto.PedidoPorMesDto.PedidoPorMesDto;
import com.example.BackendTp7Lc4React.entities.PedidoDetalle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface PedidoService{

    public List<PedidoPorMesDto> getPedidosPorMes();

 }
