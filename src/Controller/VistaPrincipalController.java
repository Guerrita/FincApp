package Controller;


import Bsn.AdministradorBsn;
import Dao.impl.AdministradorDaoNio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import java.awt.*;
import java.io.IOException;

public class VistaPrincipalController {
    @FXML
    private  BorderPane vistaPrincipal;
    @FXML
    public static Menu mnuAgregar, mnuGenerarReporte;

    @FXML
    public void initialize() throws IOException {
        AdministradorDaoNio.obtenerAdministrador();
        if (AdministradorDaoNio.getAdministrador() ==null) {
            try {
                AnchorPane registrarEstudiante = FXMLLoader
                        .load(getClass().getResource("../View/registrar-admin-finca.fxml"));
                vistaPrincipal.setCenter(registrarEstudiante);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                AnchorPane registrarEstudiante = FXMLLoader
                        .load(getClass().getResource("../View/ingreso-admin.fxml"));
                vistaPrincipal.setCenter(registrarEstudiante);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

