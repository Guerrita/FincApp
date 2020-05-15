package Dao;

import Model.Administrador;
import Model.Finca;
import Model.Trabajador;

import java.util.Optional;

public interface AdministradorDao {

    void registrarAdministrador(Administrador administrador);

    Optional<Administrador> obtenerAdministrador();
}
