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
import modelo.DepositosVO;
import modelo.Extras;
import modelo.RetirosVO;
import modelo.TransaccionVO;
import vista.FrmHistorial;

public class ReporteUsuarios {

//    CuentaVO cuentas[] = new CuentaVO[10];
//    FrmHistorial vHist = new FrmHistorial();

    public ReporteUsuarios() {

    }

    public void generarHtml(CuentaVO cuentas[]) {

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
                    + "    <title>Reporte de Usuarios Registrados</title><br>"
                    + "        <table border = 2>"
                    + "            <tr style=\"border-color: blue;\">"
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

    public void crearPdf(String html) {
        try {

            Document document = new Document(PageSize.LETTER) {
            };
            PdfWriter.getInstance(document, new FileOutputStream("ReporteUsuarios_"+Extras.fechaReporte()+".pdf"));

            document.open();
            document.addAuthor("IPC1 E");
            document.addCreator("IPC1 E");
            document.addSubject("Ejemplo Reporte PDF");
            document.addCreationDate();
            document.addTitle("Reporte pdf");

            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(html));

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void depositosHtml(DepositosVO depositos[], FrmHistorial vHist) {

        String nombreReporte;
        File reporte;
        FileWriter fw;
        BufferedWriter br;
        String cadenaHTML;

        try {
            nombreReporte = "Depositos Registrados.html";
            reporte = new File(nombreReporte);
            fw = new FileWriter(reporte);
            br = new BufferedWriter(fw);

            cadenaHTML = "<html>"
                    + "    <head>"
                    + "    <body>"
                    + "    <title>Historial de Depositos</title><br>"
                    + "        <table border = 2>"
                    + "            <tr style=\"border-color: blue;\">"
                    + "                <td>ID Deposito</td>"
                    + "                <td>No. Cuenta</td>"
                    + "                <td>Nombre</td>"
                    + "                <td>Cui</td>"
                    + "                <td>Motivo</td>"
                    + "                <td>Saldo Inicial</td>"
                    + "                <td>Saldo Final</td>"
                    + "                <td>Fecha</td>"
                    + "            </tr>";

            for (int x = 0; x < depositos.length; x++) {
                if (depositos[x] != null) {
                    if (depositos[x].getIdCuenta() == Integer.parseInt(vHist.txtIdCuenta.getText())) {
                        cadenaHTML += "            <tr>"
                                + "                <td>" + depositos[x].getContador() + "</td>"
                                + "                <td>" + depositos[x].getIdCuenta() + "</td>"
                                + "                <td>" + depositos[x].getNombreC() + "</td>"
                                + "                <td>" + depositos[x].getCuiC() + "</td>"
                                + "                <td>" + depositos[x].getMotivo() + "</td>"
                                + "                <td>" + depositos[x].getSaldoI() + "</td>"
                                + "                <td>" + depositos[x].getSaldoF() + "</td>"
                                + "                <td>" + depositos[x].getFecha() + "</td>"
                                + "            </tr>";
                    }
                }
            }

            cadenaHTML += "        </table>"
                    + "    </body>"
                    + "</html>";

            br.write(cadenaHTML);

            br.close();
            fw.close();

            crearDepositosPdf(cadenaHTML);

        } catch (IOException ex) {
            System.out.println("error escribiendo el reporte. Detalles " + ex.getMessage());
        }

    }

    public void crearDepositosPdf(String html) {
        try {

            Document document = new Document(PageSize.LETTER) {
            };
            PdfWriter.getInstance(document, new FileOutputStream("ReporteDepositos_"+Extras.fechaReporte()+".pdf"));

            document.open();
            document.addAuthor("IPC1 D");
            document.addCreator("IPC1 D");
            document.addSubject("Reporte IPC1 - BANK PDF");
            document.addCreationDate();
            document.addTitle("Reporte Transacciones pdf");

            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(html));

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
        public void retirosHtml(RetirosVO retiros[], FrmHistorial vHist) {

        String nombreReporte;
        File reporte;
        FileWriter fw;
        BufferedWriter br;
        String cadenaHTML;

        try {
            nombreReporte = "Retiros Registrados.html";
            reporte = new File(nombreReporte);
            fw = new FileWriter(reporte);
            br = new BufferedWriter(fw);

            cadenaHTML = "<html>"
                    + "    <head>"
                    + "    <body>"
                    + "    <title>Historial de Retiros</title><br>"
                    + "        <table border = 2>"
                    + "            <tr style=\"border-color: blue;\">"
                    + "                <td>ID Retiro</td>"
                    + "                <td>No. Cuenta</td>"
                    + "                <td>Nombre</td>"
                    + "                <td>Cui</td>"
                    + "                <td>Motivo</td>"
                    + "                <td>Saldo Inicial</td>"
                    + "                <td>Saldo Final</td>"
                    + "                <td>Fecha</td>"
                    + "            </tr>";

            for (int x = 0; x < retiros.length; x++) {
                if (retiros[x] != null) {
                    if (retiros[x].getIdCuenta() == Integer.parseInt(vHist.txtIdCuenta.getText())) {
                        cadenaHTML += "            <tr>"
                                + "                <td>" + retiros[x].getContador() + "</td>"
                                + "                <td>" + retiros[x].getIdCuenta() + "</td>"
                                + "                <td>" + retiros[x].getNombreC() + "</td>"
                                + "                <td>" + retiros[x].getCuiC() + "</td>"
                                + "                <td>" + retiros[x].getMotivo() + "</td>"
                                + "                <td>" + retiros[x].getSaldoI() + "</td>"
                                + "                <td>" + retiros[x].getSaldoF() + "</td>"
                                + "                <td>" + retiros[x].getFecha() + "</td>"
                                + "            </tr>";
                    }
                }
            }

            cadenaHTML += "        </table>"
                    + "    </body>"
                    + "</html>";

            br.write(cadenaHTML);

            br.close();
            fw.close();

            crearRetirosPdf(cadenaHTML);

        } catch (IOException ex) {
            System.out.println("error escribiendo el reporte. Detalles " + ex.getMessage());
        }

    }

    public void crearRetirosPdf(String html) {
        try {

            Document document = new Document(PageSize.LETTER) {
            };
            PdfWriter.getInstance(document, new FileOutputStream("ReporteRetiros_"+Extras.fechaReporte()+".pdf"));

            document.open();
            document.addAuthor("IPC1 D");
            document.addCreator("IPC1 D");
            document.addSubject("Reporte IPC1 - BANK PDF");
            document.addCreationDate();
            document.addTitle("Reporte Retiros pdf");

            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(html));

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
