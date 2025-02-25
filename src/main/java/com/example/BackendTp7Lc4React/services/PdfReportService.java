package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.Dto.InstrumentoDto.InstrumentoDto;
import org.springframework.stereotype.Service;

@Service
public interface PdfReportService {

    byte[] generarPdfDetalleInst(InstrumentoDto instrumentoDto);

}
