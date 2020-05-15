package Controller;

import Model.Transaccion;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextFormatter;


import java.awt.*;
import java.time.LocalDate;

public class AgregarTransaccionController {
    @FXML
    private TextField txtDescripcion,txtValor;

    @FXML
    private DatePicker datePickerFecha;

    @FXML
    public void  initialize() {

    }

    public void btnIngresar_action(){
        String DescripcionIngresado = txtDescripcion.getText().trim();
        String valorIngresado = txtValor.getText().trim();
        LocalDate fechaIngresada = datePickerFecha.getValue();



        Transaccion transaccion = new Transaccion(DescripcionIngresado,Integer.valueOf(valorIngresado), fechaIngresada);

    }
}
