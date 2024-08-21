/*  
        ARCHIVO PRINCIPAL
*/

/*  Paquete  */    
package code;

/*  Librerias  */
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/*  Clase y Extenciones  */
public class Menu extends javax.swing.JFrame{
    
    /*  Constructor  */
    public Menu() {
        /*  Valores iniciales de los objetos  */
        initComponents();
        /*  No rescalable  */
        setResizable(false);
        /*  Ubicacion central  */
        setLocationRelativeTo(null);
        /*  Asigna el nuevo diseño al jScrollPanel del TextArea  */
        LineNumber desing = new LineNumber(txtCode);
        ScrollPanel_txtCode.setRowHeaderView(desing);
        /*  Analiza y Crea el archivo lexer  */
        GenerateLexer();
    }
    
    /*  Valores Iniciales de los Objetos  */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCargar = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        labelTokens = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtState = new javax.swing.JLabel();
        ScrollPanel_tableInfo = new javax.swing.JScrollPane();
        tableInfo = new javax.swing.JTable();
        ScrollPanel_txtCode = new javax.swing.JScrollPane();
        txtCode = new javax.swing.JTextArea();
        labelErrores = new javax.swing.JLabel();
        txtErrores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));

        btnCargar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnAnalizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        labelTokens.setToolTipText("");
        labelTokens.setEnabled(false);

        jLabel3.setText("ANALIZADO: ");
        jLabel3.setToolTipText("");

        txtState.setText("No");
        txtState.setToolTipText("");

        tableInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ScrollPanel_tableInfo.setViewportView(tableInfo);

        txtCode.setColumns(20);
        txtCode.setRows(5);
        ScrollPanel_txtCode.setViewportView(txtCode);

        labelErrores.setText("Errores:");
        labelErrores.setToolTipText("");

        txtErrores.setText("No");
        txtErrores.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(labelTokens))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAnalizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCargar)
                                .addGap(117, 117, 117)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(ScrollPanel_txtCode)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ScrollPanel_tableInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelErrores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizar)
                    .addComponent(btnLimpiar)
                    .addComponent(jLabel3)
                    .addComponent(txtState)
                    .addComponent(btnCargar)
                    .addComponent(labelErrores)
                    .addComponent(txtErrores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPanel_tableInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ScrollPanel_txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelTokens))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*  Metodos del boton Analizar  */
    // <editor-fold defaultstate="collapsed" desc="Boton Analizar">  
    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        String text = txtCode.getText();
        if(!text.equals("")){
            int numTokens = 0;
            txtState.setText("Si");
            btnAnalizar.setEnabled(false);
            labelTokens.setEnabled(true);
            txtCode.setEditable(false);
            this.setSize(1000, 500);
            String url = "file.txt";
            File file = new File(url);
            PrintWriter writer;
            try {
                writer = new PrintWriter(file);
                writer.print(txtCode.getText());
                writer.close();
            } catch (FileNotFoundException e) { System.err.println(e); }
            try {
                Reader reader = new BufferedReader(new FileReader(url));
                Lexer lexer = new Lexer(reader);
                String token = "";
                int error=0;
                DefaultTableModel model;
                String com[] = {"LINE","TOKEN", "LEXEMA"};
                String row[] = new String[3];
                model = new DefaultTableModel(null, com);   
                while (true) {
                    TableData.token = lexer.yylex();
                    if(TableData.token != null){
                        row[0] =  Integer.toString(1+TableData.linea);
                        switch (TableData.token) {
                            case ERROR:
                                row[1] = "NO DEFINIDO"; 
                                error++;
                                break;
                            default:
                                row[1] = "" + TableData.token;
                                break;
                        }
                        row[2] = TableData.lexema;
                        model.addRow(row);
                    } else {
                        break;
                    }
                txtErrores.setText(Integer.toString(error));
                tableInfo.setModel(model);
                tableInfo.getColumnModel().getColumn(0).setCellRenderer(new TableRender());
                tableInfo.getColumnModel().getColumn(1).setCellRenderer(new TableRender());
                tableInfo.getColumnModel().getColumn(2).setCellRenderer(new TableRender());
                }
            } catch (Exception e) { System.err.println(e); }
        }
        
    }//GEN-LAST:event_btnAnalizarActionPerformed
    // </editor-fold>
    
    /*  Meotdos del boton limpiar  */
    // <editor-fold defaultstate="collapsed" desc="Boton Limpiar">  
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtCode.setText("");
        txtState.setText("No");
        btnAnalizar.setEnabled(true);
        btnCargar.setEnabled(true);
        labelTokens.setEnabled(false);
        txtCode.setEditable(true);
        this.setSize(500, 500);
    }//GEN-LAST:event_btnLimpiarActionPerformed
    // </editor-fold>
    
    /*  Metodos del boton cargar  */
    // <editor-fold defaultstate="collapsed" desc="Boton Cargar">  
    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String text="";
            String code="";
            while ((code=br.readLine())!=null) {                
                text+=code+"\n";
            }
            txtCode.setText(text);
        } catch (Exception e) { }
        btnCargar.setEnabled(false);
        btnAnalizar.setEnabled(true);
    }//GEN-LAST:event_btnCargarActionPerformed
    // </editor-fold>
    
    /*  Metodo para generar el archivo lexer  */
    // <editor-fold defaultstate="collapsed" desc="Generate Lexer">  
    public static void GenerateLexer(){
        File file = new File("src/code/Lexer.flex").getAbsoluteFile();
        JFlex.Main.generate(file);
    }// </editor-fold>  

    /*  Metodo Principal  */
    // <editor-fold defaultstate="collapsed" desc="Principal Main">  

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }// </editor-fold> 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPanel_tableInfo;
    private javax.swing.JScrollPane ScrollPanel_txtCode;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelErrores;
    private javax.swing.JLabel labelTokens;
    private static javax.swing.JTable tableInfo;
    private javax.swing.JTextArea txtCode;
    private javax.swing.JLabel txtErrores;
    private javax.swing.JLabel txtState;
    // End of variables declaration//GEN-END:variables

}
