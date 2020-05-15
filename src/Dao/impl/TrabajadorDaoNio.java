package Dao.impl;

import Bsn.exception.TrabajadorYaExisteException;
import Dao.TrabajadorDao;
import Model.Trabajador;

import java.util.List;

public class TrabajadorDaoNio implements TrabajadorDao
{
    @Override
    public void registrarTrabajador(Trabajador trabajador) throws TrabajadorYaExisteException {

    }

    @Override
    public List<Trabajador> listarTrabajadores() {
        return null;
    }
}
