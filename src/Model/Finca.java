package Model;

import java.util.List;

public class Finca {
    private String nombre,
                   extension;
    private List<Trabajador> trabajadores;
    private Administrador administrador;
    private Caja inventario;

    public Finca(String nombre, String extension) {
        this.nombre = nombre;
        this.extension = extension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Caja getInventario() {
        return inventario;
    }

    public void setInventario(Caja inventario) {
        this.inventario = inventario;
    }
}
