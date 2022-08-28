package modelo;

public class CuentaDAO {

    public boolean insertar(CuentaVO cuenta, CuentaVO[] cuentas) {
        System.out.println("Insertando cuentas");
        int temp = -1;
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                temp = i;
                break;
            }
        }
        cuentas[temp] = new CuentaVO(cuenta.getNombreC(), cuenta.getCuiC(), cuenta.getSaldoC(), cuenta.getIdCuenta());
        return true;

    }

    public boolean actualizar(CuentaVO cuenta, CuentaVO[] cuentas, int position) {
    System.out.println("Actualizando cuentas");
        int temp = -1;
        for (int i = 0; i < cuentas.length; i++) {
            if (i == position ) {
                temp = i;
                break;
            }
        }
        
        cuentas[temp] = new CuentaVO(cuenta.getNombreC(), cuenta.getCuiC(), cuenta.getSaldoC(), cuenta.getIdCuenta());
        return true;
       
    }

    public void imprimir(CuentaVO[] cuentas) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null) {
                System.out.println("Nombre: " + cuentas[i].getNombreC() + " CUI: " + cuentas[i].getCuiC() + " Saldo: " + cuentas[i].getSaldoC() + " ID cuetna: " + cuentas[i].getIdCuenta());
            }
        }
    }

}
