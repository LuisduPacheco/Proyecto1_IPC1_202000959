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
        cuentas[temp] = new CuentaVO(cuenta.getNombreC(), cuenta.getCuiC(), cuenta.getSaldoC(), cuenta.getIdCuenta(), cuenta.getFecha());
        return true;

    }

    public boolean actualizar(CuentaVO cuenta, CuentaVO[] cuentas, int position) {
        System.out.println("Actualizando cuentas");
        int temp = -1;
        for (int i = 0; i < cuentas.length; i++) {
            if (i == position) {
                temp = i;
                break;
            }
        }

        cuentas[temp] = new CuentaVO(cuenta.getNombreC(), cuenta.getCuiC(), cuenta.getSaldoC(), cuenta.getIdCuenta(), cuenta.getFecha());
        return true;

    }

    //Inserta los valores de una transacción
    public boolean insertar(TransaccionVO tr, TransaccionVO[] transaccion) {
        System.out.println("TRANSACCIONES");
        int temp = -1;
        for (int i = 0; i < transaccion.length; i++) {
            if (transaccion[i] == null) {
                temp = i;
                break;
            }
        }
        tr.setContador(tr.getContador() + 1);
        transaccion[temp] = new TransaccionVO(tr.getContador(), tr.getNombreC(), tr.getCuiC(), tr.getMonto(), tr.getIdCuenta(), tr.getTransaccion(), tr.getFecha());
        return true;

    }

    public boolean insertarRetiros(RetirosVO rvo, RetirosVO[] retiros) {
        System.out.println("RETIROS");
        int temp = -1;
        for (int i = 0; i < retiros.length; i++) {
            if (retiros[i] == null) {
                temp = i;
                break;
            }
        }
        rvo.setContador(rvo.getContador() + 1);
        retiros[temp] = new RetirosVO(rvo.getContador(), rvo.getNombreC(), rvo.getCuiC(), rvo.getIdCuenta(), rvo.getSaldoI(), rvo.getSaldoF(), rvo.getMotivo(), rvo.getFecha());
        return true;

    }

    public boolean insertarDepositos(DepositosVO dvo, DepositosVO[] depositos) {
        System.out.println("Depositos");
        int temp = -1;
        for (int i = 0; i < depositos.length; i++) {
            if (depositos[i] == null) {
                temp = i;
                break;
            }
        }
        dvo.setContador(dvo.getContador() + 1);
        depositos[temp] = new DepositosVO(dvo.getContador(), dvo.getNombreC(), dvo.getCuiC(), dvo.getIdCuenta(), dvo.getSaldoI(), dvo.getSaldoF(), dvo.getMotivo(), dvo.getFecha());
        return true;
    }

    //PARA IMPRIMIR LOS ARREGLOS
    public void imprimir(CuentaVO[] cuentas) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null) {
                System.out.println("Nombre: " + cuentas[i].getNombreC() + " CUI: " + cuentas[i].getCuiC() + " Saldo: " + cuentas[i].getSaldoC()
                        + " ID cuetna: " + cuentas[i].getIdCuenta() + " Fecha: " + cuentas[i].getFecha());
            }
        }
    }

    public void imprimirT(TransaccionVO[] transaccion) {
        for (int i = 0; i < transaccion.length; i++) {
            if (transaccion[i] != null) {
                System.out.println("No. Transacción: " + transaccion[i].getContador() + " Nombre: " + transaccion[i].getNombreC() + " CUI: " + transaccion[i].getCuiC() + "Monto: " + transaccion[i].getMonto() + " Transaccion: " + transaccion[i].getTransaccion()
                        + " ID cuenta: " + transaccion[i].getIdCuenta() + " Fecha: " + transaccion[i].getFecha());
            }
        }
    }

    public void imprimirRetiros(RetirosVO[] retiros) {
        for (int i = 0; i < retiros.length; i++) {
            if (retiros[i] != null) {
                System.out.println("No. Retiro" + retiros[i].getContador() + "Nombre: " + retiros[i].getNombreC() + " CUI: " + retiros[i].getCuiC() + " ID Cuenta: " + retiros[i].getIdCuenta()
                        + " Saldo I: " + retiros[i].getSaldoI() + " Saldo F: " + retiros[i].getSaldoF() + " Transacción: " + retiros[i].getMotivo() + " Fecha: " + retiros[i].getFecha());
            }
        }
    }

    public void imprimirDepositos(DepositosVO[] depositos) {
        for (int i = 0; i < depositos.length; i++) {
            if (depositos[i] != null) {
                System.out.println("No. Deposito" + depositos[i].getContador() + "Nombre: " + depositos[i].getNombreC() + " CUI: " + depositos[i].getCuiC() + " ID Cuenta: " + depositos[i].getIdCuenta()
                        + " Saldo I: " + depositos[i].getSaldoI() + " Saldo F: " + depositos[i].getSaldoF() + " Transacción: " + depositos[i].getMotivo() + " Fecha: " + depositos[i].getFecha());
            }
        }
    }

}
