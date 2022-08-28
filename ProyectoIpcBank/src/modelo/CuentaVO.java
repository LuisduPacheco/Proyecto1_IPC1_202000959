package modelo;

public class CuentaVO {
    private String nombreC;
    private String cuiC;
    private double saldoC;
    private int idCuenta=1000;
    //Manejar los arreglos de retiros y depositos

    public CuentaVO() {
  
    }

    public CuentaVO(String nombreC, String cuiC, double saldoC, int idCuenta) {
        this.idCuenta = idCuenta;
        this.nombreC = nombreC;
        this.cuiC = cuiC;
        this.saldoC = saldoC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getCuiC() {
        return cuiC;
    }

    public void setCuiC(String cuiC) {
        this.cuiC = cuiC;
    }

    public double getSaldoC() {
        return saldoC;
    }

    public void setSaldoC(double saldoC) {
        this.saldoC = saldoC;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    
        

   
    
    
    

   

    
}
