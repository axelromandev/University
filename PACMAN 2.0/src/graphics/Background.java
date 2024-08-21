package graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import main.MainPanel;

 /* @author AXEL ROMAN */

public class Background {
    
    private BufferedImage img;
    
    private double x;
    private double y;
    private double dx;
    private double dy;
    
    private double moveScale;
    
    public Background(String file, double ms){
        try {
            img = ImageIO.read(getClass().getResourceAsStream(file));
            moveScale = ms;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setPosition(double x, double y){
        this.x = (x * moveScale) % MainPanel.WIDTH;
        this.y = (y * moveScale) % MainPanel.HEIGHT;
    }
    
    public void setVector(double dx, double dy){
        this.dx = dx;
        this.dy = dy;
    }
    
    public void update(){
        x += dx;
        y += dy;
    }
    
    public void draw(Graphics2D g){
        g.drawImage(img, (int) x, (int) y, null);
        if(x < 0){
            g.drawImage(img, (int) x + MainPanel.WIDTH, (int) y, null); }
        if(x > 0){
            g.drawImage(img, (int) x - MainPanel.WIDTH, (int) y, null); }
        
    }
    
    
    
    
}
