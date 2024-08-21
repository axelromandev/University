package main;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JPanel;
import state.StatesManager;

/* @author AXEL ROMAN */

public class MainPanel extends JPanel implements  Runnable, KeyListener{
    
    // dimensions
    public static final int WIDTH = 300;
    public static final int HEIGHT = 400;
    public static final int SCALE = 2;
    
    // thread
    private Thread thread;
    private boolean running;
    
    // image
    private BufferedImage img;
    private Graphics2D g;
    
    // state manager
    private StatesManager gsm;
    
    public MainPanel(){
        super();
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setFocusable(true);
        setDoubleBuffered(true);
        requestFocus();
    }
    
    public void addNotify(){
        super.addNotify();
        if(thread == null){
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }
    
    
    public void init(){
        img = new BufferedImage(WIDTH * SCALE, HEIGHT * SCALE, 
                BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) img.getGraphics();
        running = true;
        try {
            gsm = new StatesManager();
        } catch (IOException ex) { }
    }
    
    public void run(){
        init();
        
        final double GAME_HARIZ = 30.0;
        final double TBU = 1000000000/GAME_HARIZ; // TIME BEFORE UPDATE
        final int MUBR = 5; // MOUST TIME BEFORE RENDER
        double lastUpdateTime = System.nanoTime(); // 1 + 10 * 9
        double lastRenderTime;
        final double TARGET_FPS = 30;
        final double TIBR = 1000000000/TARGET_FPS; // TOTAL TIME BEFORE RENDER
        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime/1000000000);
        int oldFrameCount = 0;
        
        
        
        while(running){
            double now = System.nanoTime();
            int updateCount = 0;
            while(((now - lastUpdateTime) > TBU) && (updateCount < MUBR)){
                update();
                lastUpdateTime += TBU; 
                updateCount++; }
            if(now - lastUpdateTime > TBU){
                lastUpdateTime = now - TBU; }
            draw();
            drawToScreen();
            lastRenderTime = now;
            frameCount++;
            int thisSecond = (int) (lastUpdateTime/1000000000);
            if(thisSecond > lastSecondTime){
                if(frameCount != oldFrameCount){
                    Main.window.setTitle("PACMAN 2.0 || FPS: "+frameCount);
                    oldFrameCount = frameCount; }
                frameCount = 0;
                lastSecondTime = thisSecond; }
            while(now - lastRenderTime< TIBR && now - lastUpdateTime<TBU){
                Thread.yield();                
                try { Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println("Error: yielding thread");
                } now = System.nanoTime(); } 
            }
            
    }
    
    public void update(){
        gsm.update();
    }
    public void draw(){
        gsm.draw(g);
    }
    public void drawToScreen(){
        Graphics g2 = getGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose();
    }

    // input
    public void keyTyped(KeyEvent ke) { }
    public void keyPressed(KeyEvent ke) { 
        gsm.keyPressed(ke.getKeyCode());
    }
    public void keyReleased(KeyEvent ke) {
        gsm.keyReleased(ke.getKeyCode());
    }
    
    
    
    
}
