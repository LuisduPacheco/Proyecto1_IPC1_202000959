
package modelo;


public class TransaccionVO {
    private String nombreC;
    private String cuiC;
    private double Monto;
    private int idCuenta;
    private String transaccion;
    private int contador = -1;
    private String fecha;

    public TransaccionVO() {
    }
    //Modificación contador
    public TransaccionVO(int contador,String nombreC, String cuiC, double Monto, int idCuenta, String transaccion, String fecha) {
        this.nombreC = nombreC;
        this.cuiC = cuiC;
        this.Monto = Monto;
        this.idCuenta = idCuenta;
        this.transaccion = transaccion;
        this.fecha = fecha;
        this.contador = contador;
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

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
}
