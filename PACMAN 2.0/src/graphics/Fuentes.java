package graphics;

import java.awt.Font;
import java.io.InputStream;

/* @author AXEL ROMAN */

public class Fuentes {
    private Font font = null;
    public String file = "/resource/font/font.ttf";
    
    public Font fuente( String fontName, int estilo, float tamanio)
    {
         try {
            InputStream is = getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);            
        }
        Font tfont = font.deriveFont(estilo, tamanio);
        return tfont;
    }
}