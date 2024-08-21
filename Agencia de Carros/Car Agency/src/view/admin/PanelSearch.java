/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.admin;

import code.MethodsSQL;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Restf
 */
public class PanelSearch extends javax.swing.JPanel {

    MethodsSQL methodsSql = new MethodsSQL();
    ImageIcon green = new ImageIcon(getClass().getResource("/resource/Check-True.png"));
    ImageIcon red = new ImageIcon(getClass().getResource("/resource/Check-False.png"));
    private boolean check1, check2;
    
    public PanelSearch() {
        initComponents();
        TableData.setModel(methodsSql.loadTableUser());
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableData = new javax.swing.JTable();
        txtSearchUsers = new javax.swing.JTextField();
        RFCExistsSearch = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(128, 153, 155));
        jPanel1.setPreferredSize(new java.awt.Dimension(982, 641));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(128, 153, 155));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "» Ingrese RFC de usuario para actualizar datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        TableData.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        TableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ESTADO", "NOMBRE", "CORREO", "RFC", "USUARIO", "CONTRASEÑA", "NACIMIENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableData);

        txtSearchUsers.setBackground(new java.awt.Color(255, 255, 255));
        txtSearchUsers.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtSearchUsers.setForeground(new java.awt.Color(0, 0, 0));
        txtSearchUsers.setPreferredSize(new java.awt.Dimension(220, 40));
        txtSearchUsers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchUsersKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchUsersKeyTyped(evt);
            }
        });

        RFCExistsSearch.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        RFCExistsSearch.setForeground(new java.awt.Color(255, 255, 255));
        RFCExistsSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Check-False.png"))); // NOI18N
        RFCExistsSearch.setText(" » RFC no encontrado");
        RFCExistsSearch.setFocusable(false);

        jButton2.setText("Generar PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSearchUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RFCExistsSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(27, 27, 27))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RFCExistsSearch)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(15, 50, 955, 580);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CONSULTA DE USUARIOS");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(251, 0, 475, 59);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchUsersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchUsersKeyReleased
        validateRFCsearch();
        MayusculasRFC(txtSearchUsers);
        TableData.setModel(methodsSql.loadTableUserFilter(txtSearchUsers.getText()));
        if(txtSearchUsers.getText().equals("")){
            clear();
        }
    }//GEN-LAST:event_txtSearchUsersKeyReleased

    private void txtSearchUsersKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchUsersKeyTyped
        int characterLimit=13;
            if(txtSearchUsers.getText().length()>=characterLimit){
                evt.consume();
            }    
    }//GEN-LAST:event_txtSearchUsersKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String url = null;
        JFileChooser dgl= new JFileChooser();
        int o=dgl.showSaveDialog(this);
        if(o== JFileChooser.APPROVE_OPTION){
            File f= dgl.getSelectedFile();
            url =f.toString();
        }
        methodsSql.pdfCreateTableUsers(url);
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void MayusculasRFC(javax.swing.JTextField jTextfieldS){
         String cadena = (txtSearchUsers.getText()).toUpperCase();
         txtSearchUsers.setText(cadena);
    }
    
    public void validateRFCsearch(){
        if(methodsSql.ValidateRFCicon(txtSearchUsers.getText())){
            RFCExistsSearch.setText(" » RFC encontrado");
            RFCExistsSearch.setIcon(green);
        } else {
            RFCExistsSearch.setText(" » RFC no encontrado");
            RFCExistsSearch.setIcon(red);
        }
    }
    
    public void clear(){
            RFCExistsSearch.setIcon(red);
            RFCExistsSearch.setText(" » RFC no encontrado");
            txtSearchUsers.setText(null);
            TableData.setModel(methodsSql.loadTableUser());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RFCExistsSearch;
    private javax.swing.JTable TableData;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearchUsers;
    // End of variables declaration//GEN-END:variables
}
