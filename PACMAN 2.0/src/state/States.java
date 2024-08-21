package state;

import java.awt.Graphics2D;

 /* @author AXEL ROMAN */

public abstract class States {
    protected StatesManager gsm;
    
    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics2D g);
    public abstract void keyPressed(int ke);
    public abstract void keyReleased(int ke);
    
    
    
}
