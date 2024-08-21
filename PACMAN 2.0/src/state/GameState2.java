package state;

import graphics.Fuentes;
import java.applet.AudioClip;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/* @author AXEL ROMAN */

public class GameState2 extends States {
    private final Fuentes FPX;
//    private final Background bg;
    private AudioClip pointsound = java.applet.Applet.newAudioClip(
            getClass().getResource("/resource/sfx/point.wav"));
    private AudioClip deadsound = java.applet.Applet.newAudioClip(
            getClass().getResource("/resource/sfx/dead.wav"));
    private BufferedImage maze;
    private Dimension dimension;
    private final Color pointcolor = new Color(255, 255, 0);
    private Color mazecolor;
    private boolean ingame = false;
    private boolean dead = false;
    private final int sizesprite = 24;
    private final int mazesize = 27;
    private final int scrsize = mazesize * sizesprite;
    private final int pacanimationdelay = 2;
    private final int pacmananimationcount = 4;
    private final int ghostmax = 12;
    private final int pacmanspeed = 6;
    private final int sizeimage = sizesprite;
    private int pacanimcount = pacanimationdelay;
    private int pacanimdir = 1;
    private int pacmananimpos = 0;
    private int ghostnum = 6;
    public static int score;
    private int lifepacman;
    private int[] dx, dy;
    private int[] ghostx, ghosty, ghostdx, ghostdy, ghostspeed;
    private Image ghost;
    private Image pacman2up, pacman2left, pacman2right, pacman2down;
    private Image pacman3up, pacman3down, pacman3left, pacman3right;
    private Image pacman4up, pacman4down, pacman4left, pacman4right;
    private Image mspacman2up, mspacman2left, mspacman2right, mspacman2down;
    private Image mspacman3up, mspacman3down, mspacman3left,  mspacman3right;
    private Image mspacman4up, mspacman4down, mspacman4left,  mspacman4right;
    private int pacmanx, pacmany, pacmandx, pacmandy;
    private int reqdx, reqdy, viewdx, viewdy;
    private final int validspeeds[] = {1, 2, 3, 4, 6, 8};
    private final int maxspeed = 6;
    private int currentspeed = 3;
    private short[] screendata;
    private Timer timer;
    
    /*
        points 16, 
        19 18 22    |-| 23 |-_ 27 |-_| 31
        17 -- 20    | | 21 |_| 29 void 32
        25 24 28    -_  26 -_| 30
    
        void 0
         3  2  6    |-| 7 |-_ 11 |-_| 15
         1 --  4    | | 5 |_| 13
         9  8 12    -_ 10 -_| 14
    */
    
