package com.example.fileconverter.api;

import java.io.File;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fileconverter.service.WordtoPDFService;

@RequestMapping("/api")
@RestController
public class WordAPI {

   @Autowired
    private WordtoPDFService wordtoPDFService;

   @PostMapping("/convert")
public String convertWordToPDF() {
    try {
        WordprocessingMLPackage docWord = wordtoPDFService.leerFichero();
        if (docWord == null) {
            return "Error leyendo el Word";
        }

        File archivoPDF = new File("src/main/resources/archivoPrueba/IsabelAllende.pdf");
        wordtoPDFService.convertirWordaPDF(docWord, archivoPDF);

        return "PDF generado en: " + archivoPDF.getAbsolutePath();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error convirtiendo el Word a PDF: " + e.getMessage();
    }
}

}
