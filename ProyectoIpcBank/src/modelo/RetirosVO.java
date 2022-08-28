
package modelo;

public class RetirosVO {
private String nombre; 
private String cui;
private int cuenta;
private double saldoI;
private double saldoF;
private double temporal;
private String fecha;

    public RetirosVO(String nombre, String cui, int cuenta, double saldoI, double saldoF, String fecha) {
        this.nombre = nombre;
        this.cui = cui;
        this.cuenta = cuenta;
        this.saldoI = saldoI;
        this.saldoF = saldoF;
        this.fecha = fecha;
    }

    public RetirosVO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public double getSaldoI() {
        return saldoI;
    }

    public void setSaldoI(double saldoI) {
        this.saldoI = saldoI;
    }

    public double getSaldoF() {
        return saldoF;
    }

    public void setSaldoF(double saldoF) {
        this.saldoF = saldoF;
    }

    public double getTemporal() {
        return temporal;
    }

    public void setTemporal(double temporal) {
        this.temporal = temporal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }



}
