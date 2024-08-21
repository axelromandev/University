/*  
        ARCHIVO QUE MODIFICA EL DISEÑO DE LA TABLA PARA PONER COLORES
*/

/*  Paquete  */
package code;

/*  Librerias  */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*  Clase  */
public class TableRender extends DefaultTableCellRenderer{
    
    /*  Metodo con el que se modifica el diseño del jTable  */
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int il) {
        /*  Se crea una objeto tipo etiqueta en la ubicacion de la celda de la tabla con la informacion obtenida */
        JLabel label = (JLabel) super.getTableCellRendererComponent(jtable, o, bln, bln1, i, il);
        /*  Se analiza el valor del jLabel  */
        if(o instanceof String ){
            /*  Variable que guarda el valor  */
            String Dato = (String) o;
            /*  Condicion que si es verdadera marca en rojo la celda y si no la deja de blanco  */
            if(Dato.equals("NO DEFINIDO")){
                /*  Cambia el color del fondo y de la letras  */
                label.setBackground(Color.RED);
                label.setForeground(Color.WHITE);
            } else {
                label.setBackground(Color.WHITE);
                label.setForeground(Color.BLACK);
            }
        }
        /*  Retorna el valor del jLabel  */
        return label;
    }
    
    
    
    
    
}
