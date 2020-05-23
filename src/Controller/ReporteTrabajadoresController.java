package Controller;

import Bsn.TrabajadorBsn;
import Model.Trabajador;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ReporteTrabajadoresController {

    @FXML
    TableView<Trabajador> tblTrabajadores;
    @FXML
    TableColumn<Trabajador, String> clmNombres;
    @FXML
    TableColumn<Trabajador, String> clmApellidos;
    @FXML
    TableColumn<Trabajador, String> clmCelular;
    @FXML
    TableColumn<Trabajador, String> clmId;
    @FXML
    TableColumn<Trabajador, String> clmFechaRegistro;

    private TrabajadorBsn trabajadorbsn;

    @FXML
    private void initialize(){
        //todo llenar lista de trabajadores, crear un botón para que la cree
    }
}
