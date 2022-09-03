package ReportesPDF;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import modelo.CuentaVO;

public class ReporteUsuarios {

    CuentaVO cuentas[] = new CuentaVO[10];

    public ReporteUsuarios() {
    }

    
    public void generarHtml() {

        String nombreReporte;
        File reporte;
        FileWriter fw;
        BufferedWriter br;
        String cadenaHTML;

        try {
            nombreReporte = "Usuarios Registrados.html";
            reporte = new File(nombreReporte);
            fw = new FileWriter(reporte);
            br = new BufferedWriter(fw);

            cadenaHTML = "<html>"
                    + "    <head>"
                    + "    <body>"
                    + "        <table border = 2>"
                    + "            <tr>"
                    + "                <td>Nombre</td>"
                    + "                <td>Cui</td>"
                    + "                <td>Saldo Actual</td>"

                    + "            </tr>";

            for (int x = 0; x < cuentas.length; x++) {
                if (cuentas[x] != null) {
                    cadenaHTML += "            <tr>"
                            + "                <td>" + cuentas[x].getNombreC() + "</td>"
                            + "                <td>" + cuentas[x].getCuiC() + "</td>"
                            + "                <td>" + cuentas[x].getSaldoC() + "</td>"
                            + "            </tr>";
                }
            }

            cadenaHTML += "        </table>"
                    + "    </body>"
                    + "</html>";

            br.write(cadenaHTML);

            br.close();
            fw.close();

            crearPdf(cadenaHTML);

        } catch (IOException ex) {
            System.out.println("error escribiendo el reporte. Detalles " + ex.getMessage());
        }

    }
    
    public void crearPdf(String html){
        try{
            
                Document document = new Document(PageSize.LETTER) {};
                PdfWriter.getInstance(document, new FileOutputStream("reporte.pdf"));

                document.open();
                document.addAuthor("IPC1 E");
                document.addCreator("IPC1 E");
                document.addSubject("Ejemplo Reporte PDF");
                document.addCreationDate();
                document.addTitle("Reporte pdf");

                HTMLWorker htmlWorker = new HTMLWorker(document);
                htmlWorker.parse(new StringReader(html));

                document.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

}
