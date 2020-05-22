package Controller;


import Bsn.AdministradorBsn;
import Bsn.FincaBsn;
import Dao.FincaDao;
import Dao.impl.AdministradorDaoNio;
import Dao.impl.FincaDaoNio;
import Model.Administrador;
import Model.Finca;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import java.io.IOException;

public class VistaPrincipalController {
    @FXML
    private BorderPane vistaPrincipal;
    @FXML
    public MenuBar menuBarPrincipal;

    public AdministradorBsn administradorBsn = new AdministradorBsn();
    public FincaBsn fincaBsn = new FincaBsn();

    @FXML
    public void initialize() throws IOException {
        Finca finca = this.fincaBsn.getFinca();
        Administrador administrador = this.administradorBsn.getAdministrador();
        if (administrador == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/registrar-admin-finca.fxml"));
                AnchorPane registrarEstudiante = loader.load();
                RegistrarAdminFincaController controller = loader.getController();
                controller.setPrincipal(this);
                vistaPrincipal.setCenter(registrarEstudiante);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ingreso-admin.fxml"));
                AnchorPane registrarEstudiante = loader.load();
                IngresoAdminController controller = loader.getController();
                controller.setPrincipal(this);
                vistaPrincipal.setCenter(registrarEstudiante);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void habilitarMenu(){
        this.menuBarPrincipal.setVisible(true);
    }

    public void mnuAgregarTrabajador_action() {
        try {
            AnchorPane agregarTrabajador = FXMLLoader
                    .load(getClass().getResource("../view/agregar-trabajador.fxml"));
            this.vistaPrincipal.setCenter(agregarTrabajador);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mnuAgregarTransaccion_action(){
        try {
            AnchorPane agregarFactura = FXMLLoader
                    .load(getClass().getResource("../view/agregar-transaccion.fxml"));
            this.vistaPrincipal.setCenter(agregarFactura);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mnuReporteTrabajadores_action(){
        try {
            AnchorPane reporteTrabajador = FXMLLoader
                    .load(getClass().getResource("../view/reporte-trabajadores.fxml"));
            this.vistaPrincipal.setCenter(reporteTrabajador);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mnuReporteTransaccion_action(){
        try {
            AnchorPane reporteFactura = FXMLLoader
                    .load(getClass().getResource("../view/reporte-transacciones.fxml"));
            this.vistaPrincipal.setCenter(reporteFactura);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

