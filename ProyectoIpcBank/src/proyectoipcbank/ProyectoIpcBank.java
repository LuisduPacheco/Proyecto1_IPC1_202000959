
package proyectoipcbank;

import ReportesPDF.ReporteUsuarios;
import controlador.contCuentas;
import controlador.contHistorial;
import controlador.contMenu;
import controlador.contReportes;

import controlador.contRetiros;
import controlador.contUsuario;
import modelo.CuentaDAO;
import modelo.CuentaVO;
import modelo.DepositosVO;
import modelo.RetirosVO;
import modelo.TransaccionVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmCuentas;
import vista.FrmHistorial;
import vista.FrmMenu;
import vista.FrmRegistroU;
import vista.FrmReportes;
import vista.FrmRetirosD;

public class ProyectoIpcBank {

    public static void main(String[] args) {
       
        //Arreglo global
        UsuarioVO usuarios[] = new UsuarioVO[5];
        CuentaVO cuentas[] = new CuentaVO[10];
        TransaccionVO transacciones [] = new TransaccionVO[20];
        RetirosVO [] retiros = new RetirosVO[20];
        DepositosVO [] depositos = new DepositosVO[20];
        //Objetos
        FrmMenu vMnu = new FrmMenu();
        FrmRegistroU vReg = new FrmRegistroU();
        FrmCuentas vCta = new FrmCuentas();
        FrmRetirosD vRet = new FrmRetirosD();
        FrmReportes vRep = new FrmReportes();
        FrmHistorial vHist = new FrmHistorial();
        
        //REPORTE
        ReporteUsuarios reporte = new ReporteUsuarios();
        
        
        //Modelo
        UsuarioVO uvo = new UsuarioVO();
        UsuarioDAO udao = new UsuarioDAO();
        CuentaVO cvo = new CuentaVO();
        CuentaDAO cdao = new CuentaDAO();
        TransaccionVO tvo = new TransaccionVO();
        RetirosVO rvo = new RetirosVO();
        DepositosVO dvo = new DepositosVO();
        
        
        //Controladores
        contMenu cMnu = new contMenu(vMnu, vReg, vCta, vRet, vRep, vHist);
        contUsuario cUsu = new contUsuario(vReg, uvo, udao, usuarios);
        contCuentas cCu = new contCuentas(vCta, usuarios, cuentas, cvo, cdao);
        contRetiros cRet = new contRetiros(vRet, cdao, cuentas, cvo, transacciones, tvo, rvo, retiros, dvo, depositos);
        contReportes cRep = new contReportes(vRep, usuarios, cuentas, reporte);
        contHistorial cHist = new contHistorial(vHist, cuentas, transacciones);
        
        
        
        
        //Ventanas
        vMnu.setVisible(true);
        vMnu.setLocationRelativeTo(null);
        vMnu.setResizable(false);
    }
    
}
