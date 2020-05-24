package Controller;

import Bsn.FincaBsn;
import Model.Transaccion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ReporteTansaccionesController {

    @FXML
    TableView<Transaccion> tblTransacciones;
    @FXML
    TableColumn<Transaccion, String> clmTipoTransaccion;
    @FXML
    TableColumn<Transaccion, String> clmDescripcion;
    @FXML
    TableColumn<Transaccion, String> clmValor;
    @FXML
    TableColumn<Transaccion, String> clmFecha;

    private FincaBsn fincaBsn= new FincaBsn();

    @FXML
    private void initialize(){
        List<Transaccion> transacciones= fincaBsn.listarTransacciones();
        ObservableList<Transaccion> transaccionObservables = FXCollections.observableList(transacciones);
        clmTipoTransaccion.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        clmDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        clmValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        clmFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tblTransacciones.getItems().addAll(transaccionObservables);
    }

}
