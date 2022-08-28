package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.CuentaVO;
import modelo.DepositosDAO;
import modelo.DepositosVO;
import modelo.Extras;
import modelo.RetirosDAO;
import modelo.RetirosVO;
import vista.FrmRetirosD;

public class contRetiros implements ActionListener, WindowListener, MouseListener {

    FrmRetirosD vRet = new FrmRetirosD();
    CuentaVO cuentas[] = new CuentaVO[10];
    CuentaVO cvo = new CuentaVO();
    RetirosVO retiros[] = new RetirosVO[10];
    RetirosVO rvo = new RetirosVO();
    RetirosDAO rdao = new RetirosDAO();
    DepositosVO depositos[] = new DepositosVO[10];
    DepositosVO dvo = new DepositosVO();
    DepositosDAO ddao = new DepositosDAO();

    public contRetiros(FrmRetirosD vRet, CuentaVO cuentas[], CuentaVO cvo, RetirosVO retiros[], RetirosVO rvo, RetirosDAO rdao,
            DepositosVO depositos[], DepositosVO dvo, DepositosDAO ddao) {
        this.cuentas = cuentas;
        this.cvo = cvo;
        this.vRet = vRet;
        this.retiros = retiros;
        this.rvo = rvo;
        this.rdao = rdao;
        this.depositos = depositos;
        this.dvo = dvo;
        this.ddao = ddao;

        vRet.addWindowListener(this);
        vRet.tblCuentas.addMouseListener(this);
        vRet.btnDeposito.addActionListener(this);
        vRet.btnRetiro.addActionListener(this);
        vRet.btnCancelar.addActionListener(this);
    }

    //Método que muestra el contenido de la tabla
    private void mostrar() {
        DefaultTableModel m = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("No. Cuenta");
        m.addColumn("CUI usuario");
        m.addColumn("Nombre");
        m.addColumn("Saldo");

        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null) {
               
                m.addRow(new Object[]{cuentas[i].getIdCuenta(), cuentas[i].getCuiC(), cuentas[i].getNombreC(),(cuentas[i].getSaldoC())});
            }
        }
        vRet.tblCuentas.setModel(m);
    }

    //Método para llenar los cuadros de texto
    private void setDatosRetiroD() {
        int numRow;
        numRow = vRet.tblCuentas.getSelectedRow();
        vRet.txtCuenta.setText(String.valueOf(vRet.tblCuentas.getValueAt(numRow, 0)));
        vRet.txtCui.setText(String.valueOf(vRet.tblCuentas.getValueAt(numRow, 1)));
        vRet.txtNombre.setText(String.valueOf(vRet.tblCuentas.getValueAt(numRow, 2)));
        vRet.txtSaldoActual.setText(String.valueOf(vRet.tblCuentas.getValueAt(numRow, 3)));
    }

    //Método para setear los datos de Retiro 
    private void setDatosDeposito() {

        dvo.setCuenta(Integer.parseInt(vRet.txtCuenta.getText()));
        dvo.setCui(vRet.txtCui.getText());
        dvo.setNombre(vRet.txtNombre.getText());
        dvo.setSaldoI(Double.parseDouble(vRet.txtSaldoActual.getText()));
        dvo.setSaldoF(Double.parseDouble(vRet.txtSaldoActual.getText()) + Double.parseDouble(vRet.txtMonto.getText()));
        
        dvo.setFecha(Extras.fechaHoy());
        if (dvo.getSaldoF() > 0) {
            ddao.insertar(dvo, depositos);
            ddao.imprimir(depositos);
            //dvo.setTemporal(Double.parseDouble(vRet.txtMonto.getText()));
        } else {
            System.out.println("Error");
            ddao.imprimir(depositos);
        }
    }
    
    private void vaciarCampos(){
        vRet.txtCuenta.setText("");
        vRet.txtCui.setText("");
        vRet.txtMonto.setText("");
        vRet.txtNombre.setText("");
        vRet.txtSaldoActual.setText("");
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vRet.btnDeposito){
        this.setDatosDeposito();
        this.vaciarCampos();
        this.mostrar();
        
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
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
        this.mostrar();
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            this.setDatosRetiroD();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
