package Dao.exception;

public class LlaveDuplicadaException extends Exception{

    public LlaveDuplicadaException(String llave){
        super(String.format("Ya existe un registro con" +
                " esa llave: %s", llave));
    }
}
