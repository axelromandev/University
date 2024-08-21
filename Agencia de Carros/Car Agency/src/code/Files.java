/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import view.Login;
import view.user.Purchase;

/**
 *
 * @author Restf
 */
public class Files {
    public void pdfCreateFile(String url, String price, String extra, String total, int value){
        String txtCompany = Purchase.selectCompany.getSelectedItem().toString();
        String companyPDF = txtCompany.substring(2);
        String txtState = Purchase.selectState.getSelectedItem().toString();
        String statePDF = txtState.substring(2);
        String txtModel = Purchase.selectModel.getSelectedItem().toString();
        String modelPDF = txtModel.substring(2);
        String txtSerial = Purchase.selectSerial.getSelectedItem().toString();
        String serialPDF = txtSerial.substring(2);
        String txtColors = Purchase.selectColors.getSelectedItem().toString();
        String colorsPDF = txtColors.substring(2);
        String txtColorsNew = Purchase.selectColorsNew.getSelectedItem().toString();
        String colorNewPDF = txtColorsNew.substring(2);
        String txtTypePayment = Purchase.selectTypePayment.getSelectedItem().toString();
        String typePDF = txtTypePayment.substring(2);
        
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        PdfPTable table = new PdfPTable(2);
        float[] mediaCeldas ={3.30f,3.50f};
        PdfPTable tablePDF = new PdfPTable(1);
        float[] mediaCeldass ={3.30f};
        
        try {
            tablePDF.setWidths(mediaCeldass);
        } catch (DocumentException ex) {
            System.out.println(ex);
        }
        tablePDF.addCell(new Paragraph("                         DESCRIPCION    ", FontFactory.getFont("Arial",20,Font.BOLD,BaseColor.BLUE)));
        try {
            table.setWidths(mediaCeldas);
        } catch (DocumentException ex) {
            System.out.println(ex);
        }
        table.addCell(new Paragraph("COMPAÑIA"+"\n\nESTADO"+"\n\nMODELO"+"\n\nNUMERO SERIAL"+"\n\nCOLOR", FontFactory.getFont("Arial",20)));
        table.addCell(new Paragraph(companyPDF+"\n\n"+statePDF+"\n\n"+modelPDF+"\n\n"+serialPDF+"\n\n"+colorsPDF, FontFactory.getFont("Arial",20)));

        Random random = new Random();
        int f = random.nextInt(10000);
        int c = random.nextInt(1000);
        try{
            FileOutputStream archivo = new FileOutputStream(url+".pdf");
            Document doc= new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            doc.add(new Paragraph("CAR AGENCY                                FACTURA",                                                                                      FontFactory.getFont("Arial",25,Font.ROMAN_BASELINE,BaseColor.BLACK)));
            doc.add(new Paragraph("Un auto nuevo es un sueño nuevo                                                              Fecha: "+format.format(date),               FontFactory.getFont("Arial",12,Font.ROMAN_BASELINE,BaseColor.BLACK)));
            doc.add(new Paragraph("                                                                                                                     N° de Factura: "+f, FontFactory.getFont("Arial",12,Font.ROMAN_BASELINE,BaseColor.BLACK)));
            doc.add(new Paragraph("                                                                                                                     N°de Cliente: "+c,  FontFactory.getFont("Arial",12,Font.ROMAN_BASELINE,BaseColor.BLACK)));
            doc.add(new Paragraph("FACTURA A: "+Login.userEntity.getName(),                                                                                                 FontFactory.getFont("Arial",12,Font.ROMAN_BASELINE,BaseColor.BLACK)));
            doc.add(new Paragraph("Blvrd Toluca Metepec 300, Zona Sin Asignación de Nombre de Col 1, 52140 Metepec, Méx.",                                                  FontFactory.getFont("Arial",12,Font.ROMAN_BASELINE,BaseColor.BLACK)));
            doc.add(new Paragraph("7291307338",                                                                                                                             FontFactory.getFont("Arial",12,Font.ROMAN_BASELINE,BaseColor.BLACK)));
            doc.add(new Paragraph("\n\n"));
            doc.add(tablePDF);
            doc.add(table);
            doc.add(new Paragraph("\n\n                                                                                           TIPO DE PAGO: "+typePDF,                  FontFactory.getFont("Arial",12,Font.ROMAN_BASELINE,BaseColor.BLACK)));
            doc.add(new Paragraph("                                                                                            PRECIO: $"+price,                            FontFactory.getFont("Arial",12,Font.ROMAN_BASELINE,BaseColor.BLACK)));
            doc.add(new Paragraph("                                                                                            ADICIONES: $"+extra,                         FontFactory.getFont("Arial",12,Font.ROMAN_BASELINE,BaseColor.BLACK)));
            doc.add(new Paragraph("                                                                                            TOTAL: $"+total,                             FontFactory.getFont("Arial",12,Font.ROMAN_BASELINE,BaseColor.BLACK)));
            doc.close();
        } catch(Exception e) {
            System.out.println("Error: "+e);
        }
        
        ProcessBuilder p= new ProcessBuilder();
        p.command("cmd.exe","/c",url+".pdf");
        try {
            p.start();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
    
    
}
