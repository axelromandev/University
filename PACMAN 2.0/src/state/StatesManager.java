package state; 

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

 /* @author AXEL ROMAN */

public class StatesManager {

    
    private final ArrayList<States> states;
    private int currentState;
    public static final int MENUSTATE = 0;
    public static final int CHARACTERSTATE = 1;
    public static final int INFOSTATE = 2;
    public static final int HELPSTATE = 3;
    public static final int GAMESTATE = 4;
    public static final int GAMEOVERSTATE = 5;
    public static final int PAUSESTATE = 6;
    
    public StatesManager() throws IOException{
        states = new ArrayList<States>();
        currentState = MENUSTATE;
        states.add(new MenuState(this));
        states.add(new CharacterState(this));
        states.add(new InfoState(this));
        states.add(new HelpState(this));
        states.add(new GameState(this));
        states.add(new GameOverState(this));
        states.add(new PauseState(this));
        
        
    }
    
    public void setState(int state){
        currentState = state;
        states.get(currentState).init();
    }
    
    public void update(){
        states.get(currentState).update();
    }
    
    public void draw(Graphics2D g){
        states.get(currentState).draw(g);
    }
    
    public void keyPressed(int ke){
        states.get(currentState).keyPressed(ke);
    }
    
    public void keyReleased(int ke){
        states.get(currentState).keyReleased(ke);
    }
    
    
}
