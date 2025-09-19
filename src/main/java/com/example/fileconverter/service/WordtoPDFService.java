package com.example.fileconverter.service;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.stereotype.Service;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.Docx4J;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class WordtoPDFService {

    private final File archivoWord = new File("src/main/resources/archivoPrueba/IsabelAllende.docx");

    // Leer Word desde archivo fijo
    public WordprocessingMLPackage leerFichero() {
        try {
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(archivoWord);
            System.out.println("Word cargado con éxito. Elementos en el documento: "
                    + wordMLPackage.getMainDocumentPart().getContent().size());
            return wordMLPackage;
        } catch (Docx4JException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Convertir Word a PDF usando la API moderna
    public File convertirWordaPDF(WordprocessingMLPackage documentoWord, File archivoPDF) {
        try (FileOutputStream os = new FileOutputStream(archivoPDF)) {
            Docx4J.toPDF(documentoWord, os);
            System.out.println("PDF generado");
            return archivoPDF;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
