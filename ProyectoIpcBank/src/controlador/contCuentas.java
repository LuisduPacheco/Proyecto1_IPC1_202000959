package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.CuentaDAO;
import modelo.CuentaVO;
import modelo.UsuarioVO;
import vista.FrmCuentas;

public class contCuentas implements ActionListener, WindowListener, MouseListener {

    FrmCuentas vCta = new FrmCuentas();
    UsuarioVO usuarios[] = new UsuarioVO[5];
    CuentaVO cuentas [] = new CuentaVO[10];
    CuentaVO cvo = new CuentaVO(); 
    CuentaDAO cdao = new CuentaDAO();
    
    
    public contCuentas(FrmCuentas vCta,UsuarioVO usuarios[], CuentaVO cuentas [], CuentaVO cvo, CuentaDAO cdao) {
        this.vCta = vCta;
        this.usuarios = usuarios;
        this.cuentas = cuentas;
        this.cvo = cvo;
        this.cdao = cdao;
        
        vCta.btnCrear.addActionListener(this);
        vCta.tblUsuarios.addMouseListener(this);
        vCta.addWindowListener(this);

    }

    //MÉTODO QUE MUESTRA EL CONTENIDO DE LA TABLA
    private void mostrar() {
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
       
        for(int i=0; i<usuarios.length; i++){
            if(usuarios[i]!= null){
                m.addRow(new Object[]{usuarios[i].getCui(), usuarios[i].getNombre(), usuarios[i].getApellido()});
            }
        }
         vCta.tblUsuarios.setModel(m);

    }
    
    //Método para llenar los cuadros de texto
    private void setDatosCuenta(){
    
    //Usando getSelectedRow
    int numRow;
    numRow = vCta.tblUsuarios.getSelectedRow();
    vCta.txtCui.setText(String.valueOf(vCta.tblUsuarios.getValueAt(numRow, 0)));
    vCta.txtNombreU.setText(String.valueOf(vCta.tblUsuarios.getValueAt(numRow, 1)));
    vCta.txtApellidoU.setText(String.valueOf(vCta.tblUsuarios.getValueAt(numRow, 2)));
    
    //Agregando el id de la cuenta
    vCta.txtNoCuenta.setText(String.valueOf(cvo.getIdCuenta()));
    vCta.txtSaldo.setText("0.00");
    }
    
    //METODO PARA SETEAR LOS DATOS DE LA CUENTA
    private void setDatos(){
        cvo.setCuiC(vCta.txtCui.getText());
        cvo.setNombreC(vCta.txtNombreU.getText());
        cvo.setIdCuenta(Integer.parseInt(vCta.txtNoCuenta.getText()));
        cvo.setSaldoC(Double.parseDouble(vCta.txtSaldo.getText()));
        
        cdao.insertar(cvo, cuentas);
        cdao.imprimir(cuentas);        
    }
    
    public void vaciarCampos(){
        vCta.txtCui.setText("");
        vCta.txtApellidoU.setText("");
        vCta.txtNoCuenta.setText("");
        vCta.txtNombreU.setText("");
        vCta.txtSaldo.setText("");
    }
    
    
    

    //Métodos a sobreescribir
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vCta.btnCrear) {
            if(!vCta.txtCui.getText().equals("")){
                this.setDatos();
                vCta.jopMensaje.showMessageDialog(vCta, "Cuenta No. "+cvo.getIdCuenta()+", Nombre: "+cvo.getNombreC()+", creada con éxito ");
                cvo.setIdCuenta(cvo.getIdCuenta()+1);
                this.vaciarCampos();
                
            }else{
                vCta.jopMensaje.showMessageDialog(vCta, "La cuenta debe asociarse a un CUI existente.");
                System.out.println("La cuenta debe asociarse a un usuario");
            }
            
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.vaciarCampos();
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
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            this.setDatosCuenta();
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
