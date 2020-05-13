package Model;

import java.time.LocalDateTime;

public class Trabajador extends Persona {
    private LocalDateTime fechaDeRegistro;

    public Trabajador(String nombres, String apellidos, int id, int celular, LocalDateTime fechaDeRegistro) {
        super(id, celular, nombres, apellidos);
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public LocalDateTime getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(LocalDateTime fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }
}
