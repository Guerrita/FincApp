package Dao.impl;

import Dao.AdministradorDao;
import Model.Administrador;

public class AdministradorDaoNio implements AdministradorDao {
    private static Administrador administrador = null;

    @Override
    public void registrarAdministrador(Administrador administradorIngresado) {
        administrador = administradorIngresado;
    }


    public static Administrador obtenerAdministrador() {
        return administrador;
    }
}
