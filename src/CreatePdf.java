
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 *
 * @author Sujan
 */
public class CreatePdf {
    public static void main(String[] args) {
        
        Document document=new Document();
        try {
            PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream("Sujan.pdf"));
            document.open();
            document.add(new Paragraph("Welcome to Sujan"));
            PdfPTable table=new PdfPTable(3);
            table.setWidthPercentage(105);
            table.setSpacingBefore(11f);
            table.setSpacingAfter(11f);
           
            float[] colWidth={2f,2f,2f};
            table.setWidths(colWidth);
            
            PdfPCell c1=new PdfPCell(new Paragraph("Column1"));
            PdfPCell c2=new PdfPCell(new Paragraph("Column2"));
            PdfPCell c3=new PdfPCell(new Paragraph("Column3"));
            
            table.addCell(c1);
            table.addCell(c2);
            table.addCell(c3);
            
            document.add(table);
            
            List orderList=new List(List.ORDERED);
            orderList.add(new ListItem("Fun"));
            orderList.add(new ListItem("love"));
            orderList.add(new ListItem("care"));
            orderList.add(new ListItem("miss"));
            document.add(orderList);
            
            List unorderList=new List(List.UNORDERED);
            unorderList.add(new ListItem("Technology"));
            unorderList.add(new ListItem("information"));
            unorderList.add(new ListItem("programming"));
            unorderList.add(new ListItem("Structures"));
            unorderList.add(new ListItem("biotech"));
            document.add(unorderList);
            
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
