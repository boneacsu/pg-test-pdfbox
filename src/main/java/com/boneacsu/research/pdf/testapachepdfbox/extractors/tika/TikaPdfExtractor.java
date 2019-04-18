package com.boneacsu.research.pdf.testapachepdfbox.extractors.tika;

import com.boneacsu.research.pdf.testapachepdfbox.extractors.IPDFTextExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("tika")
public class TikaPdfExtractor implements IPDFTextExtractor {

    @Override
    public String getLibraryName() {
        return TIKA;
    }

    @Override
    public List<String> getListOfContents(File pdfFile) throws IOException {
        try (InputStream input = new FileInputStream((pdfFile))) {

            ParseContext pcontext = new ParseContext();
            ContentHandler textHandler = new BodyContentHandler(-1);
            Metadata metadata = new Metadata();
            PDFParser parser = new PDFParser();

            parser.parse(input, textHandler, metadata, pcontext);
            System.out.println("Document Content:" + textHandler.toString());
            System.out.println("Document Metadata:");
            String[] metadatas = metadata.names();
            for(String data : metadatas) {
                System.out.println(data + ":   " + metadata.get(data));
            }
        } catch (SAXException | TikaException e) {
            throw new IOException(e);
        }


        return null;
    }
}
