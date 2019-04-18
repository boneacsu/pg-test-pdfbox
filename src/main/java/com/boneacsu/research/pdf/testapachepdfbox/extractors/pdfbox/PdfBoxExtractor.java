package com.boneacsu.research.pdf.testapachepdfbox.extractors.pdfbox;

import com.boneacsu.research.pdf.testapachepdfbox.DocumentationConfiguration;
import com.boneacsu.research.pdf.testapachepdfbox.extractors.IPDFTextExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service("box")
public class PdfBoxExtractor implements IPDFTextExtractor {

    @Autowired
    DocumentationConfiguration configuration;

    @Override
    public String getLibraryName() {
        return BOX;
    }

    @Override
    public List<String> getListOfContents(File pdfFile) throws IOException {
        try (PDDocument document = PDDocument.load(pdfFile)) {

            document.getClass();

            if (!document.isEncrypted()) {
                PDFTextStripper tStripper = new PDFTextStripper();
                tStripper.setStartPage(configuration.getTableOfContentPageNo());
                tStripper.setEndPage(configuration.getTableOfContentPageNo());

                String pdfFileInText = tStripper.getText(document);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                }

            }

        }
        return null;
    }
}
