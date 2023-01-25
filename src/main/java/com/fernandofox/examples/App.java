package com.fernandofox.examples;

import com.itextpdf.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.IOException;
import java.io.OutputStream;

import static java.lang.System.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        try {
            montaPdf(out, "<h2>Hello</h2>" );
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
        renderer.getFontResolver().addFont("arial.ttf",true);
        renderer.createPDF(stream);
    }
}
