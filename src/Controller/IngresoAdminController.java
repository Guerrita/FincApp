package Controller;

import Bsn.AdministradorBsn;
import Model.Administrador;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;


public class IngresoAdminController {
    @FXML
    private JFXTextField txtIdentificacion;
    @FXML
    private JFXPasswordField txtContrasena;
    @FXML
    private Button btnIngresar;

    public AdministradorBsn administradorBsn = new AdministradorBsn();

    private VistaPrincipalController principal;

    public void initialize(){
        RequiredFieldValidator validator = new RequiredFieldValidator();
        FontIcon warnIcon = new FontIcon(FontAwesomeSolid.ARROW_UP.getDescription());
        validator.setIcon(warnIcon);

        txtContrasena.getValidators().add(validator);
        txtContrasena.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtContrasena.validate();
        });

        txtIdentificacion.getValidators().add(validator);
        txtIdentificacion.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtIdentificacion.validate();
        });
    }


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
            this.principal.habilitarVistaBienvenida();
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
