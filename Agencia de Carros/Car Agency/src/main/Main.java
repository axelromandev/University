
package main;

import code.ConnectionSQL;
import java.sql.Connection;
import view.Menu;

public class Main {

    public static ConnectionSQL conn;
    public static Connection reg;
    
    
    public static void main(String[] args) {
       Menu.main(args);
       Main main = new Main();
    }
    
    public Main(){
        conn = new ConnectionSQL();
        reg = conn.getConection();
    }
    
}
