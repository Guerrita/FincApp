package Bsn;

import Bsn.exception.TrabajadorYaExisteException;
import Dao.TrabajadorDao;
import Dao.exception.LlaveDuplicadaException;
import Dao.impl.TrabajadorDaoNio;
import Model.Trabajador;

import java.util.List;

public class TrabajadorBsn {

    private TrabajadorDao trabajadorDao;

    public TrabajadorBsn(){
        this.trabajadorDao=new TrabajadorDaoNio();
    }

    public void registrarTrabajador(Trabajador trabajador) throws TrabajadorYaExisteException{
        try{
            this.trabajadorDao.registrarTrabajador(trabajador);
        }catch(LlaveDuplicadaException lde){
            throw new TrabajadorYaExisteException(String.format
                    ("El trabajador con id: %s ya había sido creado", trabajador.getId()));
        }
    }

    public List<Trabajador> listarTrabajadores(){return this.trabajadorDao.listarTrabajadores();}

}
