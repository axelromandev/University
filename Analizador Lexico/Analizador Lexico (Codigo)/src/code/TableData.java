/*  
        ARCHIVO CONTENEDOR DE LA UBICACION DEL LEXEMA Y EL TOKEN ENCONTRADO
*/

/*  Paquete  */
package code;

/*  Clase  */
public class TableData {
    
    /*  Variables  */
    public static int linea;
    public static String lexema;
    public static Tokens token;
    
    /*  Metodo que guarda los valores  */
    public static void setInfoCode(int li, String le, Tokens to){
        linea = li;
        lexema = le;
        token = to;
    }
}
