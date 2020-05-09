package Model;

import java.time.LocalDateTime;

public class Trabajador extends Persona {
    private LocalDateTime fechaDeRegistro;

    public Trabajador(int id, int celular, String nombres, String apellidos, LocalDateTime fechaDeRegistro) {
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
