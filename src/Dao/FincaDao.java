package Dao;

import Model.Finca;

import java.io.IOException;

public interface FincaDao {

    void registrarFinca(Finca finca);

    Finca obtenerFinca();

    void actualizarCapital(int capitalN) throws IOException;
}
