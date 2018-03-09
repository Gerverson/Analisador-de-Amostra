/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extrator;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Gerve
 */
public class ImagemLabel {

    public static boolean SetImage(JLabel lab, String Caminho) {
        try {
            File arquivo = new File(Caminho);
            BufferedImage imgBmp = null;
            try {
                imgBmp = ImageIO.read(arquivo);
            } catch (IOException ex) {
                return false;
            }
            ImageIcon imgLabel = new ImageIcon(imgBmp);
            lab.setIcon(new ImageIcon(imgLabel.getImage().getScaledInstance(lab.getWidth(), lab.getHeight(), Image.SCALE_DEFAULT)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
