package Controller;

import Model.Trabajador;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.time.LocalDate;


public class AgregarTrabajadorController {
    @FXML
    private TextField txtIdTrabajador, txtNombresTrabajador,
            txtApellidosTrabajador, txtCelularTrabajador;
    @FXML
    private DatePicker calendarFechaDeRegistro;

    public void btnGuardarTrabajador_action(){
        //todo save the information in text fields and date picker
        //todo create new worker and save in the file

        String idIngresado = txtIdTrabajador.getText().trim();
        String nombresIngresados = txtNombresTrabajador.getText().trim();
        String apellidosIngresados = txtApellidosTrabajador.getText().trim();
        String celularIngresado = txtCelularTrabajador.getText().trim();
        LocalDate fechaIngresada = calendarFechaDeRegistro.getValue();


        Trabajador trabajador = new Trabajador(nombresIngresados,apellidosIngresados,Integer.valueOf(idIngresado),Integer.valueOf(celularIngresado),fechaIngresada);
    }
}
