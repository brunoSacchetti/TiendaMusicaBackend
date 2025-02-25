package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.Dto.CantidadPedidosInstrumentos.CantidadPedidosInstrumentoDto;
import com.example.BackendTp7Lc4React.entities.Dto.FechasLimites.FechasLimitesDto;
import com.example.BackendTp7Lc4React.entities.Dto.PedidoInfoDto.PedidoInfoDto;
import com.example.BackendTp7Lc4React.entities.Dto.PedidoPorMesDto.PedidoPorMesDto;
import com.example.BackendTp7Lc4React.repositories.PedidoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PedidoDetalleServiceImplementation implements PedidoDetalleService{

    @Autowired
    PedidoDetalleRepository pedidoDetalleRepository;

    public List<CantidadPedidosInstrumentoDto> getCantidadPedidosInstrumentos() {
        return pedidoDetalleRepository.findCantidadPedidosGroupByInst();
    }

    public List<PedidoInfoDto> getReportDataPorFecha(Date fechaDesde, Date fechaHasta) {
        return pedidoDetalleRepository.getReportDataPorFecha(fechaDesde, fechaHasta);
    }

    public List<PedidoInfoDto> getReportData() {
        return pedidoDetalleRepository.getReportData();
    }

    public FechasLimitesDto getFechasLimites(){
        return pedidoDetalleRepository.getFechasLimites();
    }
}
