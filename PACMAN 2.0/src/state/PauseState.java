package state;

import graphics.Fuentes;
import java.awt.Color;
import java.awt.Graphics2D;

 /* @author AXEL ROMAN */

public class PauseState extends States {

    private Fuentes FPX;
    
    public PauseState(StatesManager gsm) {
        this.gsm = gsm;
    }

    public void init() { }
    public void update() { }
    public void draw(Graphics2D g) {
        // draw tile
        g.setFont(FPX.fuente(FPX.file, 1, 12));
        g.setColor(new Color(128, 128, 128));
        g.drawString("Copyright (©) 2020 Axel Román", 5, 795);
    }
    public void keyPressed(int ke) { }
    public void keyReleased(int ke) { }
    
}
