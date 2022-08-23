
package modelo;

public class CuentaDAO {

    public boolean insertar(CuentaVO cuenta, CuentaVO[] cuentas){
        System.out.println("Insertando cuentas");
        int temp =-1;
        for(int i=0; i<cuentas.length; i++){
            if(cuentas[i]==null){
            temp=i;
            break;
            }
        }
        cuentas[temp]= new CuentaVO(cuenta.getNombreC(), cuenta.getCuiC(), cuenta.getSaldoC(), cuenta.getIdCuenta());
        return true;
       
    }
    
     public void imprimir(CuentaVO[] cuentas) {
        for (int i = 0; i < cuentas.length; i++) {            
            if(cuentas[i] != null ) System.out.println("Nombre: "+cuentas[i].getNombreC()+" CUI: "+cuentas[i].getCuiC()+" Saldo: "+cuentas[i].getSaldoC()+" ID cuetna: "+cuentas[i].getIdCuenta());
        }       
    }
    
   
    
    /*public boolean insertar(UsuarioVO usuario, UsuarioVO[] usuarioU) {
        if (buscar(usuario.getCui(), usuarioU) == -1) {
            System.out.println("Insertando usuario");
            int temp =-1;
            for(int i=0; i<usuarioU.length; i++){
                if(usuarioU[i] == null){
                    temp = i;
                    break; //Rompe el ciclo y no sigue iterando
                }
            }
            usuarioU[temp] = new UsuarioVO(usuario.getCui(), usuario.getNombre(), usuario.getApellido());
            
            return true;
        } else {
            System.out.println("El usuario con CUI: " + usuario.getCui() + " ya existe");
            return false;
        }
    }*/

    
}
