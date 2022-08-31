package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.CuentaDAO;
import modelo.CuentaVO;
import modelo.DepositosVO;
import modelo.Extras;
import modelo.RetirosVO;
import modelo.TransaccionVO;
import vista.FrmRetirosD;

public class contRetiros implements ActionListener, WindowListener, MouseListener {

    FrmRetirosD vRet = new FrmRetirosD();
    CuentaDAO cdao = new CuentaDAO();
    CuentaVO cuentas[] = new CuentaVO[10];
    CuentaVO cvo = new CuentaVO();
    TransaccionVO tvo = new TransaccionVO();
    TransaccionVO transaccion [] = new TransaccionVO[20];
    RetirosVO rvo = new RetirosVO();
    RetirosVO [] retiros = new RetirosVO[20];
    DepositosVO dvo = new DepositosVO();
    DepositosVO []depositos = new DepositosVO[20];

    public contRetiros(FrmRetirosD vRet, CuentaDAO cdao, CuentaVO cuentas[], CuentaVO cvo,TransaccionVO transaccion [],TransaccionVO 
            tvo,RetirosVO rvo, RetirosVO [] retiros, DepositosVO dvo, DepositosVO []depositos) {
        this.cuentas = cuentas;
        this.cvo = cvo;
        this.cdao = cdao;
        this.vRet = vRet;
        this.transaccion = transaccion;
        this.tvo = tvo;
        this.rvo = rvo;
        this.retiros = retiros;
        this.dvo = dvo;
        this.depositos = depositos;

        vRet.addWindowListener(this);
        vRet.tblCuentas.addMouseListener(this);
        vRet.btnDeposito.addActionListener(this);
        vRet.btnRetiro.addActionListener(this);
        vRet.btnCancelar.addActionListener(this);
    }

