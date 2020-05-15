package Dao;

import Bsn.exception.TrabajadorYaExisteException;
import Model.Trabajador;

import java.util.List;

public interface TrabajadorDao {

    void registrarTrabajador(Trabajador trabajador) throws TrabajadorYaExisteException;

    List<Trabajador> listarTrabajadores();
}
