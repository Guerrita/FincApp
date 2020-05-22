package Controller;

import Bsn.AdministradorBsn;
import Model.Administrador;
import javafx.fxml.FXML;
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
        }
    }

    public void setPrincipal(VistaPrincipalController vistaPrincipalController){
        this.principal = vistaPrincipalController;
    }
}
