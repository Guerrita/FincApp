package Model;

import java.util.List;

public class Finca {
    private String nombre,
                   extension;
    private List<Trabajador> trabajadores;
    private Administrador administrador;
    private int capital, ingresos, egresos;
    private List<Transaccion> facturas;

    public Finca(String nombre, String extension) {
        this.nombre = nombre;
        this.extension = extension;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public int getEgresos() {
        return egresos;
    }

    public void setEgresos(int egresos) {
        this.egresos = egresos;
    }

    public List<Transaccion> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Transaccion> facturas) {
        this.facturas = facturas;
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

}
