package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import javax.swing.*;

public class AgregarTrabajadorController {
    @FXML
    private JTextField txtIdTrabajador, txtNombresTrabajador,
            txtApellidosTrabajador, txtCelularTrabajador;
    @FXML
    private DatePicker calendarFechaDeRegistro;

    public void btnGuardarTrabajador_action(){
        //todo save the information in text fields and date picker
        //todo create new worker and save in the file
    }
}
