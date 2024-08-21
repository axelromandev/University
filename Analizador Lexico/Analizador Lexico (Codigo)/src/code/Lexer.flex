/*
 *        ARCHIVO DONDE SE ESCRIBEN TODAS LAS REGLAS LEXICAS
 */

/* Ubicacion del paquete donde se creara el archivo .flex  */
package code; 

/*  Nombre del metodo que se usara para importarlo*/
import static code.Tokens.*; 

/*  Separador del archivo   */
%% 

/*  Nombre del archivo .flex  */
%class Lexer 

/*  Asignamos el tipo de valor que manejara el archivo  */
%type Tokens 

/*  Linea del lexema que se este analizando  */
%line 

/*  Se define una variable para el argumento de detectar letras  */ 
L=[a-zA-Z_]+

/*  Se define una variable para el argumento de detectar numeros */
D=[0-9]+

/*  Se define una variable para el argumento de detectar librerias con .h  */
lib = {L}(".h")

/*  Se define una variable para el argumento de detectar algun salto de linea, tabulacion, etc  */
espacio=[ ,\t,\r,\n]+

/*  Se define una variable que almacenara todos los datos del lexema y tokens junto a un archivo que 
    guardara todas las ubicaciones de en que linea se encuentran los lexemas  */
%{
    TableData data = new TableData();
%}

/*  Separador del archivo */
%%

/*  Regla que ignora algunos caracteres y la variable ya definida  */
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}

/*  Regla que detecta todas las palabras reservadas de la lista  */
asm          | auto             | break      | case         | catch            | class    |
const        | const_cast       | continue   | default      | delete           | do       | 
dynamic_cast | else             | enum       | explicit     | extern           | false    | 
for          | friend           | goto       | if           | inline           | mutable  | 
namespace    | new              | operator   | private      | protected        | public   | 
register     | reinterpret_cast | return     | signed       | sizeof           | static   |
static_cast  | struct           | switch     | template     | this             | throw    |
true         | try              | typedef    | typeid       | typename         | union    |
unsigned     | using            | virtual    | void         | volatile         | while    | 
printf       | scanf            | include    | iostream     | stdio            | endl     | 
cout         | cin              | main       | std 
{data.linea=yyline; data.lexema=yytext(); return Reservadas;} 

/*  Regla para detectar los tipos de datos  */
bool | boolean | char | double | float | int | long | short
{data.linea=yyline; data.lexema=yytext(); return T_Dato;} 

/*  Regla para detectar las librerias del codigo  */
("<"){lib}(">") | ("<"){L}(">") {data.linea=yyline; data.lexema=yytext(); return Libreria;}

/*  Regla para detectar los identificadores  */
{L}({L}|{D})* {data.linea=yyline; data.lexema=yytext(); return Identificador;}

/*  Regla para detectar numeros enteros  */
("(-"{D}+")")|{D}+ {data.linea=yyline; data.lexema=yytext(); return N_Entero;}

/*  Regla para detectar numeros decimales  */
{D}("."){D} {data.linea=yyline; data.lexema=yytext(); return N_Decimal;}

/*  Regla para detectar cadenas de texto  */
("\"")([^\n\"]*([.])*)*("\"") {data.linea=yyline; data.lexema=yytext(); return Cadena;}

/*  Regla para detectar caracteres  */
("'"){L}("'") | ("'").("'")  {data.linea=yyline; data.lexema=yytext(); return Caracter;}

/*  Regla para detectar operadores aritmeticos  */
"+"  | "-"  | "*"  | "/" {data.linea=yyline; data.lexema=yytext(); return OpAritmeticos;}

/*  Regla para detectar delimitadores de codigo  */
"(" {data.linea=yyline; data.lexema=yytext(); return Parentesis_a;} 
")" {data.linea=yyline; data.lexema=yytext(); return Parentesis_c;} 
"{" {data.linea=yyline; data.lexema=yytext(); return Llave_a;} 
"}" {data.linea=yyline; data.lexema=yytext(); return Llave_c;} 
"[" {data.linea=yyline; data.lexema=yytext(); return Corchetes_a;} 
"]" {data.linea=yyline; data.lexema=yytext(); return Corchetes_c;}

/*  Regla para detectar ciertos caracteres especiales  */
"\n" {data.linea=yyline; data.lexema=yytext(); return Linea;} 
"°"  {data.linea=yyline; data.lexema=yytext(); return Grado;} 
"¡"  {data.linea=yyline; data.lexema=yytext(); return Admiracion;} 
"¨"  {data.linea=yyline; data.lexema=yytext(); return dieresis;} 
"#"  {data.linea=yyline; data.lexema=yytext(); return Hastag;} 
"´"  {data.linea=yyline; data.lexema=yytext(); return Acento;} 
"`"  {data.linea=yyline; data.lexema=yytext(); return AcentoGrave;}
"&"  {data.linea=yyline; data.lexema=yytext(); return And;}
"."  {data.linea=yyline; data.lexema=yytext(); return Punto;}
":"  {data.linea=yyline; data.lexema=yytext(); return DosPuntos;}
"%"  {data.linea=yyline; data.lexema=yytext(); return Porcentaje;}
"\\" {data.linea=yyline; data.lexema=yytext(); return BarraInvertida;}
"~"  {data.linea=yyline; data.lexema=yytext(); return Virgulilla;}
"@"  {data.linea=yyline; data.lexema=yytext(); return Arroba;}
"$"  {data.linea=yyline; data.lexema=yytext(); return Dinero;}
"¿"  {data.linea=yyline; data.lexema=yytext(); return Interrogacion_a;} 
"?"  {data.linea=yyline; data.lexema=yytext(); return Interrogacion_c;}
"'"  {data.linea=yyline; data.lexema=yytext(); return ComillaSimple;}
";"  {data.linea=yyline; data.lexema=yytext(); return OpFin;} 
"="  {data.linea=yyline; data.lexema=yytext(); return OpAsignacion;}
("\"") {data.linea=yyline; data.lexema=yytext(); return Comilla;}

/*  Regla para detectar operadores relacionales  */
">"  | "<"  | "==" | "!=" | ">=" | "<=" | "<<" | ">>" {data.linea=yyline; data.lexema=yytext(); return OpRelacional;}

/*  Regla para detectar operadores logicos  */
"&&" | "||" | "!"  | "&"  | "|" | "^" | "¬" {data.linea=yyline; data.lexema=yytext(); return OpLogico;}

/*  Regla para detectar operadores de atribucion   */
"+=" | "-=" | "*=" | "/=" | "%=" {data.linea=yyline; data.lexema=yytext(); return OpAtribucion;}

/*  Regla para detectar operadores de incremento y decremento   */
"++" | "--" {data.linea=yyline; data.lexema=yytext(); return OpIncremento;}

/*  Regla para detectar cualquier otro caracter fuera de las reglas no definido  */
. {data.linea=yyline; data.lexema=yytext(); return ERROR;}
