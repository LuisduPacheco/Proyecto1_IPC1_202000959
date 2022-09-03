package controlador;

import ReportesPDF.ReporteUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.CuentaVO;
import modelo.UsuarioVO;
import vista.FrmReportes;

public class contReportes implements ActionListener, WindowListener {

    FrmReportes vRep = new FrmReportes();
    UsuarioVO[] usuarios = new UsuarioVO[5];
    CuentaVO[] cuentas = new CuentaVO[10];
    //PDF
    ReporteUsuarios reporte = new ReporteUsuarios();
    
    public contReportes(FrmReportes vRep, UsuarioVO[] usuarios, CuentaVO[] cuentas,ReporteUsuarios reporte) {
        this.vRep = vRep;
        this.usuarios = usuarios;
        this.cuentas = cuentas;
        this.reporte = reporte;
        
        vRep.addWindowListener(this);
        vRep.btnBuscar.addActionListener(this);
        vRep.btnReporteU.addActionListener(this);
    }

    private int mostrar() {
        int posicion = -1;
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("CUI");
        m.addColumn("Nombre");
        m.addColumn("Apellido");

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                m.addRow(new Object[]{usuarios[i].getCui(), usuarios[i].getNombre(), usuarios[i].getApellido()});
            }
            posicion = i;
        }
        vRep.tblUsuarios.setModel(m);
        return posicion;
    }

    private boolean mostrarC() {
        boolean validar = false;
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("No. Cuenta");


        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null) {
                if(cuentas[i].getCuiC().equals(vRep.txtBuscar.getText())){
                m.addRow(new Object[]{cuentas[i].getIdCuenta()});
                validar = true;
                }                
            }

        }
        vRep.tblCuentas.setModel(m);
        return validar;
    }

    @Override
    public void actionPerformed(ActionEvent e
    ) {
        if (e.getSource() == vRep.btnBuscar) {
            if(!vRep.txtBuscar.getText().equals("")){
            this.mostrarC();
            System.out.println("Buscar... ");
            if (this.mostrarC() != true){
                vRep.jopMensaje.showMessageDialog(vRep, "No hay coincidencias en la busqueda");
                }
            }else{
                vRep.jopMensaje.showMessageDialog(vRep, "Debe ingresar un CUI para la busqueda");
            }            
        }
        if(e.getSource() == vRep.btnReporteU){
            
            reporte.generarHtml();
            System.out.println("Reporte Usuarios");
        }
    }

    @Override
    public void windowOpened(WindowEvent e
    ) {
        this.mostrar();
    }

    @Override
    public void windowClosing(WindowEvent e){
        vRep.txtBuscar.setText("");
        this.mostrarC();
    }

    @Override
    public void windowClosed(WindowEvent e
    ) {
    }

    @Override
    public void windowIconified(WindowEvent e
    ) {
    }

    @Override
    public void windowDeiconified(WindowEvent e
    ) {
    }

    @Override
    public void windowActivated(WindowEvent e
    ) {

    }

    @Override
    public void windowDeactivated(WindowEvent e
    ) {
    }

}
