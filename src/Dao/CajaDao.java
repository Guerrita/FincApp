package Dao;

import Model.Trabajador;
import Model.Transaccion;

import java.util.List;

public interface CajaDao {

    void registrarTransaccion(Transaccion transaccion);

}
