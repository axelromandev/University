package state;

import graphics.Background;
import graphics.Fuentes;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/* @author AXEL ROMAN */

public class CharacterState extends States {

    private Background bg;
    private BufferedImage btnPacman;
    private BufferedImage btnMsPacman;
    private BufferedImage btnBack;
    private Fuentes FPX;
    private int pos = 0;
    private int currentChoice = 0;
    public static int character = 0;
    private String[] options = { "PACMAN", "MS.PACMAN", "BACK"};
    private AudioClip sfxButton = java.applet.Applet.newAudioClip(
            getClass().getResource("/resource/sfx/button.wav"));
    private AudioClip sfxSelect = java.applet.Applet.newAudioClip(
            getClass().getResource("/resource/sfx/select.wav"));
    
    public CharacterState(StatesManager gsm){
        this.gsm = gsm;
        try { bg = new Background("/resource/background.gif", 1);
            FPX = new Fuentes();
            btnPacman = ImageIO.read(getClass().
                    getResourceAsStream("/resource/sprite/btn-start.png"));
            btnMsPacman = ImageIO.read(getClass().
                    getResourceAsStream("/resource/sprite/btn-ms.png"));
            btnBack = ImageIO.read(getClass().
                    getResourceAsStream("/resource/sprite/btn-back.png"));
            bg.setVector(-0.4, 0);
        } catch (Exception e) { }
    }
    
    public void init() { }
    
    public void update() {
        bg.update();
    }

    public void draw(Graphics2D g) {
        // draw background
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
        g.drawString("! Select a Character !", 130, 210);
        
        // draw menu options
        g.setFont(FPX.fuente(FPX.file, 0, 75));
        for(int i=0; i<options.length; i++){
            if(i == currentChoice){
                g.setColor(new Color(255, 255, 255));
            } else {
                g.setColor(new Color(128, 128, 128)); }
            g.drawString(options[i], 182, 340 + i * 110); }
        
        // draw pacman menu
        if(currentChoice == 0){ pos=290; 
            g.drawImage(btnPacman, 130, pos, 40, 40, null); }
        if(currentChoice == 1){ pos=400;
            g.drawImage(btnMsPacman, 130, pos, 40, 40, null); }
        if(currentChoice == 2){ pos=510;
            g.drawImage(btnBack, 130, pos, 40, 40, null); }
        
    }

    public void select(){
        if(currentChoice == 0){ character = 0;
            gsm.setState(StatesManager.GAMESTATE); }
        
        if(currentChoice == 1){ character = 1;
            gsm.setState(StatesManager.GAMESTATE); }
        
        if(currentChoice == 2){
            gsm.setState(StatesManager.MENUSTATE); }
    }
    
    public void keyPressed(int ke) {
        if(ke == KeyEvent.VK_ENTER){
            sfxSelect.play();
            select(); }
        
        if(ke == KeyEvent.VK_ESCAPE){
            sfxSelect.play();
            gsm.setState(StatesManager.MENUSTATE); }
        
        if(ke == KeyEvent.VK_UP){
            sfxButton.play();
            currentChoice--;
            if(currentChoice == -1){
                currentChoice = options.length -1; } }
        
        if(ke == KeyEvent.VK_DOWN){
            sfxButton.play();
            currentChoice++;
            if(currentChoice == options.length){
                currentChoice = 0; } }
        
    }

    public void keyReleased(int ke) { }
    
}
