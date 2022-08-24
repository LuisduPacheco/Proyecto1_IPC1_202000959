package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmMenu;
import vista.FrmRegistroU;

public class contUsuario implements ActionListener, WindowListener {

    //Objetos
    FrmRegistroU vReg = new FrmRegistroU();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO usuarios[] = new UsuarioVO[5];

    //Constructor
    public contUsuario(FrmRegistroU vReg, UsuarioVO uvo, UsuarioDAO udao, UsuarioVO usuarios[]) {
        this.vReg = vReg;
        this.uvo = uvo;
        this.udao = udao;
        this.usuarios = usuarios;
        vReg.btnRegistrar.addActionListener(this);
        vReg.addWindowListener(this);
    }

    public void setDatos() {
        uvo.setCui(vReg.txtCui.getText());
        uvo.setNombre(vReg.txtNombre.getText());
        uvo.setApellido(vReg.txtApellido.getText());

    }

    public void registrarU(UsuarioVO[] usuarioU) {
        this.setDatos();
        udao.buscar(vReg.txtCui.getText(), usuarioU);
        uvo.setContador(uvo.getContador() + 1);
        UsuarioVO usuario = new UsuarioVO(uvo.getCui(), uvo.getNombre(), uvo.getApellido());
        udao.insertar(usuario, usuarioU);       
        udao.imprimir(usuarioU);

    }

    //VALIDAR QUE TODOS LOS CAMPOS ESTÉN LLENOS
    public boolean camposLlenos() {
        if (!vReg.txtCui.getText().isEmpty()
                && !vReg.txtNombre.getText().isEmpty()
                && !vReg.txtApellido.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //VACIAR LOS CAMPOS DESPUÉS DE HABER CREADO UN USUARIO.
    public void vaciarCampos() {
        vReg.txtApellido.setText("");
        vReg.txtCui.setText("");
        vReg.txtNombre.setText("");
    }

    public boolean validaContador() {
        if (uvo.getContador() < 5) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vReg.btnRegistrar) {

            if (this.validaContador() == true) {
                if (this.camposLlenos() == true) {
                    this.setDatos();
                    this.registrarU(this.usuarios);
                    vReg.jopMensaje.showMessageDialog(vReg, "Usuario: " + uvo.getNombre() + " " + uvo.getApellido() + ", registrado con éxito.");
                    System.out.println("Contador Usuarios"+uvo.getContador());
                    this.vaciarCampos();

                } else {
                    vReg.jopMensaje.showMessageDialog(vReg, "Llene todos los campos");
                }
            } else {
                vReg.jopMensaje.showMessageDialog(vReg, "Usuario no creado. Cantidad máxima, 5 usuarios.");
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
        this.vaciarCampos();
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
