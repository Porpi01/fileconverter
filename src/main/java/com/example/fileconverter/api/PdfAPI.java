package com.example.fileconverter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fileconverter.service.PDFtoWordService;

@RequestMapping("/api")
@RestController

public class PdfAPI {

    @Autowired
    private PDFtoWordService pdfToWordService;

    // Endpoint para convertir PDF a Word
   
    @PostMapping("/convertpdf")
    public String convertirPDFaWord() {
        return pdfToWordService.convertirPDFaWord();
    }

}
