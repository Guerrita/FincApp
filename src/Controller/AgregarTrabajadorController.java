package Controller;

import Bsn.TrabajadorBsn;
import Bsn.exception.TrabajadorYaExisteException;
import Model.Trabajador;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.time.LocalDate;


public class AgregarTrabajadorController {
    @FXML
    private TextField txtIdTrabajador, txtNombresTrabajador,
            txtApellidosTrabajador, txtCelularTrabajador;
    @FXML
    private DatePicker calendarFechaDeRegistro;

    @FXML
    public void initialize(){
        txtIdTrabajador.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?") && change.getControlNewText().length() <= 12) {
                return change;
            }
            return null;
        }));
        txtCelularTrabajador.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?") && change.getControlNewText().length() <= 12) {
                return change;
            }
            return null;
        }));
    }

    private TrabajadorBsn trabajadorBsn=new TrabajadorBsn();

    public void btnGuardarTrabajador_action(){

        String idIngresado = txtIdTrabajador.getText().trim();
        String nombresIngresados = txtNombresTrabajador.getText().trim();
        String apellidosIngresados = txtApellidosTrabajador.getText().trim();
        String celularIngresado = txtCelularTrabajador.getText().trim();
        LocalDate fechaIngresada = calendarFechaDeRegistro.getValue();
        boolean valido=validarCampos(idIngresado, nombresIngresados, apellidosIngresados,
                celularIngresado);
        if(fechaIngresada==null || !valido){
            mostrarAlertaErrorTrabajador("Proceso de registro"
                    ,"Ingrese todos los campos");
            return;
        }
        Trabajador trabajador = new Trabajador(Integer.valueOf(idIngresado),nombresIngresados, apellidosIngresados
                ,Integer.valueOf(celularIngresado),fechaIngresada);
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

    private boolean validarCampos(String... campos) {
        for (int i = 0; i < campos.length; i++) {
            if (campos[i] == null || "".equals(campos[i])) {
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
