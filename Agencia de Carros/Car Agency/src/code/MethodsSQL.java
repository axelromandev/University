/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Restf
 */
public class MethodsSQL {
    
    private static Connection conn;
    private static ConnectionSQL con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    MyIcon icon = new MyIcon();
    
    public Connection setConnection(){
        conn = main.Main.conn.getConection();
        return conn;
    }
    
//---------------------------------------------------------------------------------------------------------------------------------------------
    public UsersEntity Login(String user, String pass){
        UsersEntity ev = new UsersEntity();
        conn = setConnection();
        String sql = "SELECT * FROM users WHERE user=? and pass=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {           
                ev.setState (rs.getInt(2));
                ev.setName  (rs.getString(3));
                ev.setEmail (rs.getString(4));
                ev.setRfc   (rs.getString(5));
                ev.setUser  (rs.getString(6));
                ev.setPass  (rs.getString(7));
                ev.setAge   (rs.getString(8));
            }
        } catch (SQLException e) {
        }
        return ev;
    }
    
    public UsersEntity RFC(String rfc){
        UsersEntity ev = new UsersEntity();
        conn = setConnection();
        String sql = "SELECT * FROM users WHERE rfc = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, rfc);
            rs = ps.executeQuery();
            while (rs.next()) {                
                ev.setId    (rs.getInt(1));
                ev.setState (rs.getInt(2));
                ev.setName  (rs.getString(3));
                ev.setEmail (rs.getString(4));
                ev.setRfc   (rs.getString(5));
                ev.setUser  (rs.getString(6));
                ev.setPass  (rs.getString(7));
                ev.setAge   (rs.getString(8));
            }
        } catch (SQLException e) {
        }
        return ev;
    }
