
package proyectoipcbank;

import controlador.contCuentas;
import controlador.contMenu;
import controlador.contUsuario;
import modelo.CuentaDAO;
import modelo.CuentaVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmCuentas;
import vista.FrmMenu;
import vista.FrmRegistroU;

public class ProyectoIpcBank {

    public static void main(String[] args) {
       
        //Arreglo global
        UsuarioVO usuarios[] = new UsuarioVO[5];
        CuentaVO cuentas[] = new CuentaVO[10];
        
        //Objetos
        FrmMenu vMnu = new FrmMenu();
        FrmRegistroU vReg = new FrmRegistroU();
        FrmCuentas vCta = new FrmCuentas();
        
        //Modelo
        UsuarioVO uvo = new UsuarioVO();
        UsuarioDAO udao = new UsuarioDAO();
        CuentaVO cvo = new CuentaVO();
        CuentaDAO cdao = new CuentaDAO();
        
        //Controladores
        contMenu cMnu = new contMenu(vMnu, vReg, vCta);
        contUsuario cUsu = new contUsuario(vReg, uvo, udao, usuarios);
        contCuentas cCu = new contCuentas(vCta, usuarios, cuentas, cvo, cdao);
        
        //Ventanas
        vMnu.setVisible(true);
        vMnu.setLocationRelativeTo(null);
        vMnu.setResizable(false);
        
        
    }
    
}
