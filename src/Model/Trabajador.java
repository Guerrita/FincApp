package Model;

import java.time.LocalDate;

public class Trabajador extends Persona {
    private LocalDate fechaDeRegistro;

    public Trabajador(String nombres, String apellidos, int id, int celular, LocalDate fechaDeRegistro) {
        super(id, celular, nombres, apellidos);
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public LocalDate getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(LocalDate fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }
}
