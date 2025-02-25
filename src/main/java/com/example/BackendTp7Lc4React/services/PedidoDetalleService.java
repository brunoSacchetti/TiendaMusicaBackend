package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.Dto.CantidadPedidosInstrumentos.CantidadPedidosInstrumentoDto;
import com.example.BackendTp7Lc4React.entities.Dto.FechasLimites.FechasLimitesDto;
import com.example.BackendTp7Lc4React.entities.Dto.PedidoInfoDto.PedidoInfoDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface PedidoDetalleService {
    public List<CantidadPedidosInstrumentoDto> getCantidadPedidosInstrumentos();

    public List<PedidoInfoDto> getReportDataPorFecha(Date fechaDesde, Date fechaHasta);

    public List<PedidoInfoDto> getReportData();

    public FechasLimitesDto getFechasLimites();
}
