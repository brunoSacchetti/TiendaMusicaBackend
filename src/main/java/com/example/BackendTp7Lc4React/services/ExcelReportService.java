package com.example.BackendTp7Lc4React.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@Service
public interface ExcelReportService {

    public byte[] generarExcel(Date fechaDesde, Date fechaHasta) throws IOException;

}
