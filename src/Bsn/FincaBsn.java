package Bsn;

import Bsn.exception.ValorNegativoException;
import Dao.FincaDao;
import Dao.TransaccionDao;
import Dao.impl.FincaDaoNio;
import Dao.impl.TransaccionDaoNio;
import Model.Finca;
import Model.Transaccion;

import java.io.IOException;
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
           String tipoT = transaccion.getTipo();
           Finca finca = getFinca();
           switch (tipoT){

               case "Ingreso":
                   finca.setCapital(getFinca().getCapital()+transaccion.getValor());
                   fincaDao.actualizarCapital(finca.getCapital());
                   finca.getCapital();
                   break;

               case "Egreso":
                   finca.setCapital(getFinca().getCapital()-transaccion.getValor());
                   fincaDao.actualizarCapital(finca.getCapital());
                   break;
           }

       }catch (ValorNegativoException | IOException nve){
           throw new ValorNegativoException(String.format("El valor de la transacción no puede " +
                   "superar el cápital actual. \n Valor de transacción= %d, Capital actual= %d",
                   transaccion.getValor(),this.getFinca().getCapital()));
       }
    }

    public List<Transaccion> listarTransacciones(){
        return transaccionDao.listarTransacciones();
    }

}
