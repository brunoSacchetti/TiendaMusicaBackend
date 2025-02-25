package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.Dto.InstrumentoDto.InstrumentoDto;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Line;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import org.springframework.stereotype.Service;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

@Service
public class PdfReportServiceImplementation implements PdfReportService {

    //Descargamos de internet con este metodo la imagen
    private static byte[] getImageData(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        try (InputStream inputStream = url.openStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
        }
    }


    /* public byte[] generarPdfDetalleInst(InstrumentoDto instrumentDto) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);

            PdfFont font = PdfFontFactory.createFont();

            Color fontColor = new DeviceRgb(50, 205, 50); // Verde
            Color fontColor2 = new DeviceRgb(220, 136, 40); // Naranja


            // Crear una División para los datos
            Div dataDiv = new Div().setTextAlignment(TextAlignment.RIGHT);

            // Crear una instancia de Image con la ImageData
            byte[] imageData = getImageData(instrumentDto.getImagen());
            ImageData imgData = ImageDataFactory.create(imageData);
            Image image = new Image(imgData);

            // Definir el ancho y alto deseados
            float newWidth = 200;
            float newHeight = 200;

            float newX = 60; // Nueva coordenada x
            float newY = 550; // Nueva coordenada y

            // Establecer la posición de la imagen
            image.setFixedPosition(newX, newY);

            // Establecer el tamaño de la imagen
            image.scaleToFit(newWidth, newHeight);

            // Agregar la imagen al documento
            document.add(image);

            float divX = 300; // Nueva coordenada x para el Div del texto
            float divY = 550; // Nueva coordenada y para el Div del texto

            // Establecer la posición del Div del texto
            dataDiv.setFixedPosition(divX, divY, 180);

            // Agregar celdas con los datos del instrumento
            dataDiv.add(new Paragraph(Integer.toString(instrumentDto.getCantidadVendida()) + " unidades vendidas").setFont(font).setFontSize(10));
            dataDiv.add(new Paragraph(instrumentDto.getInstrumento()).setFont(font).setFontSize(18));
            dataDiv.add(new Paragraph("$" + instrumentDto.getPrecio()).setFont(font).setFontSize(15));
            dataDiv.add(new Paragraph("Marca: " + instrumentDto.getMarca()).setFont(font).setFontSize(12));
            dataDiv.add(new Paragraph("Modelo: " + instrumentDto.getModelo()).setFont(font).setFontSize(12));
            if (instrumentDto.getCostoEnvio().equalsIgnoreCase("G") || instrumentDto.getCostoEnvio().equalsIgnoreCase("0")) {
                dataDiv.add(new Paragraph("Envío gratis").setFontColor(fontColor).setFont(font).setFontSize(12));
            } else {
                dataDiv.add(new Paragraph("Costo de Envío: $" + instrumentDto.getCostoEnvio()).setFontColor(fontColor2).setFont(font).setFontSize(12));
            }
            dataDiv.add(new Paragraph("Descripción: " + instrumentDto.getDescripcion()).setFont(font).setFontSize(12));

            // Agregar las divisiones al documento
            document.add(dataDiv);

            document.close();
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    } */

    public byte[] generarPdfDetalleInst(InstrumentoDto instrumentDto) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);

            PdfFont font = PdfFontFactory.createFont();

            Color fontColor = new DeviceRgb(50, 205, 50); // Verde
            Color fontColor2 = new DeviceRgb(220, 136, 40); // Naranja
            Color borderColor = new DeviceRgb(169, 169, 169); // Gris para el borde

            // Crear una División principal que actuará como la "card"
            Div cardDiv = new Div();
            cardDiv.setBorder(new SolidBorder(borderColor, 1)); // Borde gris
            cardDiv.setPadding(10); // Padding interno del "card"
            cardDiv.setWidth(450); // Ancho del "card"
            cardDiv.setHeight(550); // Alto del "card"
            cardDiv.setTextAlignment(TextAlignment.CENTER); // Alineación central para contenido

            // Crear una instancia de Image con la ImageData
            byte[] imageData = getImageData(instrumentDto.getImagen());
            ImageData imgData = ImageDataFactory.create(imageData);
            Image image = new Image(imgData);

            // Definir el ancho y alto deseados
            float newWidth = 260;
            float newHeight = 260;

            // Establecer el tamaño de la imagen
            image.scaleToFit(newWidth, newHeight);

            // Crear una División para los datos
            Div dataDiv = new Div().setTextAlignment(TextAlignment.CENTER);
            dataDiv.setMarginTop(10);

            // Agregar celdas con los datos del instrumento
            dataDiv.add(new Paragraph(Integer.toString(instrumentDto.getCantidadVendida()) + " unidades vendidas").setFont(font).setFontSize(10));
            dataDiv.add(new Paragraph(instrumentDto.getInstrumento()).setFont(font).setFontSize(20));
            dataDiv.add(new Paragraph("$" + instrumentDto.getPrecio()).setFont(font).setFontSize(17));
            dataDiv.add(new Paragraph("Marca: " + instrumentDto.getMarca()).setFont(font).setFontSize(14));
            dataDiv.add(new Paragraph("Modelo: " + instrumentDto.getModelo()).setFont(font).setFontSize(14));
            if (instrumentDto.getCostoEnvio().equalsIgnoreCase("G") || instrumentDto.getCostoEnvio().equalsIgnoreCase("0")) {
                dataDiv.add(new Paragraph("Envío gratis").setFontColor(fontColor).setFont(font).setFontSize(13));
            } else {
                dataDiv.add(new Paragraph("Costo de Envío: $" + instrumentDto.getCostoEnvio()).setFontColor(fontColor2).setFont(font).setFontSize(13));
            }
            dataDiv.add(new Paragraph("Descripción: " + instrumentDto.getDescripcion()).setFont(font).setFontSize(14));

            // Agregar la imagen y la división de datos al "card"
            cardDiv.add(image);
            cardDiv.add(new LineSeparator(new SolidLine(1)).setMarginTop(10).setMarginBottom(10)); // Línea separadora
            cardDiv.add(dataDiv);

            // Ajustar la posición del "card"
            document.add(cardDiv.setFixedPosition(60, 200, cardDiv.getWidth())); // Cambia la coordenada Y a 200 para bajarlo

            document.close();
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}


