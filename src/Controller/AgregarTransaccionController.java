package Controller;

import Model.Transaccion;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import java.time.LocalDate;

public class AgregarTransaccionController {
    @FXML
    private TextField txtDescripcion,txtValor;

    @FXML
    private DatePicker datePickerFecha;

    @FXML
    public void  initialize() {
        txtValor.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?")&& change.getControlNewText().length()<=12){
                return change;
            }
            return null;
        }));
    }

    public void btnIngresar_action(){
        String DescripcionIngresado = txtDescripcion.getText().trim();
        String valorIngresado = txtValor.getText().trim();
        LocalDate fechaIngresada = datePickerFecha.getValue();



        Transaccion transaccion = new Transaccion(DescripcionIngresado,Integer.valueOf(valorIngresado), fechaIngresada);

    }
}
