package Extrator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class ConvertPdfToImage {

    public static boolean Converter(String Caminho) {
        try {
            File sourceFile = new File(Caminho);

            if (sourceFile.exists()) {
                PDDocument document = PDDocument.load(Caminho);
                @SuppressWarnings("unchecked")
                List<PDPage> list = document.getDocumentCatalog().getAllPages();

                int pageNumber = 1;
                for (PDPage page : list) {
                    BufferedImage image = page.convertToImage();
                    File outputfile = new File(System.getProperty("java.io.tmpdir") + "Amostra" + "_" + pageNumber + ".png");
                    ImageIO.write(image, "png", outputfile);
                    pageNumber++;
                }
                document.close();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
