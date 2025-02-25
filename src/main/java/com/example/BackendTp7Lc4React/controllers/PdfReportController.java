package com.example.BackendTp7Lc4React.controllers;

import com.example.BackendTp7Lc4React.entities.Dto.InstrumentoDto.InstrumentoDto;
import com.example.BackendTp7Lc4React.services.PdfReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/pdf")
public class PdfReportController {

    @Autowired
    PdfReportService pdfService;

    @PostMapping(value = "/generarReporte-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@RequestBody InstrumentoDto instrumentoDto) {
        byte[] pdfBytes = pdfService.generarPdfDetalleInst(instrumentoDto);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(pdfBytes);
    }

}
