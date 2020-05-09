package Model;

import java.time.LocalDateTime;

public class Transaccion {
    private int valor;
    private String Descripcion;
    private LocalDateTime fecha;

    public Transaccion(int valor, String descripcion, LocalDateTime fecha) {
        this.valor = valor;
        Descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
