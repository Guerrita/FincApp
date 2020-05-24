package Bsn;

import Bsn.exception.ValorNegativoException;
import Dao.FincaDao;
import Dao.TransaccionDao;
import Dao.impl.FincaDaoNio;
import Dao.impl.TransaccionDaoNio;
import Model.Finca;
import Model.Transaccion;

import java.util.List;

public class FincaBsn {
    private FincaDao fincaDao;
    private TransaccionDao transaccionDao;

    public FincaBsn() {
        this.fincaDao = new FincaDaoNio();
        this.transaccionDao= new TransaccionDaoNio();
    }

    public void registrarFinca(Finca finca){
        this.fincaDao.registrarFinca(finca);
    }

    public Finca getFinca() {
        return fincaDao.obtenerFinca();
    }

    public void registrarTransaccion(Transaccion transaccion) throws ValorNegativoException {
       try{
           this.transaccionDao.registrarTransaccion(transaccion);
       }catch (ValorNegativoException nve){
            //throw new ValorNegativoException(String.format("El valor de la transacción" + "no puede ser negativo= %d",transaccion.getValor()));
       }
    }

    public List<Transaccion> listarTransacciones(){
        return transaccionDao.listarTransacciones();
    }

}
