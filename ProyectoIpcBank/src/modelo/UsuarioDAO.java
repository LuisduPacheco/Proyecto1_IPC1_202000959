package modelo;

public class UsuarioDAO {

    

    public int buscar(String cui, UsuarioVO[] usuariosU) {
        int validar = -1;
        for (int i = 0; i < usuariosU.length; i++) {
            if (usuariosU[i] != null) { //Se agrego extra, validando que la posición no se aun dato nulo
                if (usuariosU[i].getCui() != null) {
                    if (usuariosU[i].getCui().equalsIgnoreCase(cui)) {
                        validar = i;
                        break;
                    }
                }
            }

        }
        return validar;
    }

    public boolean insertar(UsuarioVO usuario, UsuarioVO[] usuarioU) {
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
    }

    public void imprimir(UsuarioVO[] usuarioU) {
        for (int i = 0; i < usuarioU.length; i++) {            
            if(usuarioU[i] != null ) System.out.println("Cui: " + usuarioU[i].getCui() + " Nombre: " + usuarioU[i].getNombre() + " Apellido: " + usuarioU[i].getApellido());
        }       
    }
}
