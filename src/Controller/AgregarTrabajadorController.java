package Controller;

import Bsn.TrabajadorBsn;
import Bsn.exception.TrabajadorYaExisteException;
import Model.Trabajador;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

import java.time.LocalDate;


public class AgregarTrabajadorController {
    @FXML
    private JFXTextField txtIdTrabajador, txtNombresTrabajador,
            txtApellidosTrabajador, txtCelularTrabajador;
    @FXML
    private JFXDatePicker calendarFechaDeRegistro;

    @FXML
    public void initialize(){
        txtIdTrabajador.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?") && change.getControlNewText().length() <= 12) {
                return change;
            }
            return null;
        }));
        txtCelularTrabajador.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?") && change.getControlNewText().length() <= 10) {
                return change;
            }
            return null;
        }));

        RequiredFieldValidator validator = new RequiredFieldValidator();
        FontIcon warnIcon = new FontIcon(FontAwesomeSolid.ARROW_UP.getDescription());
        validator.setIcon(warnIcon);

        txtNombresTrabajador.getValidators().add(validator);
        txtNombresTrabajador.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtNombresTrabajador.validate();
        });

        txtIdTrabajador.getValidators().add(validator);
        txtIdTrabajador.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtIdTrabajador.validate();
        });

        txtApellidosTrabajador.getValidators().add(validator);
        txtApellidosTrabajador.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtApellidosTrabajador.validate();
        });

        txtCelularTrabajador.getValidators().add(validator);
        txtCelularTrabajador.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) txtCelularTrabajador.validate();
        });

        calendarFechaDeRegistro.getValidators().add(validator);
        calendarFechaDeRegistro.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) calendarFechaDeRegistro.validate();
        });

    }

    private TrabajadorBsn trabajadorBsn=new TrabajadorBsn();

    public void btnGuardarTrabajador_action(){

        String idIngresado = txtIdTrabajador.getText().trim();
        String nombresIngresados = txtNombresTrabajador.getText().trim();
        String apellidosIngresados = txtApellidosTrabajador.getText().trim();
        String celularIngresado = txtCelularTrabajador.getText().trim();
        LocalDate fechaIngresada = calendarFechaDeRegistro.getValue();
        boolean valido=validarCampos(fechaIngresada, idIngresado, nombresIngresados, apellidosIngresados,
                celularIngresado);
        if(!valido){
            mostrarAlertaErrorTrabajador("Proceso de registro"
                    ,"Ingrese todos los campos");
            return;
        }
        Trabajador trabajador = new Trabajador(idIngresado,nombresIngresados, apellidosIngresados
                ,celularIngresado,fechaIngresada);
        try{
            trabajadorBsn.registrarTrabajador(trabajador);
            Alert alertExito = new Alert(Alert.AlertType.INFORMATION);
            alertExito.setTitle("Registro de Trabajador");
            alertExito.setHeaderText("Resultado de la operación");
            alertExito.setContentText("El registro ha sido exitoso");
            alertExito.showAndWait();
            limpiarCampos();
        }catch(TrabajadorYaExisteException tyee){
                mostrarAlertaErrorTrabajador("Ha ocurrido un error",
                        tyee.getMessage());
                return;
        }
    }

    private void mostrarAlertaErrorTrabajador(String mensajeHead, String mensaje) {
        Alert alertError = new Alert(Alert.AlertType.ERROR);
        alertError.setTitle("Registro de Trabajador");
        alertError.setHeaderText(mensajeHead);
        alertError.setContentText(mensaje);
        alertError.showAndWait();
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
        txtIdTrabajador.clear();
        txtNombresTrabajador.clear();
        txtApellidosTrabajador.clear();
        txtCelularTrabajador.clear();
        calendarFechaDeRegistro.getEditor().clear();
    }

}
