package Controller;

import Bsn.FincaBsn;
import Bsn.exception.ValorNegativoException;
import Model.Transaccion;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AgregarTransaccionController {

    private FincaBsn fincaBsn= new FincaBsn();
    private final List<String> tiposTransaccion= crearListaTipoTransaccion();

    @FXML
    private JFXTextField txtDescripcion,txtValor;

    @FXML
    private JFXDatePicker datePickerFecha;

    @FXML
    private JFXComboBox<String> cmbTipoDeTransaccion;

    @FXML
    public void  initialize() {
        ObservableList<String> observableTiposTransaccion = FXCollections.observableList(tiposTransaccion);
        cmbTipoDeTransaccion.setItems(observableTiposTransaccion);
        txtValor.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?")&& change.getControlNewText().length()<=8){
                return change;
            }
            return null;
        }));
        txtDescripcion.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("^[\\p{L} .,;'-]+$")&& change.getControlNewText().length()<=100){
                return change;
            }
            return null;
        }));

        RequiredFieldValidator validator = new RequiredFieldValidator();
        FontIcon warnIcon = new FontIcon(FontAwesomeSolid.ARROW_UP.getDescription());
        validator.setIcon(warnIcon);

        txtDescripcion.getValidators().add(validator);
        txtDescripcion.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtDescripcion.validate();
        });

        txtValor.getValidators().add(validator);
        txtValor.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtValor.validate();
        });

        datePickerFecha.getValidators().add(validator);
        datePickerFecha.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) datePickerFecha.validate();
        });

        cmbTipoDeTransaccion.getValidators().add(validator);
        cmbTipoDeTransaccion.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) cmbTipoDeTransaccion.validate();
        });
    }

    public void btnIngresar_action(){
        String tipoTransaccion= cmbTipoDeTransaccion.getValue();
        String DescripcionIngresado = txtDescripcion.getText().trim();
        String valorIngresado = txtValor.getText().trim();
        LocalDate fechaIngresada = datePickerFecha.getValue();
        if(!validarCampos(fechaIngresada, DescripcionIngresado, valorIngresado, tipoTransaccion)){
            mostrarAlertaErrorTransaccion("Proceso de registro", "Ingrese " +
                    "todos los campos");
            return;
        }
        Transaccion transaccion = new Transaccion(tipoTransaccion
                ,DescripcionIngresado,Integer.valueOf(valorIngresado), fechaIngresada);
        try{
            fincaBsn.registrarTransaccion(transaccion);
            Alert alertExito = new Alert(Alert.AlertType.INFORMATION);
            alertExito.setTitle("Registro de Transacción");
            alertExito.setHeaderText("Resultado de la operación");
            alertExito.setContentText("El registro ha sido exitoso");
            alertExito.showAndWait();
            limpiarCampos();
        }catch(ValorNegativoException vne){
            mostrarAlertaErrorTransaccion("Registro de transacción"
                    ,"Ha ocurrido un error");
        }
    }

    private List<String> crearListaTipoTransaccion() {
        List<String> tipoTransaccion= new ArrayList<>(2);
        tipoTransaccion.add("Ingreso");
        tipoTransaccion.add("Egreso");
        return tipoTransaccion;
    }

    private boolean validarCampos(LocalDate fecha, String... campos) {
        if(fecha==null)return false;
        for (String campo : campos) {
            if (campo == null || "".equals(campo)) {
                return false;
            }
        }
        return true;
    }

    private void limpiarCampos(){
        txtValor.clear();
        txtDescripcion.clear();
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
