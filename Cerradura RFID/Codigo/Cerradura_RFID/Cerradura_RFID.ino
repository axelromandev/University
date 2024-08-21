#include <SPI.h>            // incluye libreria bus SPI
#include <MFRC522.h>        // incluye libreria especifica para MFRC522
#include <Servo.h>          // incluye libreria para servo motores
#include <LiquidCrystal.h>  // incluye libreria para LCD Display

#define RST_PIN  9      // constante para referenciar pin de reset
#define SS_PIN  10      // constante para referenciar pin de slave select

MFRC522 mfrc522(SS_PIN, RST_PIN);    // crea objeto mfrc522 enviando pines de slave select y reset
LiquidCrystal lcd(2,3,4,5,6,7);     // crea objeto display lcd con los pines de datos
Servo servo;     // crea objeto servo para el control

bool estadoServo;     // crea variable que valida si el servo esta "bloqueado" o "desbloqueado"
byte LecturaUID[4];         // crea array para almacenar el UID leido
byte Usuario1[4]= {0x8B, 0xE0, 0x86, 0x22} ;    // UID de tarjeta leido en programa 1
byte Usuario2[4]= {0x06, 0x76, 0x25, 0xD9} ;    // UID de llavero leido en programa 1

void setup() {
  Serial.println("Listo!");
  Serial.begin(9600);     // inicializa comunicacion por monitor serie a 9600 bps
  SPI.begin();        // inicializa bus SPI
  mfrc522.PCD_Init();     // inicializa modulo lector
  servo.attach(8);    // inicializa el pin del servo
  lcd.begin(16,2);    // inicializa las celdas activas del lcd
  servo.write(180);     // inicializa la posicion del servo 
  estadoServo = false;    // inicializa el estado de servo en "bloqueado"
}

void loop() {
  if(estadoServo){  // si el servo esta desbloqueado
    lcd.setCursor(0,0);     // posiciona el puntero del lcd
    lcd.print("Access unlocked");     // escribe cadena en el lcd
  } else {    // si el servo esta bloqueado
    lcd.setCursor(0,0);     // posiciona el puntero del lcd
    lcd.print("Access locked  ");       // escribe cadena en el lcd
  }
  lcd.setCursor(0,1);
  lcd.print("Scan You Tag!");
  if ( ! mfrc522.PICC_IsNewCardPresent()){   // si no hay una tarjeta presente
    return;           // retorna al loop esperando por una tarjeta
  }
  if ( ! mfrc522.PICC_ReadCardSerial()){     // si no puede obtener datos de la tarjeta
    return;           // retorna al loop esperando por otra tarjeta
  }  
  Serial.print("UID:");       // muestra texto UID:
  for (byte i = 0; i < mfrc522.uid.size; i++) { // bucle recorre de a un byte por vez el UID
    if (mfrc522.uid.uidByte[i] < 0x10){   // si el byte leido es menor a 0x10
      Serial.print(" 0");       // imprime espacio en blanco y numero cero
    } else {           // sino
      Serial.print(" ");        // imprime un espacio en blanco
    }
    Serial.print(mfrc522.uid.uidByte[i], HEX);    // imprime el byte del UID leido en hexadecimal
    LecturaUID[i]=mfrc522.uid.uidByte[i];     // almacena en array el byte del UID leido      
  }
  Serial.print("\t");         // imprime un espacio de tabulacion             
  if(comparaUID(LecturaUID, Usuario1)) {    // llama a funcion comparaUID con Usuario1
    Serial.print("Bienvenido Usuario"); // si retorna verdadero muestra texto bienvenida
    Serial.print("\t");     // imprime un espacio de tabulacion  
    if(estadoServo){       // si el servo esta desbloqueado
      estadoServo = false;  // cambia estado del servo a bloqueado
      servo.write(180);     // asigna nueva posicion al servo
    } else {    // sino
      estadoServo = true;     // cambia estado del servo a desbloqueado
      servo.write(0);     // asigna nueva posicion al servo
    }
  } else {           // si retorna falso
    Serial.println("No te conozco");    // muestra texto equivalente a acceso denegado          
    servo.write(180);     // asigna nueva posicion al servo
    estadoServo = false;    // cambia estado del servo a bloqueado
  }
  mfrc522.PICC_HaltA();     // detiene comunicacion con tarjeta                
}

boolean comparaUID(byte lectura[],byte usuario[]) { // funcion comparaUID
    for (byte i=0; i < mfrc522.uid.size; i++){    // bucle recorre de a un byte por vez el UID
    if(lectura[i] != usuario[i])        // si byte de UID leido es distinto a usuario
      return(false);          // retorna falso
    }
    return(true);           // si los 4 bytes coinciden retorna verdadero
}
