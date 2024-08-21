package state;

import graphics.Background;
import graphics.Fuentes;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/* @author AXEL ROMAN */

public class InfoState extends States{
    
    private Fuentes FPX;
    Background bg;
    private AudioClip sfxSelect = java.applet.Applet.
            newAudioClip(getClass().getResource("/resource/sfx/select.wav"));
    
    public InfoState(StatesManager gsm){
        this.gsm = gsm;
        try {
            FPX = new Fuentes();
            bg = new Background("/resource/background.gif", 1);
            bg.setVector(-0.4, 0);
        } catch (Exception e) { }
        
    }
    
    public void init() {}
    public void update() {
        bg.update();
    }
    public void draw(Graphics2D g) {
        bg.draw(g);
        
        // draw tile
        g.setFont(FPX.fuente(FPX.file, 1, 12));
        g.setColor(new Color(128, 128, 128));
        g.drawString("Copyright (©) 2020 Axel Román", 5, 795);
        g.setFont(FPX.fuente(FPX.file, 0, 120));
        g.setColor(new Color(255, 255, 0));
        g.drawString("PAC", 80, 180);
        g.setColor(new Color(255, 0, 0));
        g.drawString("MAN", 290, 180);
        g.setFont(FPX.fuente(FPX.file, 1, 24));
        g.setColor(new Color(255, 255, 255));
        g.drawString("-{ How to play }-", 160, 210);        
        
    }
    public void keyPressed(int ke) {
        if(ke == KeyEvent.VK_ESCAPE){
            sfxSelect.play();
            gsm.setState(StatesManager.MENUSTATE); }
    }
    public void keyReleased(int ke) {}
    
}
