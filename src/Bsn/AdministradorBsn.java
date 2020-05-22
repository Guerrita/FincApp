package Bsn;

import Dao.AdministradorDao;
import Dao.impl.AdministradorDaoNio;
import Model.Administrador;

public class AdministradorBsn {
    private AdministradorDao administradorDao;

    public AdministradorBsn() {
        this.administradorDao = new AdministradorDaoNio();
    }

    public void registrarAdministrador(Administrador administrador){
        this.administradorDao.registrarAdministrador(administrador);
    }

    public Administrador getAdministrador() {
        return administradorDao.obtenerAdministrador();
    }
}
