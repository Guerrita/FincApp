package Controller;

import Model.Transaccion;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        if(!validarCampos(fechaIngresada, DescripcionIngresado, valorIngresado)){
            mostrarAlertaErrorTransaccion("Proceso de registro", "Ingrese " +
                    "todos los campos");
            return;
        }
        try{
            //todo guardar en el negocio, excepcion de que no sea negativo, sin embargo el campo de ingreso de datos se
            // controla al no permitir este caracter al inicio, mas bien de que no sea una transaccion repetida.
            Transaccion transaccion = new Transaccion(DescripcionIngresado,Integer.valueOf(valorIngresado), fechaIngresada);
            Alert alertExito = new Alert(Alert.AlertType.INFORMATION);
            alertExito.setTitle("Registro de Transacción");
            alertExito.setHeaderText("Resultado de la operación");
            alertExito.setContentText("El registro ha sido exitoso");
            alertExito.showAndWait();
            limpiarCampos();
        }catch(Exception e){

        }


    }

    private boolean validarCampos(LocalDate fecha, String... campos) {
        if(fecha==null)return false;
        for (int i = 0; i < campos.length; i++) {
            if (campos[i] == null || "".equals(campos[i])) {
                return false;
            }
        }
        return true;
    }

    private void limpiarCampos(){
        txtDescripcion.clear();
        txtValor.clear();
        datePickerFecha.getEditor().clear();
    }

    private void mostrarAlertaErrorTransaccion(String mensajeHead, String mensaje) {
        Alert alertError = new Alert(Alert.AlertType.ERROR);
        alertError.setTitle("Registro de Trabajador");
        alertError.setHeaderText(mensajeHead);
        alertError.setContentText(mensaje);
        alertError.showAndWait();
    }

}
