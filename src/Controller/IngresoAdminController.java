package Controller;

import javafx.fxml.FXML;

import java.awt.*;

public class IngresoAdminController {
    @FXML
    private TextField txtIdentificacion,
                      txtContrasena;
    public void btnIngresar_action(){
        String idIngresado = txtIdentificacion.getText().trim();
        String contrasenaIngresado = txtContrasena.getText().trim();
    }
}
