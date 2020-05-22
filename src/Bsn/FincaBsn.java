package Bsn;

import Dao.FincaDao;
import Dao.impl.FincaDaoNio;
import Model.Finca;

public class FincaBsn {
    private FincaDao fincaDao;


    public FincaBsn() {
        this.fincaDao = new FincaDaoNio();
    }

    public void registrarFinca(Finca finca){
        this.fincaDao.registrarFinca(finca);
    }

    public Finca getFinca() {
        return fincaDao.obtenerFinca();
    }
}
