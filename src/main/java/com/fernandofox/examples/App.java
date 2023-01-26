package com.fernandofox.examples;

import com.itextpdf.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            String html = Files.readString(Paths.get("relatoriotest.html"));
            montaPdf(new FileOutputStream("arquivo.pdf"), html);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void montaPdf(OutputStream stream, String html) throws DocumentException, IOException {
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
//        renderer.getFontResolver().addFont("arial.ttf", true);
        renderer.createPDF(stream);
    }
}
