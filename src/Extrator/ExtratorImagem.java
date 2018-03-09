package Extrator;

import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGet2D;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;

public class ExtratorImagem {

    public static float[] Extrator(String caminho) {
       
        float CountAmostra = 0;
        float[] d = new float[3];
        double red, green, blue;
        IplImage imagem = cvLoadImage(caminho);

        for (int altura = 0; altura < imagem.height(); altura++) {
            for (int largura = 0; largura < imagem.width(); largura++) {

                CvScalar scalarExtraiRgb = cvGet2D(imagem, altura, largura);
                blue = scalarExtraiRgb.val(0);
                green = scalarExtraiRgb.val(1);
                red = scalarExtraiRgb.val(2);

                if (blue >= 0 && blue <= 254
                        && green >= 0 && green <= 255
                        && red >= 0 && red <= 255) {
                    CountAmostra++;
                }
            }
        }
        
        d[0] = Float.valueOf(imagem.height() * imagem.width());
        d[1] = CountAmostra;
        d[2] = ((CountAmostra / (imagem.height() * imagem.width())) * 100);
        return d;
    }
}
