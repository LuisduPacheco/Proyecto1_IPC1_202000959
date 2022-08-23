
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmMenu;
import vista.FrmRegistroU;

public class contUsuario implements ActionListener {

    //Objetos
    FrmRegistroU vReg = new FrmRegistroU();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO usuarios[] = new UsuarioVO[5];

    //Constructor
    public contUsuario(FrmRegistroU vReg, UsuarioVO uvo, UsuarioDAO udao,UsuarioVO usuarios[] ) {
        this.vReg = vReg;
        this.uvo = uvo;
        this.udao = udao;
        this.usuarios = usuarios;
        vReg.btnRegistrar.addActionListener(this);
    }
    
    public void setDatos(){
        uvo.setCui(vReg.txtCui.getText());
        uvo.setNombre(vReg.txtNombre.getText());
        uvo.setApellido(vReg.txtApellido.getText());
        
    }
    
    public void registrarU(UsuarioVO[] usuarioU){
        this.setDatos();
        udao.buscar(vReg.txtCui.getText(), usuarioU);
        if (!vReg.txtCui.getText().isEmpty() && 
                !vReg.txtNombre.getText().isEmpty() && 
                !vReg.txtApellido.getText().isEmpty()){
        UsuarioVO usuario = new UsuarioVO(uvo.getCui(), uvo.getNombre(), uvo.getApellido());
        udao.insertar(usuario, usuarioU);
        udao.imprimir(usuarioU);
        }else {
            vReg.jopMensaje.showMessageDialog(vReg, "Llene todos los campos");
        }
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vReg.btnRegistrar){
            this.setDatos();            
            this.registrarU(this.usuarios);
            vReg.dispose();
        }
        
    }
  
    
}
