package Dao;

import Bsn.exception.TrabajadorYaExisteException;
import Dao.exception.LlaveDuplicadaException;
import Model.Trabajador;

import java.util.List;
import java.util.Optional;

public interface TrabajadorDao {

    void registrarTrabajador(Trabajador trabajador) throws TrabajadorYaExisteException, LlaveDuplicadaException;

    Optional<Trabajador> consultarTrabajadorPorId(String id);

    List<Trabajador> listarTrabajadores();
}
