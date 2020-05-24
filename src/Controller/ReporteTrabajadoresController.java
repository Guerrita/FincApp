package Controller;

import Bsn.TrabajadorBsn;
import Model.Trabajador;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;


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

    private TrabajadorBsn trabajadorbsn=new TrabajadorBsn();

    @FXML
    private void initialize(){
        List<Trabajador> trabajadores= trabajadorbsn.listarTrabajadores();
        ObservableList<Trabajador> trabajadorObservables = FXCollections.observableList(trabajadores);
        clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        clmApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        clmCelular.setCellValueFactory(new PropertyValueFactory<>("celular"));
        clmFechaRegistro.setCellValueFactory(new PropertyValueFactory<>("fechaDeRegistro"));
        tblTrabajadores.getItems().addAll(trabajadorObservables);
    }
}