    //Método que muestra el contenido de la tabla
    private void mostrar() {
        int posicion = -1;
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

                m.addRow(new Object[]{cuentas[i].getIdCuenta(), cuentas[i].getCuiC(), cuentas[i].getNombreC(), (cuentas[i].getSaldoC())});
            }

        }
        vRet.tblCuentas.setModel(m);

    }

    //Método para llenar los cuadros de texto
    private int setDatosRetiroD() {
        int numRow;
        int posicion = -1;
        numRow = vRet.tblCuentas.getSelectedRow();
        vRet.txtCuenta.setText(String.valueOf(vRet.tblCuentas.getValueAt(numRow, 0)));
        vRet.txtCui.setText(String.valueOf(vRet.tblCuentas.getValueAt(numRow, 1)));
        vRet.txtNombre.setText(String.valueOf(vRet.tblCuentas.getValueAt(numRow, 2)));
        vRet.txtSaldoActual.setText(String.valueOf(vRet.tblCuentas.getValueAt(numRow, 3)));
        posicion = numRow;
        return posicion;
    }

    private void depositosCuenta() {
        //Depositos
        cvo.setCuiC(vRet.txtCui.getText());
        cvo.setIdCuenta(Integer.parseInt(vRet.txtCuenta.getText()));
        cvo.setNombreC(vRet.txtNombre.getText());
        cvo.setSaldoC((Double.parseDouble(vRet.txtSaldoActual.getText()) + Double.parseDouble(vRet.txtMonto.getText())));
        cvo.setFecha(Extras.fechaHoy());
        
        //Transacciones
        tvo.setCuiC(vRet.txtCui.getText());
        tvo.setIdCuenta(Integer.parseInt(vRet.txtCuenta.getText()));
        tvo.setNombreC(vRet.txtNombre.getText());
        tvo.setMonto(Double.parseDouble(vRet.txtMonto.getText()));
        tvo.setFecha(Extras.fechaHoy());
        tvo.setTransaccion("Deposito");
        
        dvo.setCuiC(vRet.txtCui.getText());
        dvo.setIdCuenta(Integer.parseInt(vRet.txtCuenta.getText()));
        dvo.setNombreC(vRet.txtNombre.getText());
        dvo.setSaldoI(Double.parseDouble(vRet.txtSaldoActual.getText()));
        dvo.setSaldoF(Double.parseDouble(vRet.txtSaldoActual.getText())+Double.parseDouble(vRet.txtMonto.getText()));
        dvo.setFecha(Extras.fechaHoy());
        dvo.setMotivo("Deposito");
        
        cdao.actualizar(cvo, cuentas, this.setDatosRetiroD());
        cdao.insertar(tvo, transaccion);
        cdao.insertarDepositos(dvo, depositos);
        
        cdao.imprimir(cuentas);
        cdao.imprimirT(transaccion);
        cdao.imprimirDepositos(depositos);
    }

    private void retirosCuenta() {
       //Retiros
        cvo.setCuiC(vRet.txtCui.getText());
        cvo.setIdCuenta(Integer.parseInt(vRet.txtCuenta.getText()));
        cvo.setNombreC(vRet.txtNombre.getText());
        cvo.setSaldoC((Double.parseDouble(vRet.txtSaldoActual.getText()) - Double.parseDouble(vRet.txtMonto.getText())));
        cvo.setFecha(Extras.fechaHoy());
        
        //Transacciones
        tvo.setCuiC(vRet.txtCui.getText());
        tvo.setIdCuenta(Integer.parseInt(vRet.txtCuenta.getText()));
        tvo.setNombreC(vRet.txtNombre.getText());
        tvo.setMonto(Double.parseDouble(vRet.txtMonto.getText()));
        tvo.setFecha(Extras.fechaHoy());
        tvo.setTransaccion("Retiro");
        
        rvo.setCuiC(vRet.txtCui.getText());
        rvo.setIdCuenta(Integer.parseInt(vRet.txtCuenta.getText()));
        rvo.setNombreC(vRet.txtNombre.getText());
        rvo.setSaldoI(Double.parseDouble(vRet.txtSaldoActual.getText()));
        rvo.setSaldoF(Double.parseDouble(vRet.txtSaldoActual.getText())-Double.parseDouble(vRet.txtMonto.getText()));
        rvo.setFecha(Extras.fechaHoy());
        rvo.setMotivo("Retiro");
        
        cdao.actualizar(cvo, cuentas, this.setDatosRetiroD());
        cdao.insertar(tvo, transaccion);
        cdao.insertarRetiros(rvo, retiros);
        cdao.imprimir(cuentas);
        cdao.imprimirT(transaccion);
        cdao.imprimirRetiros(retiros);
        
    }
    
    
    private void vaciarCampos() {
        vRet.txtCuenta.setText("");
        vRet.txtCui.setText("");
        vRet.txtMonto.setText("");
        vRet.txtNombre.setText("");
        vRet.txtSaldoActual.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vRet.btnDeposito) {
            if (!vRet.txtCui.getText().equals("") && !vRet.txtMonto.getText().equals("")) {
                if (Double.parseDouble(vRet.txtMonto.getText()) > 0) {
                    this.depositosCuenta();
                    this.vaciarCampos();
                    this.mostrar();
                    vRet.jopMensaje.showMessageDialog(vRet, "Depósito realizado con éxito");
                } else {
                    vRet.jopMensaje.showMessageDialog(vRet, "No realizado, Depositos mayores a 0");
                }
            } else {
                vRet.jopMensaje.showMessageDialog(vRet, "Las operaciones requieren un usuario y un monto para realizarlas");
            }
        }
        if (e.getSource() == vRet.btnRetiro) {
            if (!vRet.txtCui.getText().equals("") && !vRet.txtMonto.getText().equals("")) {
                if (Double.parseDouble(vRet.txtMonto.getText()) > 0) {
                    if (Double.parseDouble(vRet.txtMonto.getText()) < Double.parseDouble(vRet.txtSaldoActual.getText())) {
                        this.retirosCuenta();
                        this.vaciarCampos();
                        this.mostrar();
                        vRet.jopMensaje.showMessageDialog(vRet, "Retiro realizado con éxito");
                    } else {
                        vRet.jopMensaje.showMessageDialog(vRet, "No se pueden hacer retiros mayores al saldo actual: " + vRet.txtSaldoActual.getText());
                    }
                } else {
                    vRet.jopMensaje.showMessageDialog(vRet, "No realizado, Retiros mayores a 0");
                }
            } else {
                vRet.jopMensaje.showMessageDialog(vRet, "Las operaciones requieren un usuario y un monto para realizarlas");
            }
        }
        if (e.getSource() == vRet.btnCancelar) {
            this.vaciarCampos();
            vRet.jopMensaje.showMessageDialog(vRet, "Cancelado, seleccione otra cuenta");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
        System.out.println("Depositos y Retiros");
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