//---------------------------------------------------------------------------------------------------------------------------------------------
    public boolean Register(int id, int state, String name, String email, String rfc, String user, String pass, String age){
        boolean okey = false;
        try {
            conn = setConnection();
            String SQL = "INSERT INTO users (id, state, name, email, rfc, user, pass, age) VALUES (?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, state);
            ps.setString(3, name);
            ps.setString(4, email);
            ps.setString(5, rfc);
            ps.setString(6, user);
            ps.setString(7, pass);
            ps.setString(8, age);
            int i = ps.executeUpdate();
            if(i>0){
                okey = true;
                MyIcon icon = new MyIcon();
                JOptionPane.showMessageDialog(
                    null, "Datos Guardados.",
                    "", JOptionPane.DEFAULT_OPTION, icon);
            } else {
                okey = false;
                JOptionPane.showMessageDialog(
                    null, "Error al guardar los datos.",
                    "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: "+e);
        } 
        return okey;
    }
    
    public void Purchase(int id, int folio, String name, String model, int serial_number, int price_car, String additional, int price_additional, int price_total, int type_payment){
        try {
            conn = setConnection();
            String SQL = "INSERT INTO sales (id, folio, name, model, serial_number, price_car, additional, price_additional, price_total, type_payment) VALUES (?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(SQL);
            ps.setInt    (1, id);
            ps.setInt    (2, folio);
            ps.setString (3, name);
            ps.setString (4, model);
            ps.setInt    (5, serial_number);
            ps.setInt    (6, price_car);
            ps.setString (7, additional);
            ps.setInt    (8, price_additional);
            ps.setInt    (9, price_total);
            ps.setInt    (10, type_payment);
            int i = ps.executeUpdate();
            if(i>0){
                MyIcon icon = new MyIcon();
                JOptionPane.showMessageDialog(
                    null, "Compra Completada.",
                    "", JOptionPane.DEFAULT_OPTION, icon);
            } else {
                JOptionPane.showMessageDialog(
                    null, "Error al completar la compra.",
                    "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: "+e);
        } 
    }
//---------------------------------------------------------------------------------------------------------------------------------------------
    public DefaultTableModel loadTableUser(){
        DefaultTableModel model;
        String com[] = {"ID", "ESTADO", "NOMBRE", "CORREO", "RFC", "USUARIO", "CONTRASEÑA", "EDAD" };
        String row[] = new String[8];
        model = new DefaultTableModel(null, com);
        try {
            conn = setConnection();
            String SQL = "SELECT * FROM users;";
            ps = conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                row[0] = rs.getString(1);
                String state = "";
                switch(rs.getInt(2)){
                    case 0:
                        state = "USUARIO";
                        break;
                    case 1:
                        state = "ADMINISTRADOR";
                        break;
                }
                row[1] = state;
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                model.addRow(row);
            }
        } catch (Exception e) {
        }
        return model;
    }
    
    public DefaultTableModel loadTableUserFilter(String rfc){
        DefaultTableModel model;
        String com[] = {"ID", "ESTADO", "NOMBRE", "CORREO", "RFC", "USUARIO", "CONTRASEÑA", "EDAD" };
        String row[] = new String[8];
        model = new DefaultTableModel(null, com);
        try {
            conn = setConnection();
            String SQL = "SELECT * FROM users WHERE rfc LIKE " + '"' + rfc + "%" + '"';
            ps = conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                row[0] = rs.getString(1);
                String state = "";
                switch(rs.getInt(2)){
                    case 0:
                        state = "USUARIO";
                        break;
                    case 1:
                        state = "DMINISTRADOR";
                        break;
                }
                row[1] = state;
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                model.addRow(row);
            }
        } catch (Exception e) {
        }
        return model;
    }
    
    public DefaultTableModel loadTableInventory(){
        DefaultTableModel model;
        String com[] = {"ID", "COMPAÑIA", "MODELO", "N° SERIE", "COLOR", "ESTADO", "PRECIO", "PAIS", "HP", "N° REGISTRO", "KILOMETRAJE" };
        String row[] = new String[11];
        model = new DefaultTableModel(null, com);
        try {
            conn = setConnection();
            String SQL = "SELECT * FROM car;";
            ps = conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                String color = "";
                switch(rs.getInt(5)){
                    case 1:
                        color = "1 BLANCO";
                        break;
                    case 2:
                        color = "2 ROJO";
                        break;
                    case 3:
                        color = "3 NARANJA";
                        break;
                    case 4:
                        color = "4 AMARILLO";
                        break;
                    case 5:
                        color = "5 VERDE";
                        break;
                    case 6:
                        color = "6 AZUL";
                        break;
                    case 7:
                        color = "7 GRIS";
                        break;
                }
                String state = "";
                switch(rs.getInt(6)){
                    case 0:
                        state = "0 NUEVO";
                        break;
                    case 1:
                        state = "1 SEMINUEVO";
                        break;
                    case 2:
                        state = "2 USADO";
                        break;
                }
                row[4] = color;
                row[5] = state;
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getString(9);
                row[9] = rs.getString(10);
                row[10] = rs.getString(11);
                model.addRow(row);
            }
        } catch (Exception e) {
        }
        return model;
    }
    
    public DefaultTableModel Lista(){
        DefaultTableModel model;
        String com[] = {"", "", "", "", "", "", "" };
        String row[] = new String[7];
        model = new DefaultTableModel(null, com);
        try {
            conn = setConnection();
            String SQL = "SELECT * FROM tabla;";
            ps = conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                model.addRow(row);
            }
        } catch (Exception e) {
        }
        return model;
    }
    
    public DefaultTableModel loadTableInventoryFilter(int select, String value){
        String txtSql = null;
        switch(select){
            case 1:
                txtSql = "SELECT * FROM car WHERE id LIKE " + '"' + value + "%" + '"';
                break;
            case 2:
                txtSql = "SELECT * FROM car WHERE company LIKE " + '"' + value + "%" + '"';
                break;
            case 3:
                txtSql = "SELECT * FROM car WHERE model LIKE " + '"' + value + "%" + '"';
                break;
            case 4:
                txtSql = "SELECT * FROM car WHERE serial_number LIKE " + '"' + value + "%" + '"';
                break;
            case 5:
                txtSql = "SELECT * FROM car WHERE color LIKE " + '"' + value + "%" + '"';
                break;
            case 6:
                txtSql = "SELECT * FROM car WHERE state LIKE " + '"' + value + "%" + '"';
                break;
            case 7:
                txtSql = "SELECT * FROM car WHERE price LIKE " + '"' + value + "%" + '"';
                break;
            case 8:
                txtSql = "SELECT * FROM car WHERE country LIKE " + '"' + value + "%" + '"';
                break;
            case 9:
                txtSql = "SELECT * FROM car WHERE horsepower LIKE " + '"' + value + "%" + '"';
                break;
            case 10:
                txtSql = "SELECT * FROM car WHERE car_registration LIKE " + '"' + value + "%" + '"';
                break;
            case 11:
                txtSql = "SELECT * FROM car WHERE mileage LIKE " + '"' + value + "%" + '"';
                break;
        }
        DefaultTableModel model;
        String com[] = {"ID", "COMPAÑIA", "MODELO", "N° SERIE", "COLOR", "ESTADO", "PRECIO", "PAIS", "HP", "N° REGISTRO", "KILOMETRAJE" };
        String row[] = new String[11];
        model = new DefaultTableModel(null, com);
        try {
            conn = setConnection();
            String SQL = txtSql;
            ps = conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                String color = "";
                switch(rs.getInt(5)){
                    case 1:
                        color = "1 BLANCO";
                        break;
                    case 2:
                        color = "2 ROJO";
                        break;
                    case 3:
                        color = "3 NARANJA";
                        break;
                    case 4:
                        color = "4 AMARILLO";
                        break;
                    case 5:
                        color = "5 VERDE";
                        break;
                    case 6:
                        color = "6 AZUL";
                        break;
                    case 7:
                        color = "7 GRIS";
                        break;
                }
                String state = "";
                switch(rs.getInt(6)){
                    case 0:
                        state = "0 NUEVO";
                        break;
                    case 1:
                        state = "1 SEMINUEVO";
                        break;
                    case 2:
                        state = "2 USADO";
                        break;
                }
                row[4] = color;
                row[5] = state;
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getString(9);
                row[9] = rs.getString(10);
                row[10] = rs.getString(11);
                model.addRow(row);
            }
        } catch (Exception e) {
        }
        return model;
    }
    
    public DefaultTableModel loadTableSales(){
        DefaultTableModel model;
        String com[] = {"ID", "FOLIO", "NOMBRE", "MODELO", "N° SERIE", "PRECIO VEHICULO", "ADICIONALES", "PRECIO ADICIONAL", "PRECIO TOTAL", "TIPO DE PAGO"};
        String row[] = new String[10];
        model = new DefaultTableModel(null, com);
        try {
            conn = setConnection();
            String SQL = "SELECT * FROM sales;";
            ps = conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                if(rs.getString(7) == null){
                    row[6] = "------------"; 
                    row[7] = "------------"; } else {
                    row[6] = rs.getString(7);
                    row[7] = rs.getString(8); }
                row[8] = rs.getString(9);
                if(rs.getInt(10) == 1){ row[9] = "TARJETA CREDITO"; }
                if(rs.getInt(10) == 2){ row[9] = "PAYPAL"; }
                model.addRow(row);
            }
        } catch (Exception e) {
        }
        return model;
    }
    
    public DefaultTableModel loadTableSalesFilter(int select, String value){
        String txtSql = null;
        switch(select){
            case 1:
                txtSql = "SELECT * FROM sales WHERE id LIKE " + '"' + value + "%" + '"';
                break;
            case 2:
                txtSql = "SELECT * FROM sales WHERE folio LIKE " + '"' + value + "%" + '"';
                break;
            case 3:
                txtSql = "SELECT * FROM sales WHERE name LIKE " + '"' + value + "%" + '"';
                break;
            case 4:
                txtSql = "SELECT * FROM sales WHERE model LIKE " + '"' + value + "%" + '"';
                break;
            case 5:
                txtSql = "SELECT * FROM sales WHERE serial_number LIKE " + '"' + value + "%" + '"';
                break;
            case 6:
                txtSql = "SELECT * FROM sales WHERE price_car LIKE " + '"' + value + "%" + '"';
                break;
            case 7:
                txtSql = "SELECT * FROM sales WHERE additional LIKE " + '"' + value + "%" + '"';
                break;
            case 8:
                txtSql = "SELECT * FROM sales WHERE price_additional LIKE " + '"' + value + "%" + '"';
                break;
            case 9:
                txtSql = "SELECT * FROM sales WHERE price_total LIKE " + '"' + value + "%" + '"';
                break;
            case 10:
                txtSql = "SELECT * FROM sales WHERE type_payment LIKE " + '"' + value + "%" + '"';
                break;
        }
        DefaultTableModel model;
        String com[] = {"ID", "FOLIO", "NOMBRE", "MODELO", "N° SERIE", "PRECIO VEHICULO", "ADICIONALES", "PRECIO ADICIONAL", "PRECIO TOTAL", "TIPO DE PAGO"};
        String row[] = new String[10];
        model = new DefaultTableModel(null, com);
        try {
            conn = setConnection();
            String SQL = txtSql;
            ps = conn.prepareCall(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
               if(rs.getString(7) == null){
                    row[6] = "------------"; 
                    row[7] = "------------"; } else {
                    row[6] = rs.getString(7);
                    row[7] = rs.getString(8); }
                row[8] = rs.getString(9);
                if(rs.getInt(10) == 1){ row[9] = "TARJETA CREDITO"; }
                if(rs.getInt(10) == 2){ row[9] = "PAYPAL"; }
                model.addRow(row);
            }
        } catch (Exception e) {
        }
        return model;
    }
    
