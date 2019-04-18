package com.boneacsu.research.pdf.testapachepdfbox.extractors;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IPDFTextExtractor {
    String TIKA = "tika";
    String BOX = "pdf-box";

    String getLibraryName();
    List<String> getListOfContents(File pdfFile) throws IOException;
}
