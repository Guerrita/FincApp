package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaccion {
    private int valor;
    private String Descripcion, tipo;
    private LocalDate fecha;

    public Transaccion(String tipoTransaccion, String descripcion, int valor, LocalDate fecha) {
        this.tipo=tipoTransaccion;
        this.valor = valor;
        this.Descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        this.Descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
