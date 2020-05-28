package Controller;

import Bsn.AdministradorBsn;
import Bsn.FincaBsn;
import Model.Administrador;
import Model.Finca;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;


public class RegistrarAdminFincaController {
    @FXML
    private JFXTextField txtNombres,txtApellidos,txtIdentificacion,txtCelular,txtNombreFinca,txtExtension;
    @FXML
    private JFXPasswordField txtContrasena,txtConfirmarContrasena;
    @FXML
    private JFXButton btnGuardar;

    private AdministradorBsn administradorBsn = new AdministradorBsn();
    private FincaBsn fincaBsn = new FincaBsn();

    private VistaPrincipalController principal;

    @FXML
    public void  initialize(){
        txtIdentificacion.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?")&& change.getControlNewText().length()<=12){
                return change;
            }
            return null;
        }));
        txtCelular.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?")&& change.getControlNewText().length()<=10){
                return change;
            }
            return null;
        }));
        txtExtension.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?")&& change.getControlNewText().length()<=12){
                return change;
            }
            return null;
        }));

        RequiredFieldValidator validator = new RequiredFieldValidator();
        FontIcon warnIcon = new FontIcon(FontAwesomeSolid.ARROW_UP.getDescription());
        validator.setIcon(warnIcon);

        txtNombres.getValidators().add(validator);
        txtNombres.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtNombres.validate();
        });

        txtIdentificacion.getValidators().add(validator);
        txtIdentificacion.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtIdentificacion.validate();
        });

        txtApellidos.getValidators().add(validator);
        txtApellidos.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtApellidos.validate();
        });

        txtCelular.getValidators().add(validator);
        txtCelular.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtCelular.validate();
        });

        txtContrasena.getValidators().add(validator);
        txtContrasena.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtContrasena.validate();
        });

        txtConfirmarContrasena.getValidators().add(validator);
        txtConfirmarContrasena.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtConfirmarContrasena.validate();
        });

        txtNombreFinca.getValidators().add(validator);
        txtNombreFinca.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtNombreFinca.validate();
        });

        txtExtension.getValidators().add(validator);
        txtExtension.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtExtension.validate();
        });


    }

    public void btnGuardarAdmin_action(){
        String idIngresado = txtIdentificacion.getText().trim();
        String nombresIngresados = txtNombres.getText().trim();
        String apellidosIngresados = txtApellidos.getText().trim();
        String celularIngresado = txtCelular.getText().trim();
        String contrasenaIngresado = txtContrasena.getText().trim();
        String confirmarContrasenaIngresado = txtConfirmarContrasena.getText().trim();
        String nombreFincaIngresado = txtNombreFinca.getText().trim();
        String extensionIngresado = txtExtension.getText().trim();

        boolean esValido = validarCampos(idIngresado,nombresIngresados,apellidosIngresados,celularIngresado,contrasenaIngresado,confirmarContrasenaIngresado,nombreFincaIngresado,extensionIngresado);

        if (!esValido){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registro administrador");
            alert.setHeaderText("Registro administrador");
            alert.setContentText("Diligencie todos los datos");
            alert.showAndWait();
            return;
        }

        if (contrasenaIngresado.equals(confirmarContrasenaIngresado)){
            Administrador administrador = new Administrador(nombresIngresados,apellidosIngresados,idIngresado,celularIngresado,contrasenaIngresado);
            Finca finca = new Finca(nombreFincaIngresado,extensionIngresado);
            administrador.setFinca(finca);
            try {
                administradorBsn.registrarAdministrador(administrador);
                fincaBsn.registrarFinca(finca);
                txtIdentificacion.setDisable(true);
                txtNombres.setDisable(true);
                txtApellidos.setDisable(true);
                txtCelular.setDisable(true);
                txtContrasena.setDisable(true);
                txtConfirmarContrasena.setDisable(true);
                txtNombreFinca.setDisable(true);
                txtExtension.setDisable(true);
                btnGuardar.setDisable(true);
                limpiarCampos();
                this.principal.habilitarMenu();
                this.principal.habilitarVistaBienvenida();
            }catch (Exception ioe){
                ioe.printStackTrace();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registro administrador");
            alert.setHeaderText("Contraseña");
            alert.setContentText("Las contraseñas no son iguales");
            txtContrasena.requestFocus();
            alert.showAndWait();
            return;
        }


        //ToDO validar datos ingresados
        //Ingresar lo datos a la base de datos

    }

    private boolean validarCampos(String... campos){
        for (int i = 0; i <campos.length ; i++) {
            if (campos[i]==null || "".equals(campos[i])){
                return false;
            }
        }
        return true;
    }

    private void limpiarCampos(){
        txtIdentificacion.clear();
        txtApellidos.clear();
        txtNombres.clear();
        txtCelular.clear();
        txtContrasena.clear();
        txtConfirmarContrasena.clear();
        txtNombreFinca.clear();
        txtExtension.clear();
    }

    public void setPrincipal(VistaPrincipalController vistaPrincipalController){
        this.principal = vistaPrincipalController;
    }
}
