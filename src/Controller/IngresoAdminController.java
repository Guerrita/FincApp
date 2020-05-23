package Controller;

import Bsn.AdministradorBsn;
import Model.Administrador;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;




public class IngresoAdminController {
    @FXML
    private TextField txtIdentificacion;
    @FXML
    private PasswordField txtContrasena;
    @FXML
    private Button btnIngresar;

    public AdministradorBsn administradorBsn = new AdministradorBsn();

    private VistaPrincipalController principal;

    public void btnIngresar_action() {
        String idIngresado = txtIdentificacion.getText().trim();
        String contrasenaIngresado = txtContrasena.getText().trim();
        Administrador administrador = this.administradorBsn.getAdministrador();
       if (idIngresado.equals(administrador.getId()) && contrasenaIngresado.equals(administrador.getContrasena())) {
            txtContrasena.setDisable(true);
            txtIdentificacion.setDisable(true);
            txtContrasena.clear();
            txtIdentificacion.clear();
            btnIngresar.setDisable(true);
            this.principal.habilitarMenu();
        }else {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Ingreso administrador");
           alert.setHeaderText("Ingreso");
           alert.setContentText("La cuenta o la contraseña son incorrectas");
           txtContrasena.requestFocus();
           alert.showAndWait();
           return;
       }
    }

    public void setPrincipal(VistaPrincipalController vistaPrincipalController){
        this.principal = vistaPrincipalController;
    }
}
