
package modelo;


public class DepositosDAO {

    public boolean insertar(DepositosVO deposito, DepositosVO[] depositos){
        System.out.println("Insertando al historial de retiros");
        int temp = -1;
        for(int i=0; i<depositos.length; i++){
            if(depositos[i]==null){
            temp = i;
            break;
            }
        }
        depositos[temp]= new DepositosVO(deposito.getNombre(), deposito.getCui(), deposito.getCuenta(), deposito.getSaldoI(), deposito.getSaldoF(), deposito.getFecha());
        
        return true;
    }
    
    public void imprimir(DepositosVO[] depositos){
        for(int i=0; i<depositos.length; i++){
            if(depositos[i]!=null){
                System.out.println("Nombre: "+depositos[i].getNombre()+" CUI: "+depositos[i].getCui()+" Cuenta: "+depositos[i].getCuenta()+
                                    "Saldo Inicial: "+depositos[i].getSaldoI()+" Saldo Actual: "+depositos[i].getSaldoF()+" Fecha: "+depositos[i].getFecha());
            }
        }
    }
    
}
