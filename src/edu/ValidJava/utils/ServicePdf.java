/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.ValidJava.entities.Equipe;
import edu.ValidJava.services.EquipeCRUD;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MSI
 */
public class ServicePdf {
     public void equipePDF() throws FileNotFoundException, DocumentException, SQLException {

        EquipeCRUD so = new EquipeCRUD();
        String message = "                     La liste des Equipes \n\n";
      
        
        String file_name = "src/PDF/equipe.pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file_name));
        document.open();
        Paragraph para = new Paragraph(message);
        document.add(para);
         List<Equipe> equipe = so.ReadEquipe();
        PdfPTable table = new PdfPTable(4);

        PdfPCell cl = new PdfPCell(new Phrase("id"));
        table.addCell(cl);
        PdfPCell cl1 = new PdfPCell(new Phrase("Nom Equipe"));
        table.addCell(cl1);
        PdfPCell cl2 = new PdfPCell(new Phrase("Nombre de Joueurs"));
        table.addCell(cl2);
        PdfPCell cl3 = new PdfPCell(new Phrase("Nom Joueurs"));
        table.addCell(cl);
        
        
        table.setHeaderRows(1);
        document.add(table);

        for (int i = 0; i < equipe.size(); i++) {
            table.addCell(""+ equipe.get(i).getId());
            table.addCell("" + equipe.get(i).getNom_equipe());
            table.addCell("" + equipe.get(i).getNbr_joueurs());
            table.addCell("" + equipe.get(i).getNom_joueurs());

            

        }
        document.add(table);

        document.close();

    }
       
      
    
}
