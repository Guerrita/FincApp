package Controller;

import Dao.impl.AdministradorDaoNio;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;


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
            System.out.println("Ingreso Exitoso");
        }
    }
}
