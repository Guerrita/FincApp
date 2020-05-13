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

    public JTextField getTxtIdTrabajador() {
        return txtIdTrabajador;
    }

    public void setTxtIdTrabajador(JTextField txtIdTrabajador) {
        this.txtIdTrabajador = txtIdTrabajador;
    }

    public JTextField getTxtNombresTrabajador() {
        return txtNombresTrabajador;
    }

    public void setTxtNombresTrabajador(JTextField txtNombresTrabajador) {
        this.txtNombresTrabajador = txtNombresTrabajador;
    }

    public JTextField getTxtApellidosTrabajador() {
        return txtApellidosTrabajador;
    }

    public void setTxtApellidosTrabajador(JTextField txtApellidosTrabajador) {
        this.txtApellidosTrabajador = txtApellidosTrabajador;
    }

    public JTextField getTxtCelularTrabajador() {
        return txtCelularTrabajador;
    }

    public void setTxtCelularTrabajador(JTextField txtCelularTrabajador) {
        this.txtCelularTrabajador = txtCelularTrabajador;
    }

    public DatePicker getCalendarFechaDeRegistro() {
        return calendarFechaDeRegistro;
    }

    public void setCalendarFechaDeRegistro(DatePicker calendarFechaDeRegistro) {
        this.calendarFechaDeRegistro = calendarFechaDeRegistro;
    }

}
