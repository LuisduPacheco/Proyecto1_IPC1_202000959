package modelo;

public class UsuarioVO {
//Atributos para los usuarios
    private String cui;
    private String nombre;
    private String apellido;
    private final int idUsuario;
    private static int contadorUsuario;

    public UsuarioVO() {
        this.idUsuario = ++UsuarioVO.contadorUsuario; //Incrementa el contador cada que se crea un objeto
        
    }

    public UsuarioVO(String cui, String nombre, String apellido) {
        this(); // llama al constructor que inicia el idUsuario
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
       
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public static int getContadorUsuario() {
        return contadorUsuario;
    }

    public static void setContadorUsuario(int contadorUsuario) {
        UsuarioVO.contadorUsuario = contadorUsuario;
    }
    
    
    
    

    
}
