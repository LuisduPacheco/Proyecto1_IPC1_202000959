package controlador;

import ReportesPDF.ReporteUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.CuentaVO;
import modelo.DepositosVO;
import modelo.RetirosVO;
import modelo.TransaccionVO;
import modelo.UsuarioVO;
import vista.FrmHistorial;
import vista.FrmReportes;

public class contHistorial implements ActionListener, WindowListener {
    
    FrmHistorial vHist = new FrmHistorial();
    UsuarioVO[] usuarios = new UsuarioVO[5];
    CuentaVO[] cuentas = new CuentaVO[10];
    TransaccionVO[] transacciones = new TransaccionVO[20];
    DepositosVO[] depositos = new DepositosVO[20];
    RetirosVO[] retiros = new RetirosVO[20];
    //PDF
    ReporteUsuarios reporte = new ReporteUsuarios();
    
    public contHistorial(FrmHistorial vHist, CuentaVO[] cuentas, TransaccionVO[] transacciones, ReporteUsuarios reporte, DepositosVO[] depositos, RetirosVO[] retiros) {
        this.vHist = vHist;
        this.cuentas = cuentas;
        this.transacciones = transacciones;
        this.reporte = reporte;
        this.depositos = depositos;
        this.retiros = retiros;
        vHist.addWindowListener(this);
        vHist.btnMostar.addActionListener(this);
        vHist.btnDepositos.addActionListener(this);
        vHist.btnRetiros.addActionListener(this);
        
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
        m.addColumn("No. Transacción");
        m.addColumn("Fecha");
        m.addColumn("Detalle");
        m.addColumn("Monto");
        
        for (int i = 0; i < transacciones.length; i++) {
            if (transacciones[i] != null) {
                if (transacciones[i].getIdCuenta() == (Integer.parseInt(vHist.txtIdCuenta.getText()))) {
                    m.addRow(new Object[]{transacciones[i].getContador(), transacciones[i].getFecha(), transacciones[i].getTransaccion(), transacciones[i].getMonto()});
                    validar = true;
                }
            }
        }
        vHist.tblMostrar.setModel(m);
        return validar;
    }
    
    public int buscar() {
        int validar = 0;
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i].getIdCuenta() == Integer.parseInt(vHist.txtIdCuenta.getText())) {
                validar = i;
                break;
            }
        }
        return validar;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vHist.btnMostar) {
            if (!vHist.txtIdCuenta.getText().equals("")) {
                this.mostrarC();
                if (this.mostrarC() == true) {
                    vHist.txtCui.setText(cuentas[this.buscar()].getCuiC());
                    vHist.txtNombre.setText(cuentas[this.buscar()].getNombreC());
                    vHist.txtApellido.setText(String.valueOf(cuentas[this.buscar()].getSaldoC()));
                }
            } else {
                vHist.jopMensaje.showMessageDialog(vHist, "Debe ingresar un ID");
            }
            
        }
        if (e.getSource() == vHist.btnDepositos) {
            if (!vHist.txtCui.getText().equals("")) {
                System.out.println("Depositos - Reporte");
                reporte.depositosHtml(depositos, vHist);
                vHist.jopMensaje.showMessageDialog(vHist, "Reporte de Depositos creado con éxito");
            } else {
                vHist.jopMensaje.showMessageDialog(vHist, "Error, seleccionar una cuenta con depositos registrados");
            }
        }
        if (e.getSource() == vHist.btnRetiros) {
            if (!vHist.txtCui.getText().equals("")) {
                System.out.println("Retiros - Reporte");
                reporte.retirosHtml(retiros, vHist);
                vHist.jopMensaje.showMessageDialog(vHist, "Reporte de Retiros creado con éxito");
            } else {
                vHist.jopMensaje.showMessageDialog(vHist, "Error, seleccionar una cuenta con retiros registrados");
            }
            
        }
        
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
    }
    
    @Override
    public void windowClosed(WindowEvent e) {
    }
    
    @Override
    public void windowIconified(WindowEvent e) {
    }
    
    @Override
    public void windowDeiconified(WindowEvent e) {
    }
    
    @Override
    public void windowActivated(WindowEvent e) {
    }
    
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