    // 31 x 28
    // 27 x 21
    private final short leveldata[] = {
        19, 26, 26, 26, 26, 18, 26, 26, 26, 26, 26, 22,  0, 19, 26, 26, 26, 26, 26, 18, 26, 26, 26, 26, 22,     0,0,
        21,  0,  0,  0,  0, 21,  0,  0,  0,  0,  0, 21,  0, 21,  0,  0,  0,  0,  0, 21,  0,  0,  0,  0, 21,     0,0,
        21,  0,  0,  0,  0, 21,  0,  0,  0,  0,  0, 21,  0, 21,  0,  0,  0,  0,  0, 21,  0,  0,  0,  0, 21,     0,0,
        17, 26, 26, 26, 26, 16, 26, 18, 26, 26, 26, 24, 26, 24, 26, 26, 26, 18, 26, 16, 26, 26, 26, 26, 20,     0,0,
        21,  0,  0,  0,  0, 21,  0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0, 21,  0,  0,  0,  0, 21,     0,0,
        21,  0,  0,  0,  0, 21,  0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0, 21,  0,  0,  0,  0, 21,     0,0,
        25, 26, 26, 26, 26, 20,  0, 25, 26, 26, 26, 22,  0, 19, 26, 26, 26, 28,  0, 17, 26, 26, 26, 26, 28,     0,0,
         0,  0,  0,  0,  0, 21,  0,  0,  0,  0,  0, 21,  0, 21,  0,  0,  0,  0,  0, 21,  0,  0,  0,  0,  0,     0,0,
         0,  0,  0,  0,  0, 21,  0,  3, 10, 10, 10,  8, 10,  8, 10, 10, 10,  6,  0, 21,  0,  0,  0,  0,  0,     0,0,
         0,  0,  0,  0,  0, 21,  0,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  0, 21,  0,  0,  0,  0,  0,     0,0,
         0,  0,  0,  0,  0, 21,  0,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  0, 21,  0,  0,  0,  0,  0,     0,0,
        27, 26, 26, 26, 26, 16, 10,  4,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1, 10, 16, 26, 26, 26, 26, 30,     0,0,
         0,  0,  0,  0,  0, 21,  0,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  0, 21,  0,  0,  0,  0,  0,     0,0,
         0,  0,  0,  0,  0, 21,  0,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  0, 21,  0,  0,  0,  0,  0,     0,0,
         0,  0,  0,  0,  0, 21,  0,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  0, 21,  0,  0,  0,  0,  0,     0,0,
         0,  0,  0,  0,  0, 21,  0,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  0, 21,  0,  0,  0,  0,  0,     0,0,
        19, 26, 26, 26, 26, 16, 10,  8, 10, 10, 10,  2, 10,  2, 10, 10, 10,  8, 10, 16, 26, 26, 26, 26, 22,     0,0,
        21,  0,  0,  0,  0, 21,  0,  0,  0,  0,  0, 21,  0, 21,  0,  0,  0,  0,  0, 21,  0,  0,  0,  0, 21,     0,0,
        21,  0,  0,  0,  0, 21,  0,  0,  0,  0,  0, 21, 16, 21,  0,  0,  0,  0,  0, 21,  0,  0,  0,  0, 20,     0,0,
        25, 16, 16, 16, 16, 16, 26, 26, 26, 26, 26, 16, 16, 16, 26, 26, 26, 26, 26, 16,  0, 16, 16, 16, 20,     0,0,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,     0,0,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,     0,0,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,     0,0,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,     0,0,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,     0,0,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,     0,0,
        25, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28,     0,0,
    };
    
    public GameState2(StatesManager gsm) throws IOException {
        this.gsm = gsm;
        FPX = new Fuentes();
//        bg = new Background("/resource/background.gif", 1);
//        bg.setVector(-0.4, 0);
        loadImages();
        initVariable();
    }
    

    public void init() {}
    public void update() { 
//        bg.update(); 
    }
    public void draw(Graphics2D g) {
//        bg.draw(g); 
//        g.drawImage(maze, 30, 51, 544, 702, null);
//        
        drawMaze(g);
        drawScore(g);
        doAnim();
        if (ingame) {
            playGame(g);
        } else {
            g.setFont(FPX.fuente(FPX.file, 1, 50));
            g.setColor(new Color(255, 255, 255));
            g.drawString("PRESS TO KEY!", 100, 400);
        }
        
    }
        
    public void keyPressed(int ke) {
            if (ingame) {
                switch (ke) {
                    case KeyEvent.VK_LEFT:
                        reqdx = -1;
                        reqdy = 0;
                        break;
                    case KeyEvent.VK_RIGHT:
                        reqdx = 1;
                        reqdy = 0;
                        break;
                    case KeyEvent.VK_UP:
                        reqdx = 0;
                        reqdy = -1;
                        break;
                    case KeyEvent.VK_DOWN:
                        reqdx = 0;
                        reqdy = 1;
                        break;
                    default:
                        break;
                }
            } else {
                    ingame = true;
                    initGame();
                
            }   
    }
    
