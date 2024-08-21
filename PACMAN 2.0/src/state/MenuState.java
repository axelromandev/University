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

public class MenuState extends States{
    
    private Background bg;
    public static AudioClip music;
    private BufferedImage btnStart;
    private BufferedImage btnInfo;
    private BufferedImage btnHelp;
    private BufferedImage btnExit;
    private int currentChoice = 0;
    private int pos=0;
    private static boolean dipose = false;
    private String[] options = { "START", "INFO", "HELP", "EXIT"};
    private Fuentes FPX;
    private AudioClip sfxButton = java.applet.Applet.
            newAudioClip(getClass().getResource("/resource/sfx/button.wav"));
    private AudioClip sfxSelect = java.applet.Applet.
            newAudioClip(getClass().getResource("/resource/sfx/select.wav"));
    
    public MenuState(StatesManager gsm){
        this.gsm = gsm;
            music = java.applet.Applet.newAudioClip(
                    getClass().getResource("/resource/sfx/game.wav"));
            music.loop(); 
        try {
            bg = new Background("/resource/background.gif", 1);
            btnStart = ImageIO.read(getClass().
                    getResourceAsStream("/resource/sprite/btn-start.png"));
            btnInfo  = ImageIO.read(getClass().
                    getResourceAsStream("/resource/sprite/btn-info.png"));
            btnHelp  = ImageIO.read(getClass().
                    getResourceAsStream("/resource/sprite/btn-help.png"));
            btnExit  = ImageIO.read(getClass().
                    getResourceAsStream("/resource/sprite/btn-exit.png"));
            FPX = new Fuentes();
            bg.setVector(-0.4, 0);
        } catch (Exception e) { }
    }
    
    public void init() { }
    public void update() { bg.update(); }
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
        
        // draw menu options
        g.setFont(FPX.fuente(FPX.file, 0, 80));
        for(int i=0; i<options.length; i++){
            if(i == currentChoice){
                g.setColor(new Color(255, 255, 255));
            } else {
                g.setColor(new Color(128, 128, 128));
            }
            g.drawString(options[i], 182, 310 + i * 110); }
        
        // draw pacman menu
        if(currentChoice == 0){ pos=260;
        g.drawImage(btnStart, 130, pos, 40, 40, null); }
        if(currentChoice == 1){ pos=370;
        g.drawImage(btnInfo, 130, pos, 40, 40, null); }
        if(currentChoice == 2){ pos=480;
        g.drawImage(btnHelp, 130, pos, 40, 40, null); }
        if(currentChoice == 3){ pos=590;
        g.drawImage(btnExit, 130, pos, 40, 40, null); }
       
    }
    
    public void select(){
        if(currentChoice == 0){ // start   
            gsm.setState(StatesManager.CHARACTERSTATE); }
        if(currentChoice == 1){ // info
            gsm.setState(StatesManager.INFOSTATE); }
        if(currentChoice == 2){ //help
            gsm.setState(StatesManager.HELPSTATE); }
        if(currentChoice == 3){ //exit
            music.stop();
            System.exit(0); }
    }
    
    public void keyPressed(int ke) {
        if(ke == KeyEvent.VK_ENTER){
            sfxSelect.play();
            dipose = true;
            select(); 
        }
        
        if(ke == KeyEvent.VK_ESCAPE){
            sfxSelect.play();
            music.stop();
            System.exit(0);}
        
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


