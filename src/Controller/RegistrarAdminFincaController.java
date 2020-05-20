package Controller;

import Bsn.AdministradorBsn;
import Dao.impl.AdministradorDaoNio;
import Model.Administrador;
import Model.Finca;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class RegistrarAdminFincaController {
    @FXML
    private TextField txtNombres,txtApellidos,txtIdentificacion,txtCelular,txtNombreFinca,txtExtension;
    @FXML
    private PasswordField txtContrasena,txtConfirmarContrasena;
    @FXML
    private BorderPane vistaPrincipal;

    private AdministradorBsn administradorBsn = new AdministradorBsn();

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
        Administrador administrador = new Administrador(nombresIngresados,apellidosIngresados,Integer.valueOf(idIngresado),Integer.valueOf(celularIngresado),contrasenaIngresado);
        Finca finca = new Finca(nombreFincaIngresado,extensionIngresado);
        administrador.setFinca(finca);

        try {
            administradorBsn.registrarAdministrador(administrador);
        }catch (Exception ioe){
            ioe.printStackTrace();
        }



        //ToDO validar datos ingresados
        //Ingresar lo datos a la base de datos

    }


    //Se puede hacer este metodo publico y estatico para que funcione en todas las clases?
    ///////////////////////////////////////////////////////////////////////////////////
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
        txtContrasena.clear();
        txtConfirmarContrasena.clear();
        txtNombreFinca.clear();
        txtExtension.clear();
    }
}
