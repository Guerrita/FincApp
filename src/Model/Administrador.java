package Model;

import java.util.List;

public class Administrador extends Persona {
    private String contrasena;
    private List<Transaccion> transacciones;
    private Finca finca;

    public Administrador(String nombres,String apellidos,int id, int celular,  String contrasena) {
        super(id, celular, nombres, apellidos);
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }
}
