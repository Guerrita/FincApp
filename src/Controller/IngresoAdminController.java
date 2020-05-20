package Controller;

import Dao.impl.AdministradorDaoNio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;


public class IngresoAdminController {
    @FXML
    private TextField txtIdentificacion;
    @FXML
    private PasswordField txtContrasena;


    public void btnIngresar_action(){
        String idIngresado = txtIdentificacion.getText().trim();
        String contrasenaIngresado = txtContrasena.getText().trim();
        System.out.println(AdministradorDaoNio.getAdministrador().getId());
        System.out.println(AdministradorDaoNio.getAdministrador().getContrasena());

        if (idIngresado.equals(AdministradorDaoNio.getAdministrador().getId()) && contrasenaIngresado.equals(AdministradorDaoNio.getAdministrador().getContrasena())){

        }
    }
}
