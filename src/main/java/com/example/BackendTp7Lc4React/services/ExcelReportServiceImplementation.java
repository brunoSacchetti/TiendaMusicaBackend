package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.Dto.PedidoInfoDto.PedidoInfoDto;
import com.example.BackendTp7Lc4React.repositories.PedidoDetalleRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Service
public class ExcelReportServiceImplementation implements ExcelReportService {
        @Autowired
        private PedidoDetalleRepository pedidoDetalleRepository;

    public byte[] generarExcel(Date fechaDesde, Date fechaHasta) throws IOException {
        // Obtener los datos de la base de datos
        List<PedidoInfoDto> reportData = pedidoDetalleRepository.getReportDataPorFecha(fechaDesde, fechaHasta);

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            // Crear una hoja en el libro
            Sheet sheet = workbook.createSheet("Reporte de Pedidos");

            // Crear la primera fila (encabezados)
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Número de Pedido", "Fecha Pedido", "Instrumento", "Marca", "Modelo", "Cantidad", "Precio", "Subtotal"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Llenar los datos en el archivo Excel
            int rowNum = 1;
            for (PedidoInfoDto pedido : reportData) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(pedido.getNumeroPedido());
                row.createCell(1).setCellValue(pedido.getFecha_pedido().toString());
                row.createCell(2).setCellValue(pedido.getInstrumento());
                row.createCell(3).setCellValue(pedido.getMarca());
                row.createCell(4).setCellValue(pedido.getModelo());
                row.createCell(5).setCellValue(pedido.getCantidad());
                row.createCell(6).setCellValue(pedido.getPrecio());
                row.createCell(7).setCellValue(pedido.getSubtotal());
            }

            // Escribir el libro en el flujo de salida
            workbook.write(out);
            return out.toByteArray();
        }
    }
}

