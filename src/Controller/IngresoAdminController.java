package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class IngresoAdminController {
    @FXML
    private TextField txtIdentificacion;
    @FXML
    private PasswordField txtContrasena;
    public void btnIngresar_action(){
        String idIngresado = txtIdentificacion.getText().trim();
        String contrasenaIngresado = txtContrasena.getText().trim();
    }
}
