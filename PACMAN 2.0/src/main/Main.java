package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

 /* @author Restf  */

public class Main {
        static JFrame window;
        private static final ImageIcon icon = new ImageIcon(MainPanel.class.getResource("/resource/icon.png"));
    
    public static void main(String[] args) {
        window = new JFrame();
        window.setContentPane(new MainPanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setIconImage(icon.getImage());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);      
    }
    
}
