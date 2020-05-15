package Dao.impl;

import Bsn.exception.ValorNegativoException;
import Dao.TransaccionDao;
import Model.Transaccion;

import java.util.List;

public class TransaccionDaoNio implements TransaccionDao {
    @Override
    public void registrarTransaccion(Transaccion transaccion) throws ValorNegativoException {

    }

    @Override
    public List<Transaccion> listarTransacciones() {
        return null;
    }
}
