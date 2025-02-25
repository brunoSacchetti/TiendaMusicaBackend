package com.example.BackendTp7Lc4React.controllers;

import com.example.BackendTp7Lc4React.services.ExcelReportService;
import com.example.BackendTp7Lc4React.services.ExcelReportServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api")
public class ExcelReportController {

    @Autowired
    ExcelReportService excelReportService;

    @GetMapping("/generate-excel-report")
    public ResponseEntity<byte[]> generateExcelReport(
            @RequestParam("fechaDesde") String fechaDesde,
            @RequestParam("fechaHasta") String fechaHasta) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaDesdeLocal = dateFormat.parse(fechaDesde);
            Date fechaHastaLocal = dateFormat.parse(fechaHasta);

            byte[] excelBytes = excelReportService.generarExcel(fechaDesdeLocal, fechaHastaLocal);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("filename", "reporte_pedidos-instrumentos.xlsx");
            return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
}
