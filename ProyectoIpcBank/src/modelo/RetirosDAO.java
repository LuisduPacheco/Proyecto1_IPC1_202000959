
package modelo;

public class RetirosDAO {
    
    

    public boolean insertar(RetirosVO retiro, RetirosVO[] retiros){
        System.out.println("Insertando al historial de retiros");
        int temp = -1;
        for(int i=0; i<retiros.length; i++){
            if(retiros[i]==null){
            temp = i;
            break;
            }
        }
        retiros[temp]= new RetirosVO(retiro.getNombre(), retiro.getCui(), retiro.getCuenta(), retiro.getSaldoI(), retiro.getSaldoF(), retiro.getFecha());
        
        return true;
    }
    
    public void imprimir(RetirosVO[] retiros){
        for(int i=0; i<retiros.length; i++){
            if(retiros[i]!=null){
                System.out.println("Nombre: "+retiros[i].getNombre()+" CUI: "+retiros[i].getCui()+" Cuenta: "+retiros[i].getCuenta()+
                                    "Saldo Inicial: "+retiros[i].getSaldoI()+" Saldo Actual: "+retiros[i].getSaldoF()+" Fecha: "+retiros[i].getFecha());
            }
        }
    }
    
//    public void setCuenta(CuentaVO cuenta, CuentaVO[] cuentas, RetirosVO retiro){
//        cuentas[temp]= new CuentaVO(cuenta.setNombre(retiro.getNombre()),cuenta.setCuiC(retiro.getCui()),cuenta.setSaldoC(retiro.getSaldoF()),cuenta.setIdCuenta(retiro.getCuenta()));
//    }

    
}
