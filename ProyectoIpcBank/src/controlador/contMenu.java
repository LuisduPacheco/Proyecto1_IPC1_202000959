
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmCuentas;
import vista.FrmMenu;
import vista.FrmRegistroU;

public class contMenu implements ActionListener {
    //Objetos de las ventanas principales
    FrmMenu vMnu = new FrmMenu();
    FrmRegistroU vReg = new FrmRegistroU();
    FrmCuentas vCta = new FrmCuentas();

    public contMenu(FrmMenu vMnu,FrmRegistroU vReg,FrmCuentas vCta) {
        this.vMnu = vMnu;
        this.vReg = vReg;
        this.vCta = vCta;
        
        vMnu.btnCuentas.addActionListener(this);
        vMnu.btnDepostos.addActionListener(this);
        vMnu.btnRegistro.addActionListener(this);
        vMnu.btnReportes.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vMnu.btnRegistro){
            vReg.setLocationRelativeTo(vMnu);
            vReg.setVisible(true);
            vReg.setResizable(true);
        }
        if(e.getSource() == vMnu.btnCuentas){
            vCta.setLocationRelativeTo(vMnu);
            vCta.setVisible(true);
            vCta.setResizable(false);
            
        }
        
        
        
    }
    
}
