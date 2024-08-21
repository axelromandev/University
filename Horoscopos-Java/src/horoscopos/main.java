/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horoscopos;

import java.util.Calendar;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Restf
 */
public class main extends javax.swing.JFrame {

    ImageIcon ACUARIO = new ImageIcon(getClass().getResource("/img/Acuario.png"));
    ImageIcon CAPRICORNIO = new ImageIcon(getClass().getResource("/img/Capricornio.png"));
    ImageIcon CANCER = new ImageIcon(getClass().getResource("/img/Cancer.png"));
    ImageIcon ESCORPION = new ImageIcon(getClass().getResource("/img/Escorpion.png"));
    ImageIcon GEMINIS = new ImageIcon(getClass().getResource("/img/Geminis.png"));
    ImageIcon LEO = new ImageIcon(getClass().getResource("/img/Leo.png"));
    ImageIcon LIBRA = new ImageIcon(getClass().getResource("/img/Libra.png"));
    ImageIcon PISCIS = new ImageIcon(getClass().getResource("/img/Piscis.png"));
    ImageIcon SAGITARIO = new ImageIcon(getClass().getResource("/img/Sagitario.png"));
    ImageIcon TAURO = new ImageIcon(getClass().getResource("/img/Tauro.png"));
    ImageIcon VIRGO = new ImageIcon(getClass().getResource("/img/Virgo.png"));
    ImageIcon ARIES = new ImageIcon(getClass().getResource("/img/Aries.png"));
          
    public main() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        txtlabel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        txtlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("HOROSCOPOS");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Selecciona tu fecha de nacimiento");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtlabel.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnAceptar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtlabel)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtlabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    java.sql.Date fecha;
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Date date = txtDate.getDate();
        txtlabel.setText(""+date);
        if(date != null){
            /* Dia y Mes */
            long d = date.getTime();
            fecha = new java.sql.Date(d);
            String fecha2 = fecha.toString();
            int date1 = fecha2.length();
            int date2 = date1 - 3;
            String dia = fecha2.substring(date2+1,date2+3);
            String mes = fecha2.substring(date2-2,date2);
            int dia2 = Integer.parseInt(dia);
            int mes2 = Integer.parseInt(mes);
            /* Dia Texto */
            String diatxt = null;
            System.out.println(txtlabel.getText());
            String txt = txtlabel.getText();
            int txt1 = txt.length();
            int txt2 = txt1-3;
            String txtdia = txt.substring(0,txt1-txt2);
            switch(txtdia){
                case "Mon":
                    diatxt = "LUNES";
                    break;
                case "Tue":
                    diatxt = "MARTES";
                    break;
                case "Wed":
                    diatxt = "MIERCOLES";
                    break;
                case "Thu":
                    diatxt = "JUEVES";
                    break;
                case "Fri":
                    diatxt = "VIERNES";
                    break;
                case "Sat":
                    diatxt = "SABADO";
                    break;
                case "Sun":
                    diatxt = "DOMINGO";
                    break;
                    
            }
            /* Hora*/
            Calendar calendario = Calendar.getInstance();
            int h = calendario.get(Calendar.HOUR_OF_DAY);
            int m = calendario.get(Calendar.MINUTE);
            int s = calendario.get(Calendar.SECOND);
            String hora = h+":"+m+":"+s;
            /* Datos */
            signo(dia2, mes2, diatxt, hora);
        }
            
    }//GEN-LAST:event_btnAceptarActionPerformed
    
    public void signo(int dia, int mes, String txtDia, String hora) {
        String signo = null;
        String estacion = null;
        switch (mes) {
            case 1:
                if (dia > 21) {
                    signo = "ACUARIO";
                    estacion = "INVIERNO";
                } else {
                    signo = "CAPRICORNIO";
                    estacion = "INVIERNO";
                }
                break;
            case 2:
                    if (dia > 19) {
                        signo = "PISCIS";
                        estacion = "INVIERNO";
                    } else {
                        signo = "ACUARIO";
                        estacion = "INVIERNO";
                    }
                    break;
            case 3:
                    if (dia > 20) {
                        signo = "ARIES";
                        estacion = "PRIMAVERA";
                    } else {
                        signo = "PISCIS";
                        estacion = "INVIERNO";
                    }
                    break;
            case 4:
                    if (dia > 20) {
                        signo = "TAURO";
                        estacion = "PRIMAVERA";
                    } else {
                        signo = "ARIES";
                        estacion = "PRIMAVERA";
                    }
                    break;
            case 5:
                    if (dia > 21) {
                        signo = "GEMINIS";
                        estacion = "PRIMAVERA";
                    } else {
                        signo = "TAURO";
                        estacion = "PRIMAVERA";
                    }
                    break;
            case 6:
                    if (dia > 20) {
                        signo = "CANCER";
                        estacion = "VERANO";
                    } else {
                        signo = "GEMINIS";
                        estacion = "PRIMAVERA";
                    }
                    break;
            case 7:
                    if (dia > 22) {
                        signo = "LEO";
                        estacion = "VERANO";
                    } else {
                        signo = "CANCER";
                        estacion = "VERANO";
                    }
                    break;
            case 8:
                    if (dia > 21) {
                        signo = "VIRGO";
                        estacion = "VERANO";
                    } else {
                        signo = "LEO";
                        estacion = "VERANO";
                    }
                    break;
            case 9:
                    if (dia > 22) {
                        signo = "LIBRA";
                        estacion = "OTOÑO";
                    } else {
                        signo = "VIRGO";
                        estacion = "VERANO";
                    }
                    break;
            case 10:
                    if (dia > 22) {
                        signo = "ESCORPION";
                        estacion = "OTOÑO";
                    } else {
                        signo = "LIBRA";
                        estacion = "OTOÑO";
                    }
                    break;
            case 11:
                    if (dia > 21) {
                        signo = "SAGITARIO";
                        estacion = "OTOÑO";
                    } else {
                        signo = "ESCORPION";
                        estacion = "OTOÑO";
                    }
                    break;
            case 12:
                    if (dia > 21) {
                        signo = "CAPRICORNIO";
                        estacion = "INVIERNO";
                    } else {
                        signo = "SAGITARIO";
                        estacion = "OTOÑO";
                    }
            break;
        }
        JOptionPane.showMessageDialog(null,signo+" - "+estacion+" \n "+txtDia+" - "+hora,
                "HOROSCOPOS",JOptionPane.DEFAULT_OPTION, icono(signoImg(signo)));
    }
    
    public Icon icono(String path){
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path))
                .getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
    
    public String signoImg(String signo){
        String img = null;
        switch(signo){
            case "ACUARIO":
                img = "/img/Acuario.png";
                break;
            case "CAPRICORNIO":
                img = "/img/Capricornio.png";
                break;
            case "CANCER":
                img = "/img/Cancer.png";
                break;
            case "ESCORPION":
                img = "/img/Escorpion.png";
                break;
            case "GEMINIS":
                img = "/img/Geminis.png";
                break;
            case "LEO":
                img = "/img/Leo.png";
                break;
            case "LIBRA":
                img = "/img/Libra.png";
                break;
            case "PISCIS":
                img = "/img/Piscis.png";
                break;
            case "SAGITARIO":
                img = "/img/Sagitario.png";
                break;
            case "TAURO":
                img = "/img/Tauro.png";
                break;
            case "VIRGO":
                img = "/img/Virgo.png";
                break;
            case "ARIES":
                img = "/img/Aries.png";
                break;
        }
        return img;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JLabel txtlabel;
    // End of variables declaration//GEN-END:variables
}
