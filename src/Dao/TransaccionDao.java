package Dao;

import Bsn.exception.ValorNegativoException;
import Model.Transaccion;

import java.util.List;

public interface TransaccionDao {

    void registrarTransaccion(Transaccion transaccion) throws ValorNegativoException;

    List<Transaccion> listarTransacciones();
}