    public void keyReleased(int ke) {
        if (ke == Event.LEFT || ke == Event.RIGHT
                    || ke == Event.UP || ke == Event.DOWN) {
                reqdx = 0;
                reqdy = 0;
            }
    }
    
//--------------------------------------------
    private void initVariable(){
        screendata = new short[mazesize * mazesize];
        mazecolor = new Color(0, 255, 0);
        dimension = new Dimension(600, 800);
        ghostx = new int[ghostmax];
        ghostdx = new int[ghostmax];
        ghosty = new int[ghostmax];
        ghostdy = new int[ghostmax];
        ghostspeed = new int[ghostmax];
        dx = new int[4];
        dy = new int[4];
        
        timer = new Timer(20, null);
        timer.start();
    }

    private void doAnim() {
        pacanimcount--;
        if (pacanimcount <= 0) {
            pacanimcount = pacanimationdelay;
            pacmananimpos = pacmananimpos + pacanimdir;
            if (pacmananimpos == (pacmananimationcount - 1) || pacmananimpos == 0) {
                pacanimdir = -pacanimdir;
            }
        }
    }
    
    private void playGame(Graphics2D g) {
        if (dead) {
            death();
        } else {
            movePacman();
            if(CharacterState.character == 0){
                drawPacman(g); 
            } else if(CharacterState.character == 1) { 
                drawMsPacman(g);
            }
            moveGhosts(g);
            checkMaze();
        }
    }
            
    private void drawScore(Graphics2D g) {
        g.setFont(FPX.fuente(FPX.file, 0, 25));
        g.setColor(new Color(204, 204, 0));
        g.drawString("Score: "+score, scrsize / 2 + 96, scrsize + 32);
        for (int i = 0; i < lifepacman; i++) {
            if(CharacterState.character == 0){
                g.drawImage(pacman3left, i * 28 + 8, scrsize + 10,
                        24, 24, null);
            } else if(CharacterState.character == 1) { 
                g.drawImage(mspacman3left, i * 28 + 8, scrsize + 10,
                        24, 24, null);
            }
        }
    }
    
    private void checkMaze() {
        short i = 0;
        boolean finished = true;

        while (i < mazesize * mazesize && finished) {
            if ((screendata[i] & 48) != 0) {
                finished = false; }
            i++; }

        if (finished) {
            score += 50;
            if (ghostnum < ghostmax) {
                ghostnum++;
            }
            if (currentspeed < maxspeed) {
                currentspeed++; }
            initLevel();
        }
    }
    
    private void death() {//murio
        lifepacman--;
        deadsound.play();
        if (lifepacman == 0) {
            ingame = false;
//            gsm.setState(StatesManager.GAMEOVERSTATE);
        }
        continueLevel();
    }
    
    private void moveGhosts(Graphics2D g) {//mover fantasmas
        short i;
        int pos;
        int count;

        for (i = 0; i < ghostnum; i++) {
            if (ghostx[i] % sizesprite == 0 && ghosty[i] % sizesprite == 0) {
                pos = ghostx[i] / sizesprite + mazesize * (int) (ghosty[i] / sizesprite);

                count = 0;

                if ((screendata[pos] & 1) == 0 && ghostdx[i] != 1) {
                    dx[count] = -1;
                    dy[count] = 0;
                    count++;
                }

                if ((screendata[pos] & 2) == 0 && ghostdy[i] != 1) {
                    dx[count] = 0;
                    dy[count] = -1;
                    count++;
                }

                if ((screendata[pos] & 4) == 0 && ghostdx[i] != -1) {
                    dx[count] = 1;
                    dy[count] = 0;
                    count++;
                }

                if ((screendata[pos] & 8) == 0 && ghostdy[i] != -1) {
                    dx[count] = 0;
                    dy[count] = 1;
                    count++;
                }

                if (count == 0) {

                    if ((screendata[pos] & 15) == 15) {
                        ghostdx[i] = 0;
                        ghostdy[i] = 0;
                    } else {
                        ghostdx[i] = -ghostdx[i];
                        ghostdy[i] = -ghostdy[i];
                    }

                } else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }

                    ghostdx[i] = dx[count];
                    ghostdy[i] = dy[count];
                }

            }

