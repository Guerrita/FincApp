package Dao;

import Model.Administrador;

public interface AdministradorDao {

    void registrarAdministrador(Administrador administrador);

    static Administrador obtenerAdministrador() {
        return null;
    }
}
