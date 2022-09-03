
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmCuentas;
import vista.FrmHistorial;
import vista.FrmMenu;
import vista.FrmRegistroU;
import vista.FrmReportes;

import vista.FrmRetirosD;

public class contMenu implements ActionListener {
    //Objetos de las ventanas principales
    FrmMenu vMnu = new FrmMenu();
    FrmRegistroU vReg = new FrmRegistroU();
    FrmCuentas vCta = new FrmCuentas();
    FrmRetirosD vRet = new FrmRetirosD();
    FrmReportes vRep = new FrmReportes();
    FrmHistorial vHist = new FrmHistorial();
    

    public contMenu(FrmMenu vMnu,FrmRegistroU vReg,FrmCuentas vCta,FrmRetirosD vRet,FrmReportes vRep,FrmHistorial vHist) {
        this.vMnu = vMnu;
        this.vReg = vReg;
        this.vCta = vCta;
        this.vRet = vRet;
        this.vRep = vRep;
        this.vHist = vHist;
        
        vMnu.btnCuentas.addActionListener(this);
        vMnu.btnDepostos.addActionListener(this);
        vMnu.btnRegistro.addActionListener(this);
        vMnu.btnReportes.addActionListener(this);
        vMnu.btnTransacciones.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vMnu.btnRegistro){
            vReg.setLocationRelativeTo(vMnu);
            vReg.setVisible(true);
            vReg.setResizable(false);
        }
        if(e.getSource() == vMnu.btnCuentas){
            vCta.setLocationRelativeTo(vMnu);
            vCta.setVisible(true);
            vCta.setResizable(false);    
        }
        if(e.getSource() == vMnu.btnDepostos){
            vRet.setLocationRelativeTo(vMnu);
            vRet.setVisible(true);
            vRet.setResizable(false);
           
        }
        if(e.getSource()== vMnu.btnReportes){
            vRep.setLocationRelativeTo(vMnu);
            vRep.setVisible(true);
            vRep.setResizable(false);
        }
        if(e.getSource() == vMnu.btnTransacciones){
            vHist.setLocationRelativeTo(vMnu);
            vHist.setVisible(true);
            vHist.setResizable(false);
        }
        
        
    }
    
}
