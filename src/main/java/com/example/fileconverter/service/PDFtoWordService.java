package com.example.fileconverter.service;

import java.io.File;
import java.io.FileOutputStream;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.stereotype.Service;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;

@Service
public class PDFtoWordService {

    // Implementar la lógica para convertir PDF a Word  

    private final File archivoPDF = new File("src/main/resources/archivoPrueba/IsabelAllende.pdf");
    private final File archivoWordConvertido = new File("src/main/resources/archivoPrueba/IsabelAllendeDesdePDF.docx");

    // PDF → Word
   public String convertirPDFaWord() {
        try (Document pdf = new Document(archivoPDF.getAbsolutePath())) {
            pdf.save(archivoWordConvertido.getAbsolutePath(), SaveFormat.DocX);
            return "Word generado correctamente desde PDF: " + archivoWordConvertido.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error convirtiendo PDF a Word: " + e.getMessage();
        }
    }
   
    }