            ghostx[i] = ghostx[i] + (ghostdx[i] * ghostspeed[i]);
            ghosty[i] = ghosty[i] + (ghostdy[i] * ghostspeed[i]);
            drawGhost(g, ghostx[i] + 1, ghosty[i] + 1);

            if (pacmanx > (ghostx[i] - 12) && pacmanx < (ghostx[i] + 12)
                    && pacmany > (ghosty[i] - 12) && pacmany < (ghosty[i] + 12)
                    && ingame) {

                dead = true;
            }
        }
    }
        
    private void drawGhost(Graphics2D g, int x, int y) {
        g.drawImage(ghost, x, y, sizeimage, sizeimage, null);
    }
    
        private void movePacman() {

        int pos;
        short ch;

        if (reqdx == -pacmandx && reqdy == -pacmandy) {
            pacmandx = reqdx;
            pacmandy = reqdy;
            viewdx = pacmandx;
            viewdy = pacmandy;
        }

        if (pacmanx % sizesprite == 0 && pacmany % sizesprite == 0) {
            pos = pacmanx / sizesprite + mazesize * (int) (pacmany / sizesprite);
            ch = screendata[pos];

            if ((ch & 16) != 0) {
                pointsound.play();
                screendata[pos] = (short) (ch & 15);
                score++;
            }

            if (reqdx != 0 || reqdy != 0) {
                if (!((reqdx == -1 && reqdy == 0 && (ch & 1) != 0)
                        || (reqdx == 1 && reqdy == 0 && (ch & 4) != 0)
                        || (reqdx == 0 && reqdy == -1 && (ch & 2) != 0)
                        || (reqdx == 0 && reqdy == 1 && (ch & 8) != 0))) {
                    pacmandx = reqdx;
                    pacmandy = reqdy;
                    viewdx = pacmandx;
                    viewdy = pacmandy;
                }
            }

            // Check for standstill
            if ((pacmandx == -1 && pacmandy == 0 && (ch & 1) != 0)
                    || (pacmandx == 1 && pacmandy == 0 && (ch & 4) != 0)
                    || (pacmandx == 0 && pacmandy == -1 && (ch & 2) != 0)
                    || (pacmandx == 0 && pacmandy == 1 && (ch & 8) != 0)) {
                pacmandx = 0;
                pacmandy = 0;
            }
        }
        pacmanx = pacmanx + pacmanspeed * pacmandx;
        pacmany = pacmany + pacmanspeed * pacmandy;
    }

    private void drawPacman(Graphics2D g) {
        if (viewdx == -1) {
            drawPacnanLeft(g);
        } else if (viewdx == 1) {
            drawPacmanRight(g);
        } else if (viewdy == -1) {
            drawPacmanUp(g);
        } else {
            drawPacmanDown(g);
        }
    }
    
    private void drawMsPacman(Graphics2D g) {
        if (viewdx == -1) {
            drawMsPacnanLeft(g);
        } else if (viewdx == 1) {
            drawMsPacmanRight(g);
        } else if (viewdy == -1) {
            drawMsPacmanUp(g);
        } else {
            drawMsPacmanDown(g);
        }
    }

    private void drawPacmanUp(Graphics2D g) {
        switch (pacmananimpos) {
            case 1:
                g.drawImage(pacman2up, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 2:
                g.drawImage(pacman3up, pacmanx + 1, pacmany + 1,  sizeimage, sizeimage, null);
                break;
            case 3:
                g.drawImage(pacman4up, pacmanx + 1, pacmany + 1,  sizeimage, sizeimage, null);
                break;
            default:
                g.drawImage(pacman2up, pacmanx + 1, pacmany + 1,  sizeimage, sizeimage, null);
                break;
        }
    }

    private void drawPacmanDown(Graphics2D g) {
        switch (pacmananimpos) {
            case 1:
                g.drawImage(pacman2down, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 2:
                g.drawImage(pacman3down, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 3:
                g.drawImage(pacman4down, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            default:
                g.drawImage(pacman2down, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
        }
    }

    private void drawPacnanLeft(Graphics2D g) {
        switch (pacmananimpos) {
            case 1:
                g.drawImage(pacman2left, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 2:
                g.drawImage(pacman3left, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 3:
                g.drawImage(pacman4left, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            default:
                g.drawImage(pacman2left, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
        }
    }

    private void drawPacmanRight(Graphics2D g) {
        switch (pacmananimpos) {
            case 1:
                g.drawImage(pacman2right, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 2:
                g.drawImage(pacman3right, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 3:
                g.drawImage(pacman4right, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            default:
                g.drawImage(pacman2right, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
        }
    }

        private void drawMsPacmanUp(Graphics2D g) {
        switch (pacmananimpos) {
            case 1:
                g.drawImage(mspacman2up, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 2:
                g.drawImage(mspacman3up, pacmanx + 1, pacmany + 1,  sizeimage, sizeimage, null);
                break;
            case 3:
                g.drawImage(mspacman4up, pacmanx + 1, pacmany + 1,  sizeimage, sizeimage, null);
                break;
            default:
                g.drawImage(mspacman2up, pacmanx + 1, pacmany + 1,  sizeimage, sizeimage, null);
                break;
        }
    }

    private void drawMsPacmanDown(Graphics2D g) {
        switch (pacmananimpos) {
            case 1:
                g.drawImage(mspacman2down, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 2:
                g.drawImage(mspacman3down, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 3:
                g.drawImage(mspacman4down, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            default:
                g.drawImage(mspacman2down, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
        }
    }

    private void drawMsPacnanLeft(Graphics2D g) {
        switch (pacmananimpos) {
            case 1:
                g.drawImage(mspacman2left, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 2:
                g.drawImage(mspacman3left, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 3:
                g.drawImage(mspacman4left, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            default:
                g.drawImage(mspacman2left, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
        }
    }

    private void drawMsPacmanRight(Graphics2D g) {
        switch (pacmananimpos) {
            case 1:
                g.drawImage(mspacman2right, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 2:
                g.drawImage(mspacman3right, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            case 3:
                g.drawImage(mspacman4right, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
            default:
                g.drawImage(mspacman2right, pacmanx + 1, pacmany + 1, sizeimage, sizeimage, null);
                break;
        }
    }
    
    private void drawMaze(Graphics2D g) {
        short i = 0;
        for(int y = 0; y < scrsize; y += sizesprite) {
            for (int x = 0; x < scrsize; x += sizesprite) {
                g.setColor(mazecolor);
                g.setStroke(new BasicStroke(1));

                if ((screendata[i] & 1) != 0) {
                    g.drawLine(x, y, x, y + sizesprite - 1);
                }

                if ((screendata[i] & 2) != 0) {
                    g.drawLine(x, y, x + sizesprite - 1, y);
                }

                if ((screendata[i] & 4) != 0) {
                    g.drawLine(x + sizesprite - 1, y, x + sizesprite - 1,
                            y + sizesprite - 1);
                }

                if ((screendata[i] & 8) != 0) {
                    g.drawLine(x, y + sizesprite - 1, x + sizesprite - 1,
                            y + sizesprite - 1);
                }

                if ((screendata[i] & 16) != 0) {
                    g.setColor(pointcolor);
                    g.fillRect(x + 11, y + 11, 2, 2);
                }

                i++;
            }
        }
    }

    private void initGame() {
        lifepacman = 3;
        score = 0;
        initLevel();
        ghostnum = 3;
        currentspeed = 3;
    }

    private void initLevel() {
        for (int i = 0; i < mazesize * mazesize; i++) {
            screendata[i] = leveldata[i]; }
        continueLevel();
    }

    private void continueLevel() {
        int dx = 1;
        int random;

        for (short i=0; i < ghostnum; i++) {
            ghosty[i] = 10 * sizesprite;
            ghostx[i] = 12 * sizesprite;
            ghostdy[i] = 0;
            ghostdx[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (currentspeed + 1));
            if (random > currentspeed) {
                random = currentspeed;
            }
            ghostspeed[i] = validspeeds[random];
        }
        pacmanx = 7 * sizesprite;
        pacmany = 11 * sizesprite;
        pacmandx = 0;
        pacmandy = 0;
        reqdx = 0;
        reqdy = 0;
        viewdx = -1;
        viewdy = 0;
        dead = false;
    }
    
    
    
    private void loadImages() {
        ghost          = new ImageIcon(getClass().getResource("/resource/sprite/ghost.gif")).getImage();
        pacman2up      = new ImageIcon(getClass().getResource("/resource/sprite/p-up1.gif")).getImage();
        pacman3up      = new ImageIcon(getClass().getResource("/resource/sprite/p-up2.gif")).getImage();
        pacman4up      = new ImageIcon(getClass().getResource("/resource/sprite/p-up3.gif")).getImage();
        pacman2down    = new ImageIcon(getClass().getResource("/resource/sprite/p-down1.gif")).getImage();
        pacman3down    = new ImageIcon(getClass().getResource("/resource/sprite/p-down2.gif")).getImage();
        pacman4down    = new ImageIcon(getClass().getResource("/resource/sprite/p-down3.gif")).getImage();
        pacman2left    = new ImageIcon(getClass().getResource("/resource/sprite/p-left1.gif")).getImage();
        pacman3left    = new ImageIcon(getClass().getResource("/resource/sprite/p-left2.gif")).getImage();
        pacman4left    = new ImageIcon(getClass().getResource("/resource/sprite/p-left3.gif")).getImage();
        pacman2right   = new ImageIcon(getClass().getResource("/resource/sprite/p-right1.gif")).getImage();
        pacman3right   = new ImageIcon(getClass().getResource("/resource/sprite/p-right2.gif")).getImage();
        pacman4right   = new ImageIcon(getClass().getResource("/resource/sprite/p-right3.gif")).getImage();
        mspacman2up    = new ImageIcon(getClass().getResource("/resource/sprite/m-up1.gif")).getImage();
        mspacman3up    = new ImageIcon(getClass().getResource("/resource/sprite/m-up2.gif")).getImage();
        mspacman4up    = new ImageIcon(getClass().getResource("/resource/sprite/m-up3.gif")).getImage();
        mspacman2down  = new ImageIcon(getClass().getResource("/resource/sprite/m-down1.gif")).getImage();
        mspacman3down  = new ImageIcon(getClass().getResource("/resource/sprite/m-down2.gif")).getImage();
        mspacman4down  = new ImageIcon(getClass().getResource("/resource/sprite/m-down3.gif")).getImage();
        mspacman2left  = new ImageIcon(getClass().getResource("/resource/sprite/m-left1.gif")).getImage();
        mspacman3left  = new ImageIcon(getClass().getResource("/resource/sprite/m-left2.gif")).getImage();
        mspacman4left  = new ImageIcon(getClass().getResource("/resource/sprite/m-left3.gif")).getImage();
        mspacman2right = new ImageIcon(getClass().getResource("/resource/sprite/m-right1.gif")).getImage();
        mspacman3right = new ImageIcon(getClass().getResource("/resource/sprite/m-right2.gif")).getImage();
        mspacman4right = new ImageIcon(getClass().getResource("/resource/sprite/m-right3.gif")).getImage();
    }
 
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

