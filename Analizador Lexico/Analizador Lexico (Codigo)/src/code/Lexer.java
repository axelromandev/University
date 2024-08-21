/* The following code was generated by JFlex 1.4.3 on 6/28/22, 12:12 PM */

/*
 *        ARCHIVO DONDE SE ESCRIBEN TODAS LAS REGLAS LEXICAS
 */

/* Ubicacion del paquete donde se creara el archivo .flex  */
package code; 

/*  Nombre del metodo que se usara para importarlo*/
import static code.Tokens.*; 

/*  Separador del archivo   */

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 6/28/22, 12:12 PM from the specification file
 * <tt>/Users/axelroman20/Library/CloudStorage/OneDrive-Personal/Escuela/Proyectos/» Analizador Lexico/Analizador Lexico (Codigo)/src/code/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\5\1\7\2\0\1\5\22\0\1\5\1\76\1\45\1\60"+
    "\1\71\1\65\1\63\1\46\1\42\1\44\1\50\1\47\1\5\1\43"+
    "\1\3\1\6\12\2\1\64\1\74\1\40\1\75\1\41\1\73\1\70"+
    "\32\1\1\53\1\66\1\54\1\100\1\25\1\62\1\10\1\16\1\22"+
    "\1\27\1\20\1\30\1\34\1\4\1\26\1\1\1\21\1\23\1\12"+
    "\1\24\1\15\1\33\1\1\1\17\1\11\1\14\1\13\1\36\1\35"+
    "\1\32\1\31\1\37\1\51\1\77\1\52\1\67\42\0\1\56\6\0"+
    "\1\57\3\0\1\100\3\0\1\55\3\0\1\61\12\0\1\72\uff40\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\23\2"+
    "\2\7\1\10\1\6\1\11\1\12\1\13\2\6\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\3\41\1\0\1\5\1\42"+
    "\40\2\2\43\13\2\1\0\1\7\1\0\1\44\1\0"+
    "\1\45\2\0\1\46\4\2\1\43\36\2\1\47\17\2"+
    "\1\0\1\50\1\0\1\51\14\2\1\47\27\2\1\0"+
    "\1\3\10\2\1\43\36\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[248];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\101\0\202\0\303\0\101\0\u0104\0\u0145\0\u0186"+
    "\0\u01c7\0\u0208\0\u0249\0\u028a\0\u02cb\0\u030c\0\u034d\0\u038e"+
    "\0\u03cf\0\u0410\0\u0451\0\u0492\0\u04d3\0\u0514\0\u0555\0\u0596"+
    "\0\u05d7\0\u0618\0\u0659\0\u069a\0\u06db\0\u071c\0\101\0\u075d"+
    "\0\u079e\0\u07df\0\u0820\0\101\0\101\0\101\0\101\0\101"+
    "\0\101\0\101\0\101\0\101\0\101\0\u0861\0\101\0\u0820"+
    "\0\101\0\101\0\101\0\101\0\101\0\101\0\101\0\u08a2"+
    "\0\u08a2\0\u08e3\0\101\0\u0924\0\u0965\0\101\0\u09a6\0\u09e7"+
    "\0\u0a28\0\u0a69\0\u0aaa\0\u0aeb\0\u0b2c\0\u0b6d\0\u0bae\0\u0bef"+
    "\0\u0c30\0\u0c71\0\u0cb2\0\u0cf3\0\u0d34\0\u0d75\0\u0db6\0\u0df7"+
    "\0\u0e38\0\u0e79\0\u0eba\0\u0efb\0\u0f3c\0\u0f7d\0\u0fbe\0\u0fff"+
    "\0\u1040\0\u1081\0\u10c2\0\u1103\0\u1144\0\u1185\0\202\0\u11c6"+
    "\0\u1207\0\u1248\0\u1289\0\u12ca\0\u130b\0\u134c\0\u138d\0\u13ce"+
    "\0\u140f\0\u1450\0\u1491\0\u14d2\0\101\0\u1513\0\101\0\u075d"+
    "\0\101\0\u1554\0\u1595\0\u0924\0\u15d6\0\u1617\0\u1658\0\u1699"+
    "\0\u16da\0\u171b\0\u175c\0\u179d\0\u17de\0\u181f\0\u1860\0\u18a1"+
    "\0\u18e2\0\u1923\0\u1964\0\u19a5\0\u19e6\0\u1a27\0\u1a68\0\u1aa9"+
    "\0\u1aea\0\u1b2b\0\u1b6c\0\u1bad\0\u1bee\0\u1c2f\0\u1c70\0\u1cb1"+
    "\0\u1cf2\0\u1d33\0\u1d74\0\u1db5\0\u1df6\0\u1e37\0\u1e78\0\202"+
    "\0\u1eb9\0\u1efa\0\u1f3b\0\u1f7c\0\u1fbd\0\u1ffe\0\u203f\0\u2080"+
    "\0\u20c1\0\u2102\0\u2143\0\u2184\0\u21c5\0\u2206\0\u2247\0\u2288"+
    "\0\101\0\u22c9\0\101\0\u230a\0\u234b\0\u238c\0\u23cd\0\u240e"+
    "\0\u244f\0\u2490\0\u24d1\0\u2512\0\u2553\0\u2594\0\u25d5\0\u2616"+
    "\0\u2657\0\u2698\0\u26d9\0\u271a\0\u275b\0\u279c\0\u27dd\0\u281e"+
    "\0\u285f\0\u28a0\0\u28e1\0\u2922\0\u2963\0\u29a4\0\u29e5\0\u2a26"+
    "\0\u2a67\0\u2aa8\0\u2ae9\0\u2b2a\0\u2b6b\0\u2bac\0\u2bed\0\u2c2e"+
    "\0\101\0\u2c6f\0\u2cb0\0\u2cf1\0\u2d32\0\u2d73\0\u2db4\0\u2df5"+
    "\0\u2e36\0\u2e77\0\u2eb8\0\u2ef9\0\u2f3a\0\u2f7b\0\u2fbc\0\u2ffd"+
    "\0\u303e\0\u307f\0\u30c0\0\u3101\0\u3142\0\u3183\0\u31c4\0\u3205"+
    "\0\u3246\0\u3287\0\u32c8\0\u3309\0\u334a\0\u338b\0\u33cc\0\u340d"+
    "\0\u344e\0\u348f\0\u34d0\0\u2e77\0\u3511\0\u3552\0\u3593\0\u35d4";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[248];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\3\1\6\1\7\1\6"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\3\1\21\1\22\1\23\1\3\1\24\1\25"+
    "\1\26\2\3\1\27\1\30\1\31\1\32\1\3\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
    "\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63"+
    "\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73"+
    "\102\0\2\3\1\0\1\3\3\0\30\3\43\0\1\4"+
    "\1\74\102\0\1\6\1\0\1\6\77\0\1\75\66\0"+
    "\1\76\4\0\2\3\1\0\1\3\3\0\1\3\1\77"+
    "\1\3\1\100\24\3\42\0\2\3\1\0\1\101\3\0"+
    "\4\3\1\102\5\3\1\103\3\3\1\104\6\3\1\105"+
    "\2\3\42\0\2\3\1\0\1\3\3\0\1\106\2\3"+
    "\1\107\24\3\42\0\2\3\1\0\1\3\3\0\1\3"+
    "\1\110\12\3\1\111\13\3\42\0\2\3\1\0\1\112"+
    "\3\0\7\3\1\113\1\114\10\3\1\115\6\3\42\0"+
    "\2\3\1\0\1\3\3\0\23\3\1\116\4\3\42\0"+
    "\2\3\1\0\1\3\3\0\5\3\1\117\1\3\1\120"+
    "\20\3\42\0\2\3\1\0\1\3\3\0\10\3\1\121"+
    "\17\3\42\0\2\3\1\0\1\3\3\0\13\3\1\122"+
    "\1\123\5\3\1\124\5\3\42\0\2\3\1\0\1\125"+
    "\3\0\1\126\4\3\1\127\5\3\1\130\2\3\1\131"+
    "\11\3\42\0\2\3\1\0\1\3\3\0\5\3\1\132"+
    "\22\3\42\0\2\3\1\0\1\3\3\0\1\133\7\3"+
    "\1\134\17\3\42\0\2\3\1\0\1\3\3\0\5\3"+
    "\1\135\6\3\1\136\3\3\1\137\7\3\42\0\2\3"+
    "\1\0\1\3\3\0\5\3\1\140\2\3\1\141\10\3"+
    "\1\142\6\3\42\0\2\3\1\0\1\3\3\0\1\143"+
    "\4\3\1\144\1\3\1\145\3\3\1\146\14\3\42\0"+
    "\2\3\1\0\1\3\3\0\3\3\1\147\3\3\1\150"+
    "\20\3\42\0\2\3\1\0\1\3\3\0\5\3\1\100"+
    "\22\3\42\0\2\3\1\0\1\151\3\0\30\3\42\0"+
    "\2\3\1\0\1\3\3\0\5\3\1\152\10\3\1\153"+
    "\11\3\42\0\1\154\2\0\1\154\3\0\30\154\1\155"+
    "\34\0\1\155\44\0\1\155\33\0\1\155\46\0\1\156"+
    "\100\0\1\157\31\0\1\76\3\0\7\160\1\0\35\160"+
    "\1\161\33\160\1\162\1\163\2\162\1\163\2\162\1\0"+
    "\30\163\41\162\47\0\1\157\25\0\1\76\100\0\1\76"+
    "\66\0\1\73\112\0\1\155\102\0\1\73\3\0\1\164"+
    "\76\0\7\75\1\0\71\75\1\0\2\3\1\0\1\3"+
    "\3\0\2\3\1\137\25\3\42\0\2\3\1\0\1\3"+
    "\3\0\4\3\1\165\23\3\42\0\2\3\1\0\1\3"+
    "\3\0\5\3\1\166\22\3\42\0\2\3\1\0\1\3"+
    "\3\0\1\167\6\3\1\170\7\3\1\171\10\3\42\0"+
    "\2\3\1\0\1\3\3\0\1\172\27\3\42\0\2\3"+
    "\1\0\1\3\3\0\24\3\1\173\2\3\1\174\42\0"+
    "\2\3\1\0\1\3\3\0\16\3\1\175\11\3\42\0"+
    "\2\3\1\0\1\3\3\0\16\3\1\131\11\3\42\0"+
    "\2\3\1\0\1\3\3\0\4\3\1\176\23\3\42\0"+
    "\2\3\1\0\1\3\3\0\16\3\1\177\11\3\42\0"+
    "\2\3\1\0\1\3\3\0\1\3\1\200\14\3\1\201"+
    "\11\3\42\0\2\3\1\0\1\3\3\0\7\3\1\202"+
    "\6\3\1\203\11\3\42\0\2\3\1\0\1\3\3\0"+
    "\3\3\1\204\15\3\1\137\6\3\42\0\2\3\1\0"+
    "\1\3\3\0\2\3\1\205\25\3\42\0\2\3\1\0"+
    "\1\3\3\0\23\3\1\206\4\3\42\0\2\3\1\0"+
    "\1\3\3\0\10\3\1\207\17\3\42\0\2\3\1\0"+
    "\1\3\3\0\5\3\1\210\22\3\42\0\2\3\1\0"+
    "\1\3\3\0\10\3\1\211\17\3\42\0\2\3\1\0"+
    "\1\3\3\0\4\3\1\212\11\3\1\213\5\3\1\214"+
    "\3\3\42\0\2\3\1\0\1\3\3\0\1\3\1\204"+
    "\26\3\42\0\2\3\1\0\1\3\3\0\3\3\1\77"+
    "\13\3\1\215\10\3\42\0\2\3\1\0\1\3\3\0"+
    "\4\3\1\216\16\3\1\217\4\3\42\0\2\3\1\0"+
    "\1\3\3\0\1\220\27\3\42\0\2\3\1\0\1\3"+
    "\3\0\1\3\1\204\2\3\1\221\23\3\42\0\2\3"+
    "\1\0\1\3\3\0\3\3\1\222\10\3\1\223\13\3"+
    "\42\0\2\3\1\0\1\3\3\0\1\224\27\3\42\0"+
    "\2\3\1\0\1\3\3\0\14\3\1\137\13\3\42\0"+
    "\2\3\1\0\1\3\3\0\14\3\1\225\13\3\42\0"+
    "\2\3\1\0\1\3\3\0\2\3\1\226\25\3\42\0"+
    "\2\3\1\0\1\3\3\0\25\3\1\137\2\3\42\0"+
    "\2\3\1\0\1\3\3\0\1\3\1\227\26\3\42\0"+
    "\2\3\1\0\1\3\3\0\4\3\1\230\5\3\1\231"+
    "\1\232\14\3\42\0\2\3\1\0\1\3\3\0\3\3"+
    "\1\233\24\3\42\0\2\3\1\0\1\3\3\0\13\3"+
    "\1\234\4\3\1\235\7\3\42\0\2\3\1\0\1\3"+
    "\3\0\14\3\1\236\13\3\42\0\2\3\1\0\1\3"+
    "\3\0\13\3\1\122\14\3\42\0\2\3\1\0\1\3"+
    "\3\0\7\3\1\137\20\3\42\0\2\3\1\0\1\3"+
    "\3\0\16\3\1\237\11\3\42\0\2\3\1\0\1\3"+
    "\3\0\5\3\1\240\22\3\42\0\2\3\1\0\1\3"+
    "\3\0\6\3\1\241\21\3\42\0\2\3\1\0\1\3"+
    "\3\0\5\3\1\242\10\3\1\243\11\3\42\0\2\3"+
    "\1\0\1\3\3\0\16\3\1\244\11\3\42\0\2\3"+
    "\1\0\1\3\3\0\13\3\1\245\2\3\1\246\11\3"+
    "\42\0\2\3\1\0\1\3\3\0\7\3\1\247\20\3"+
    "\42\0\1\154\1\0\1\250\1\154\3\0\30\154\1\0"+
    "\1\251\41\0\1\252\144\0\1\253\33\0\1\163\2\0"+
    "\1\163\3\0\30\163\6\0\1\253\33\0\2\3\1\0"+
    "\1\3\3\0\5\3\1\137\22\3\42\0\2\3\1\0"+
    "\1\3\3\0\7\3\1\254\20\3\42\0\2\3\1\0"+
    "\1\3\3\0\4\3\1\255\23\3\42\0\2\3\1\0"+
    "\1\3\3\0\3\3\1\256\24\3\42\0\2\3\1\0"+
    "\1\3\3\0\16\3\1\165\11\3\42\0\2\3\1\0"+
    "\1\3\3\0\14\3\1\257\13\3\42\0\2\3\1\0"+
    "\1\3\3\0\14\3\1\260\13\3\42\0\2\3\1\0"+
    "\1\3\3\0\10\3\1\261\17\3\42\0\2\3\1\0"+
    "\1\3\3\0\4\3\1\221\23\3\42\0\2\3\1\0"+
    "\1\3\3\0\1\262\27\3\42\0\2\3\1\0\1\3"+
    "\3\0\14\3\1\263\13\3\42\0\2\3\1\0\1\3"+
    "\3\0\16\3\1\264\11\3\42\0\2\3\1\0\1\3"+
    "\3\0\5\3\1\131\22\3\42\0\2\3\1\0\1\3"+
    "\3\0\5\3\1\134\22\3\42\0\2\3\1\0\1\3"+
    "\3\0\1\3\1\137\26\3\42\0\2\3\1\0\1\3"+
    "\3\0\10\3\1\137\17\3\42\0\2\3\1\0\1\3"+
    "\3\0\23\3\1\265\4\3\42\0\2\3\1\0\1\3"+
    "\3\0\10\3\1\266\17\3\42\0\2\3\1\0\1\3"+
    "\3\0\7\3\1\267\20\3\42\0\2\3\1\0\1\3"+
    "\3\0\13\3\1\270\14\3\42\0\2\3\1\0\1\3"+
    "\3\0\1\271\27\3\42\0\2\3\1\0\1\3\3\0"+
    "\3\3\1\272\24\3\42\0\2\3\1\0\1\3\3\0"+
    "\14\3\1\273\13\3\42\0\2\3\1\0\1\3\3\0"+
    "\16\3\1\274\11\3\42\0\2\3\1\0\1\3\3\0"+
    "\13\3\1\137\14\3\42\0\2\3\1\0\1\3\3\0"+
    "\10\3\1\272\17\3\42\0\2\3\1\0\1\3\3\0"+
    "\13\3\1\275\14\3\42\0\2\3\1\0\1\3\3\0"+
    "\7\3\1\230\20\3\42\0\2\3\1\0\1\3\3\0"+
    "\12\3\1\276\15\3\42\0\2\3\1\0\1\3\3\0"+
    "\4\3\1\137\23\3\42\0\2\3\1\0\1\3\3\0"+
    "\1\3\1\277\2\3\1\300\23\3\42\0\2\3\1\0"+
    "\1\3\3\0\1\3\1\203\26\3\42\0\2\3\1\0"+
    "\1\3\3\0\24\3\1\230\3\3\42\0\2\3\1\0"+
    "\1\3\3\0\10\3\1\301\17\3\42\0\2\3\1\0"+
    "\1\3\3\0\4\3\1\302\23\3\42\0\2\3\1\0"+
    "\1\3\3\0\13\3\1\303\14\3\42\0\2\3\1\0"+
    "\1\3\3\0\16\3\1\304\11\3\42\0\2\3\1\0"+
    "\1\3\3\0\6\3\1\305\21\3\42\0\2\3\1\0"+
    "\1\3\3\0\10\3\1\306\17\3\42\0\2\3\1\0"+
    "\1\3\3\0\1\307\27\3\42\0\2\3\1\0\1\3"+
    "\3\0\1\310\27\3\42\0\2\3\1\0\1\3\3\0"+
    "\10\3\1\311\17\3\42\0\2\3\1\0\1\3\3\0"+
    "\1\254\27\3\42\0\2\3\1\0\1\3\3\0\13\3"+
    "\1\312\14\3\42\0\2\3\1\0\1\3\3\0\4\3"+
    "\1\313\23\3\42\0\2\3\1\0\1\3\3\0\14\3"+
    "\1\314\11\3\1\315\1\3\42\0\2\3\1\0\1\3"+
    "\3\0\13\3\1\204\14\3\42\0\2\3\1\0\1\3"+
    "\3\0\1\316\27\3\42\0\2\3\1\0\1\3\3\0"+
    "\17\3\1\137\10\3\42\0\2\3\1\0\1\3\3\0"+
    "\4\3\1\317\23\3\45\0\1\320\76\0\1\252\41\0"+
    "\1\321\35\0\2\3\1\0\1\3\3\0\4\3\1\230"+
    "\23\3\42\0\2\3\1\0\1\3\3\0\16\3\1\322"+
    "\11\3\42\0\2\3\1\0\1\3\3\0\12\3\1\222"+
    "\15\3\42\0\2\3\1\0\1\3\3\0\20\3\1\137"+
    "\7\3\42\0\2\3\1\0\1\3\3\0\10\3\1\246"+
    "\17\3\42\0\2\3\1\0\1\3\3\0\5\3\1\257"+
    "\22\3\42\0\2\3\1\0\1\3\3\0\6\3\1\244"+
    "\21\3\42\0\2\3\1\0\1\3\3\0\24\3\1\137"+
    "\3\3\42\0\2\3\1\0\1\3\3\0\24\3\1\173"+
    "\3\3\42\0\2\3\1\0\1\3\3\0\13\3\1\315"+
    "\14\3\42\0\2\3\1\0\1\3\3\0\14\3\1\323"+
    "\1\3\1\246\1\324\10\3\42\0\2\3\1\0\1\3"+
    "\3\0\1\325\27\3\42\0\2\3\1\0\1\3\3\0"+
    "\10\3\1\326\17\3\42\0\2\3\1\0\1\3\3\0"+
    "\11\3\1\137\16\3\42\0\2\3\1\0\1\3\3\0"+
    "\7\3\1\131\20\3\42\0\2\3\1\0\1\3\3\0"+
    "\4\3\1\327\23\3\42\0\2\3\1\0\1\3\3\0"+
    "\1\3\1\330\26\3\42\0\2\3\1\0\1\3\3\0"+
    "\16\3\1\331\11\3\42\0\2\3\1\0\1\137\3\0"+
    "\30\3\42\0\2\3\1\0\1\3\3\0\4\3\1\332"+
    "\23\3\42\0\2\3\1\0\1\3\3\0\16\3\1\333"+
    "\11\3\42\0\2\3\1\0\1\3\3\0\1\3\1\334"+
    "\26\3\42\0\2\3\1\0\1\3\3\0\7\3\1\335"+
    "\20\3\42\0\2\3\1\0\1\3\3\0\3\3\1\336"+
    "\24\3\42\0\2\3\1\0\1\3\3\0\14\3\1\204"+
    "\13\3\42\0\2\3\1\0\1\3\3\0\13\3\1\337"+
    "\14\3\42\0\2\3\1\0\1\3\3\0\4\3\1\204"+
    "\23\3\42\0\2\3\1\0\1\3\3\0\3\3\1\340"+
    "\24\3\42\0\2\3\1\0\1\3\3\0\2\3\1\341"+
    "\25\3\42\0\2\3\1\0\1\3\3\0\14\3\1\246"+
    "\13\3\42\0\2\3\1\0\1\3\3\0\16\3\1\342"+
    "\11\3\42\0\2\3\1\0\1\3\3\0\10\3\1\343"+
    "\17\3\42\0\2\3\1\0\1\3\3\0\4\3\1\257"+
    "\23\3\42\0\2\3\1\0\1\3\3\0\1\306\27\3"+
    "\42\0\2\3\1\0\1\3\3\0\4\3\1\151\23\3"+
    "\42\0\2\3\1\0\1\3\3\0\3\3\1\344\24\3"+
    "\102\0\1\251\40\0\2\3\1\0\1\3\3\0\12\3"+
    "\1\332\15\3\42\0\2\3\1\0\1\3\3\0\1\345"+
    "\27\3\42\0\2\3\1\0\1\3\3\0\10\3\1\257"+
    "\17\3\42\0\2\3\1\0\1\3\3\0\4\3\1\346"+
    "\23\3\42\0\2\3\1\0\1\3\3\0\1\347\27\3"+
    "\42\0\2\3\1\0\1\3\3\0\10\3\1\350\17\3"+
    "\42\0\2\3\1\0\1\3\3\0\4\3\1\351\23\3"+
    "\42\0\2\3\1\0\1\3\3\0\12\3\1\352\15\3"+
    "\42\0\2\3\1\0\1\3\3\0\15\3\1\353\12\3"+
    "\42\0\2\3\1\0\1\3\3\0\14\3\1\354\13\3"+
    "\42\0\2\3\1\0\1\3\3\0\23\3\1\355\4\3"+
    "\42\0\2\3\1\0\1\3\3\0\10\3\1\356\17\3"+
    "\42\0\2\3\1\0\1\3\3\0\17\3\1\204\10\3"+
    "\42\0\2\3\1\0\1\3\3\0\10\3\1\230\17\3"+
    "\42\0\2\3\1\0\1\3\3\0\13\3\1\222\14\3"+
    "\42\0\2\3\1\0\1\3\3\0\16\3\1\357\11\3"+
    "\42\0\2\3\1\0\1\3\3\0\12\3\1\137\15\3"+
    "\42\0\2\3\1\0\1\3\3\0\12\3\1\360\15\3"+
    "\42\0\2\3\1\0\1\3\3\0\1\215\27\3\42\0"+
    "\2\3\1\0\1\3\3\0\2\3\1\204\25\3\42\0"+
    "\2\3\1\0\1\3\3\0\5\3\1\144\22\3\42\0"+
    "\2\3\1\0\1\3\3\0\14\3\1\230\13\3\42\0"+
    "\2\3\1\0\1\3\3\0\7\3\1\361\20\3\42\0"+
    "\2\3\1\0\1\3\3\0\10\3\1\144\17\3\42\0"+
    "\2\3\1\0\1\3\3\0\16\3\1\222\11\3\42\0"+
    "\2\3\1\0\1\3\3\0\12\3\1\362\15\3\42\0"+
    "\2\3\1\0\1\3\3\0\3\3\1\204\24\3\42\0"+
    "\2\3\1\0\1\3\3\0\1\363\27\3\42\0\2\3"+
    "\1\0\1\3\3\0\1\77\27\3\42\0\2\3\1\0"+
    "\1\3\3\0\12\3\1\364\15\3\42\0\2\3\1\0"+
    "\1\3\3\0\4\3\1\260\23\3\42\0\2\3\1\0"+
    "\1\3\3\0\23\3\1\365\4\3\42\0\2\3\1\0"+
    "\1\3\3\0\1\366\27\3\42\0\2\3\1\0\1\3"+
    "\3\0\12\3\1\204\15\3\42\0\2\3\1\0\1\3"+
    "\3\0\7\3\1\367\20\3\42\0\2\3\1\0\1\3"+
    "\3\0\1\3\1\222\26\3\42\0\2\3\1\0\1\3"+
    "\3\0\10\3\1\370\17\3\42\0\2\3\1\0\1\3"+
    "\3\0\4\3\1\364\23\3\41\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[13845];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\31\1\1\11\4\1\12\11"+
    "\1\1\1\11\1\1\7\11\3\1\1\11\1\0\1\1"+
    "\1\11\55\1\1\0\1\11\1\0\1\11\1\0\1\11"+
    "\2\0\64\1\1\0\1\11\1\0\1\11\44\1\1\0"+
    "\1\11\47\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[248];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    TableData data = new TableData();


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 160) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 10: 
          { data.linea=yyline; data.lexema=yytext(); return Comilla;
          }
        case 42: break;
        case 8: 
          { data.linea=yyline; data.lexema=yytext(); return Parentesis_a;
          }
        case 43: break;
        case 15: 
          { data.linea=yyline; data.lexema=yytext(); return Corchetes_c;
          }
        case 44: break;
        case 23: 
          { data.linea=yyline; data.lexema=yytext(); return DosPuntos;
          }
        case 45: break;
        case 16: 
          { data.linea=yyline; data.lexema=yytext(); return Grado;
          }
        case 46: break;
        case 28: 
          { data.linea=yyline; data.lexema=yytext(); return Dinero;
          }
        case 47: break;
        case 29: 
          { data.linea=yyline; data.lexema=yytext(); return Interrogacion_a;
          }
        case 48: break;
        case 27: 
          { data.linea=yyline; data.lexema=yytext(); return Arroba;
          }
        case 49: break;
        case 21: 
          { data.linea=yyline; data.lexema=yytext(); return AcentoGrave;
          }
        case 50: break;
        case 6: 
          { data.linea=yyline; data.lexema=yytext(); return OpAritmeticos;
          }
        case 51: break;
        case 11: 
          { data.linea=yyline; data.lexema=yytext(); return ComillaSimple;
          }
        case 52: break;
        case 2: 
          { data.linea=yyline; data.lexema=yytext(); return Identificador;
          }
        case 53: break;
        case 18: 
          { data.linea=yyline; data.lexema=yytext(); return dieresis;
          }
        case 54: break;
        case 9: 
          { data.linea=yyline; data.lexema=yytext(); return Parentesis_c;
          }
        case 55: break;
        case 19: 
          { data.linea=yyline; data.lexema=yytext(); return Hastag;
          }
        case 56: break;
        case 7: 
          { data.linea=yyline; data.lexema=yytext(); return OpRelacional;
          }
        case 57: break;
        case 4: 
          { data.linea=yyline; data.lexema=yytext(); return Punto;
          }
        case 58: break;
        case 34: 
          { data.linea=yyline; data.lexema=yytext(); return OpAtribucion;
          }
        case 59: break;
        case 3: 
          { data.linea=yyline; data.lexema=yytext(); return N_Entero;
          }
        case 60: break;
        case 31: 
          { data.linea=yyline; data.lexema=yytext(); return OpFin;
          }
        case 61: break;
        case 36: 
          { data.linea=yyline; data.lexema=yytext(); return OpIncremento;
          }
        case 62: break;
        case 24: 
          { data.linea=yyline; data.lexema=yytext(); return Porcentaje;
          }
        case 63: break;
        case 30: 
          { data.linea=yyline; data.lexema=yytext(); return Interrogacion_c;
          }
        case 64: break;
        case 40: 
          { data.linea=yyline; data.lexema=yytext(); return Libreria;
          }
        case 65: break;
        case 1: 
          { data.linea=yyline; data.lexema=yytext(); return ERROR;
          }
        case 66: break;
        case 25: 
          { data.linea=yyline; data.lexema=yytext(); return BarraInvertida;
          }
        case 67: break;
        case 12: 
          { data.linea=yyline; data.lexema=yytext(); return Llave_a;
          }
        case 68: break;
        case 41: 
          { data.linea=yyline; data.lexema=yytext(); return Caracter;
          }
        case 69: break;
        case 39: 
          { data.linea=yyline; data.lexema=yytext(); return T_Dato;
          }
        case 70: break;
        case 33: 
          { data.linea=yyline; data.lexema=yytext(); return OpLogico;
          }
        case 71: break;
        case 14: 
          { data.linea=yyline; data.lexema=yytext(); return Corchetes_a;
          }
        case 72: break;
        case 17: 
          { data.linea=yyline; data.lexema=yytext(); return Admiracion;
          }
        case 73: break;
        case 26: 
          { data.linea=yyline; data.lexema=yytext(); return Virgulilla;
          }
        case 74: break;
        case 37: 
          { data.linea=yyline; data.lexema=yytext(); return Cadena;
          }
        case 75: break;
        case 38: 
          { data.linea=yyline; data.lexema=yytext(); return N_Decimal;
          }
        case 76: break;
        case 5: 
          { /*Ignore*/
          }
        case 77: break;
        case 22: 
          { data.linea=yyline; data.lexema=yytext(); return And;
          }
        case 78: break;
        case 35: 
          { data.linea=yyline; data.lexema=yytext(); return Reservadas;
          }
        case 79: break;
        case 13: 
          { data.linea=yyline; data.lexema=yytext(); return Llave_c;
          }
        case 80: break;
        case 32: 
          { data.linea=yyline; data.lexema=yytext(); return OpAsignacion;
          }
        case 81: break;
        case 20: 
          { data.linea=yyline; data.lexema=yytext(); return Acento;
          }
        case 82: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}