//---------------------------------------------------------------------------------------------------------------------------------------------
    public boolean ValidateUser(String user){
        boolean okey = false;
        try {
            conn = setConnection();
            String SQL = "SELECT user FROM users  WHERE user = ?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if(rs.next()){ okey = true; } 
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return okey;
    }
    
    public boolean ValidateRFC(String rfc){
        boolean okey = false;
        try {
            conn = setConnection();
            String SQL = "SELECT rfc FROM users  WHERE rfc = ?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, rfc);
            rs = ps.executeQuery();
            if(rs.next()){ okey = true; } 
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return okey;
    }
    
    public boolean ValidateRFCicon(String rfc){
        boolean okey = false;
        try {
            conn = setConnection();
            String SQL = "SELECT * FROM users WHERE rfc LIKE " + '"' + rfc + "%" + '"';
            ps = conn.prepareCall(SQL);
            rs = ps.executeQuery();
            if(rs.next()){ okey = true; } 
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return okey;
    }
    
    public DefaultComboBoxModel loadModels(int selectCompany, int selectState){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Seleccionar");
        try {
            conn = setConnection();
            String SQL = "SELECT model FROM car WHERE company = ? and state = ?";
            ps = conn.prepareStatement(SQL);
            String company = null;
            switch(selectCompany){
                case 1:
                    company = "NISSAN";
                    break;
                case 2:
                    company = "AUDI";
                    break;
                case 3:
                    company = "VOLKSWAGEN";
                    break;
            }
            ps.setString(1, company);
            ps.setInt(2, selectState);
            rs = ps.executeQuery();
            while (rs.next()) {
                model.addElement("• "+rs.getString(1));
            }
        } catch (Exception e) {
        }
        return model;
    }
    
    public DefaultComboBoxModel loadSerial(String selectModel){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Seleccionar");
        try {
            conn = setConnection();
            String SQL = "SELECT serial_number FROM car WHERE model = ?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, selectModel);
            rs = ps.executeQuery();
            while (rs.next()) {
                model.addElement("• "+rs.getString(1));
            }
        } catch (Exception e) {
        }
        return model;
    }
    
    public DefaultComboBoxModel loadColorsQuotation(int selectSerial){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Seleccionar");
        try {
            conn = setConnection();
            String SQL = "SELECT color FROM car WHERE serial_number = ?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, selectSerial);
            rs = ps.executeQuery();
            while (rs.next()) {
                String color = null;
                switch(rs.getInt(1)){
                    case 1:
                        color = "BLANCO";
                        break;
                    case 2:
                        color = "ROJO";
                        break;
                    case 3:
                        color = "NARANJA";
                        break;
                    case 4:
                        color = "AMARILLO";
                        break;
                    case 5:
                        color = "VERDE";
                        break;
                    case 6:
                        color = "AZUL";
                        break;
                    case 7:
                        color = "GRIS";
                        break;
                }
                model.addElement("• "+color);
            }
        model.addElement("• Otro: ");
        } catch (Exception e) {
        }
        return model;
    }
    
    public DefaultComboBoxModel loadColorsVehicle(String selectModel){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Seleccionar");
        try {
            conn = setConnection();
            String SQL = "SELECT color FROM car WHERE model = ?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, selectModel);
            rs = ps.executeQuery();
            while (rs.next()) {
                String color = null;
                switch(rs.getInt(1)){
                    case 1:
                        color = "BLANCO";
                        break;
                    case 2:
                        color = "ROJO";
                        break;
                    case 3:
                        color = "NARANJA";
                        break;
                    case 4:
                        color = "AMARILLO";
                        break;
                    case 5:
                        color = "VERDE";
                        break;
                    case 6:
                        color = "AZUL";
                        break;
                    case 7:
                        color = "GRIS";
                        break;
                }
                model.addElement("• "+color);
            }
        } catch (Exception e) {
        }
        return model;
    }
    
    public int loadPriceCar(int serial_number){
        int txt = 0;
        try {
            conn = setConnection();
            String SQL = "SELECT price FROM car WHERE serial_number = ?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, serial_number);
            rs = ps.executeQuery();
            if(rs.next()){
                txt = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return txt;
    }
//---------------------------------------------------------------------------------------------------------------------------------------------
    public void DeleteUserAdmin(String rfc){
        try {
            conn = setConnection();
            String SQL = "DELETE FROM users WHERE rfc = ? ";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, rfc);
            int i = ps.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(
                    null, "Usuario eliminado correctamente.",
                    "", JOptionPane.DEFAULT_OPTION, icon);
            } else {
                JOptionPane.showMessageDialog(
                    null, "Error al eliminar el usuario.",
                    "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: "+e);
        }
    }
    
    public void DeleteCarPurchase(int serial_number){
        try {
            conn = setConnection();
            String SQL = "DELETE FROM car WHERE serial_number = ? ";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, serial_number);
            int i = ps.executeUpdate();
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: "+e);
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------
    public void ModifyUserData(int id, String name, String email, String rfc, String user, String pass, String age){
        try {
            conn = setConnection();
            String SQL = "UPDATE users SET name = ?, email = ?, rfc = ?, user = ?, pass = ?, age = ? WHERE id = ?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, rfc);
            ps.setString(4, user);
            ps.setString(5, pass);
            ps.setString(6, age);
            ps.setInt(7, id);
            int i = ps.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(
                    null, "Datos Guardados.",
                    "", JOptionPane.DEFAULT_OPTION, icon);
            } else {
                JOptionPane.showMessageDialog(
                    null, "Error al guardar los datos.",
                    "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: "+e);
        } 
    }
    
    public void ModifyUserDataAdmin(String rfc,int state, String name, String email, String rfcNew, String user, String pass, String age){
        try {
            conn = setConnection();
            String SQL = "UPDATE users SET state = ?, name = ?, email = ?, rfc = ?, user = ?, pass = ?, age = ? WHERE rfc = ?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, state);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, rfcNew);
            ps.setString(5, user);
            ps.setString(6, pass);
            ps.setString(7, age);
            ps.setString(8, rfc);
            int i = ps.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(
                    null, "Datos Guardados.",
                    "", JOptionPane.DEFAULT_OPTION, icon);
            } else {
                JOptionPane.showMessageDialog(
                    null, "Error al guardar los datos.",
                    "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: "+e);
        } 
    }
    
    public void ModifyUserDataAdminFilter(int select, String value){
        String txtSql = null;
        switch(select){
            case 1:
                txtSql =  "UPDATE users SET state = ? WHERE rfc = ?";
                break;
            case 2:
                txtSql =  "UPDATE users SET name = ? WHERE rfc = ?";
                break;
            case 3:
                txtSql =  "UPDATE users SET email = ? WHERE rfc = ?";
                break;
            case 4:
                txtSql =  "UPDATE users SET rfc = ? WHERE id = ?";
                break;
            case 5:
                txtSql =  "UPDATE users SET user = ? WHERE id = ?";
                break;
            case 6:
                txtSql =  "UPDATE users SET pass = ? WHERE id = ?";
                break;
            case 7:
                txtSql =  "UPDATE users SET age = ? WHERE id = ?";
                break;
        }
        try {
            conn = setConnection();
            String SQL = txtSql;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, value);
            int i = ps.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(
                    null, "Datos Guardados.",
                    "", JOptionPane.DEFAULT_OPTION, icon);
            } else {
                JOptionPane.showMessageDialog(
                    null, "Datos Guardados.",
                    "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: "+e);
        } 
    }
    
  //---------------------------------------------------------------------------------------------------------------------------------------------
    //sergio 
    
    public void pdfCreateTableSales(String url, int select, String value) {
        String txtSql, filter;
        switch(select){
            case 1:
                txtSql = "SELECT * FROM sales WHERE id LIKE " + '"' + value + "%" + '"';
                filter = "ID";
                break;
            case 2:
                txtSql = "SELECT * FROM sales WHERE folio LIKE " + '"' + value + "%" + '"';
                filter = "FOLIO";
                break;
            case 3:
                txtSql = "SELECT * FROM sales WHERE name LIKE " + '"' + value + "%" + '"';
                filter = "NOMBRE";
                break;
            case 4:
                txtSql = "SELECT * FROM sales WHERE model LIKE " + '"' + value + "%" + '"';
                filter = "MODELO";
                break;
            case 5:
                txtSql = "SELECT * FROM sales WHERE serial_number LIKE " + '"' + value + "%" + '"';
                filter = "N° SERIE";
                break;
            case 6:
                txtSql = "SELECT * FROM sales WHERE price_car LIKE " + '"' + value + "%" + '"';
                filter = "PRECIO";
                break;
            case 7:
                txtSql = "SELECT * FROM sales WHERE additional LIKE " + '"' + value + "%" + '"';
                filter = "EXTRAS";
                break;
            case 8:
                txtSql = "SELECT * FROM sales WHERE price_additional LIKE " + '"' + value + "%" + '"';
                filter = "PRECIO EXTRA";
                break;
            case 9:
                txtSql = "SELECT * FROM sales WHERE price_total LIKE " + '"' + value + "%" + '"';
                filter = "PRECIO TOTAL";
                break;
            case 10:
                txtSql = "SELECT * FROM sales WHERE type_payment LIKE " + '"' + value + "%" + '"';
                filter = "SIN FILTRO";
                break;
            default:
                txtSql = "SELECT * FROM sales ";
                filter = "";
                break;
        }

        try{
            conn = setConnection();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(txtSql);

            OutputStream file = null;
                try { 
                    file = new FileOutputStream(new File(url+".pdf"));
                } catch (FileNotFoundException ex) { 
                    System.out.println(ex);
                }
                
            Document document = new Document();
            PdfWriter.getInstance(document, file);

            document.open();
            PdfPTable table = new PdfPTable(9);
            Paragraph p = new Paragraph("LISTA DE VENTAS DE PRODUCTOS ("+filter+")\n\n", FontFactory.getFont("Arial",16,Font.ITALIC,BaseColor.BLUE));

            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph(""));
            
            float[] size ={3.30f,3.50f,3.50f,3.70f,3.70f,3.50f,3.70f,3.70f,3.50f};

            table.setWidths(size);
            table.addCell(new Paragraph("ID", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("FOLIO", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("MODELO", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("N° SERIAL", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("PRECIO", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("EXTRAS", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("PRECIO EXTRA", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("TOTAL", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("TIPO DE PAGO", FontFactory.getFont("Arial",12)));
                
            while (rs.next()){
                table.addCell(new Paragraph(rs.getString("id"), FontFactory.getFont("Arial",10)));                  
                table.addCell(new Paragraph(rs.getString("folio"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("model"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("serial_number"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("price_car"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("additional"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("price_additional"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("price_total"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("type_payment"), FontFactory.getFont("Arial",10)));
            }
            
            document.add(table);              
            document.close();
            file.close();
        
        } catch (SQLException e){
              System.out.println(e);
        } catch (DocumentException ex) {
                System.out.println(ex);
        } catch (IOException ex) {
                System.out.println(ex);
        }

        try{
            File file = new File(url+".pdf");
            Desktop.getDesktop().open(file);
        } catch (IOException e){
            System.out.println(e);
        }
      
    }
    

     public void pdfCreateTableInventory(String url, int select, String value) {
        String txtSql, filter;
        switch(select){
            case 1:
                txtSql = "SELECT * FROM car WHERE id LIKE " + '"' + value + "%" + '"';
                filter = "ID";
                break;
            case 2:
                txtSql = "SELECT * FROM car WHERE company LIKE " + '"' + value + "%" + '"';
                filter = "COMPAÑIA";
                break;
            case 3:
                txtSql = "SELECT * FROM car WHERE model LIKE " + '"' + value + "%" + '"';
                filter = "MODELO";
                break;
            case 4:
                txtSql = "SELECT * FROM car WHERE serial_number LIKE " + '"' + value + "%" + '"';
                filter = "N° SERIE";
                break;
            case 5:
                txtSql = "SELECT * FROM car WHERE color LIKE " + '"' + value + "%" + '"';
                filter = "COLOR";
                break;
            case 6:
                txtSql = "SELECT * FROM car WHERE state LIKE " + '"' + value + "%" + '"';
                filter = "ESTADO";
                break;
            case 7:
                txtSql = "SELECT * FROM car WHERE price LIKE " + '"' + value + "%" + '"';
                filter = "PRECIO";
                break;
            case 8:
                txtSql = "SELECT * FROM car WHERE country LIKE " + '"' + value + "%" + '"';
                filter = "PAIS";
                break;
            case 9:
                txtSql = "SELECT * FROM car WHERE horsepower LIKE " + '"' + value + "%" + '"';
                filter = "HP";
                break;
            case 10:
                txtSql = "SELECT * FROM car WHERE car_registration LIKE " + '"' + value + "%" + '"';
                filter = "PLACAS";
                break;
            case 11:
                txtSql = "SELECT * FROM car WHERE mileage LIKE " + '"' + value + "%" + '"';
                filter = "KILOMETRAJE";
                break;
            default:
                txtSql = "SELECT * FROM car ";
                filter = "SIN FILTRO";
                break;
        }
        try{
            conn = setConnection();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(txtSql);
            
            OutputStream file = null;
            try {
                file = new FileOutputStream(new File(url+".pdf"));
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
            
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, file);

            document.open();
            PdfPTable table = new PdfPTable(11);
            Paragraph p = new Paragraph("LISTA DE INVENTARIO DE VEHICULOS ("+filter+")\n\n", FontFactory.getFont("Arial",16,Font.ITALIC,BaseColor.BLUE));

            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            
            document.add(new Paragraph(""));
            
            float[] size ={3.30f,3.50f,3.50f,3.70f,3.70f,3.50f,3.70f,3.70f,3.50f,3.70f,3.50f};
            table.setWidths(size);
            table.addCell(new Paragraph("ID", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("COMPAÑIA", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("MODELO", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("N° SERIE", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("COLOR", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("ESTADO", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("PRECIO", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("PAIS", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("HP", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("PLACAS", FontFactory.getFont("Arial",12)));
            table.addCell(new Paragraph("KILOMETRAJE", FontFactory.getFont("Arial",12)));
            
            while (rs.next()){
                table.addCell(new Paragraph(rs.getString("id"), FontFactory.getFont("Arial",10)));                  
                table.addCell(new Paragraph(rs.getString("company"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("model"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("serial_number"), FontFactory.getFont("Arial",10)));
                String color = "";
                switch(rs.getInt(5)){
                    case 1:
                        color = "BLANCO";
                        break;
                    case 2:
                        color = "ROJO";
                        break;
                    case 3:
                        color = "NARANJA";
                        break;
                    case 4:
                        color = "AMARILLO";
                        break;
                    case 5:
                        color = "VERDE";
                        break;
                    case 6:
                        color = "AZUL";
                        break;
                    case 7:
                        color = "GRIS";
                        break;
                }
                String state = "";
                switch(rs.getInt(6)){
                    case 0:
                        state = "NUEVO";
                        break;
                    case 1:
                        state = "SEMINUEVO";
                        break;
                    case 2:
                        state = "USADO";
                        break;
                }
                table.addCell(new Paragraph(color, FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(state, FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("price"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("country"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("horsepower"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("car_registration"), FontFactory.getFont("Arial",10)));
                table.addCell(new Paragraph(rs.getString("mileage"), FontFactory.getFont("Arial",10)));
            }     

            document.add(table);              
            document.close();
            file.close();                         
        } catch (SQLException e){
                System.out.println(e);
        } catch (DocumentException ex) {
                System.out.println(ex);
        } catch (IOException ex) {
                System.out.println(ex);
        }
      
        try{
            File file = new File(url+".pdf");
            Desktop.getDesktop().open(file);
        } catch (IOException e){
            System.out.println(e);
        }
    }
     
     public void pdfCreateTableUsers(String url) {
        try{
            conn = setConnection();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM users;");

            OutputStream file = null;
                try { 
                    file = new FileOutputStream(new File(url+".pdf"));
                } catch (FileNotFoundException ex) { 
                    System.out.println(ex);
                }
                
            Document document = new Document();
            PdfWriter.getInstance(document, file);

            document.open();
            PdfPTable tabla = new PdfPTable(8);
            Paragraph p = new Paragraph("LISTA DE USUARIOS \n\n", FontFactory.getFont("Arial",16,Font.ITALIC,BaseColor.BLUE));

            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

            document.add(new Paragraph(""));
            float[] size ={2.00f, 4.90f, 3.50f, 3.70f, 3.70f, 3.50f, 3.70f, 3.90f};

            tabla.setWidths(size);
            tabla.addCell(new Paragraph("id", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("state", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("name", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("email", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("rfc", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("user", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("pass", FontFactory.getFont("Arial",12)));
            tabla.addCell(new Paragraph("age", FontFactory.getFont("Arial",12)));
                
            while (rs.next()){
                tabla.addCell(new Paragraph(rs.getString(1), FontFactory.getFont("Arial",10)));        
                String state = "";
                switch(rs.getInt(2)){
                    case 0:
                        state = "usuario";
                        break;
                    case 1:
                        state = "administrador";
                        break;
                }
                tabla.addCell(new Paragraph(state, FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(rs.getString("name"), FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(rs.getString("email"), FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(rs.getString("rfc"), FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(rs.getString("user"), FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(rs.getString("pass"), FontFactory.getFont("Arial",10)));
                tabla.addCell(new Paragraph(rs.getString("age"), FontFactory.getFont("Arial",10)));
            }
            
            document.add(tabla);              
            document.close();
            file.close();
        
        } catch (SQLException e){
              System.out.println(e);
        } catch (DocumentException ex) {
                System.out.println(ex);
        } catch (IOException ex) {
                System.out.println(ex);
        }

        try{
            File file = new File(url+".pdf");
            Desktop.getDesktop().open(file);
        } catch (IOException e){
            System.out.println(e);
        }
      
    }
//---------------------------------------------------------------------------------------------------------------------------------------------
    
}
