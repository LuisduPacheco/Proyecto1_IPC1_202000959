package modelo;

public class RetirosVO {

    private String nombreC;
    private String cuiC;
    private int idCuenta;
    private double SaldoI;
    private double SaldoF;
    private String motivo;
    private int contador = -1;
    private String fecha;

    public RetirosVO(int contador,String nombreC, String cuiC, int idCuenta, double SaldoI, double SaldoF, String motivo, String fecha) {
        this.nombreC = nombreC;
        this.cuiC = cuiC;
        this.idCuenta = idCuenta;
        this.SaldoI = SaldoI;
        this.SaldoF = SaldoF;
        this.motivo = motivo;
        this.fecha = fecha;
        this.contador = contador;
    }

    public RetirosVO() {
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

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getSaldoI() {
        return SaldoI;
    }

    public void setSaldoI(double SaldoI) {
        this.SaldoI = SaldoI;
    }

    public double getSaldoF() {
        return SaldoF;
    }

    public void setSaldoF(double SaldoF) {
        this.SaldoF = SaldoF;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
