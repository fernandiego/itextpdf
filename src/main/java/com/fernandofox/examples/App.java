package com.fernandofox.examples;

import com.itextpdf.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

/**
 * Hello world!
 */
public class App {

    public App(OutputStream stream) throws Exception {
        ITextRenderer renderer = preparaRenderer();
        String html = preparaHtml();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(stream);
    }

    private String preparaHtml() throws Exception {
        File file = new File(App.class.getResource("/relatoriotest.html").toURI());
        String html = Files.readString(file.toPath());
        return html;
    }

    public ITextRenderer preparaRenderer() throws Exception {
        ITextRenderer renderer = new ITextRenderer();
        File fonts = new File(App.class.getResource("/fonts").toURI());
        renderer.getFontResolver().addFontDirectory(fonts.getPath(), true);
        return renderer;
    }

    public static void main(String[] args) throws Exception {
        new App(new FileOutputStream("arquivo.pdf"));
    }
}
