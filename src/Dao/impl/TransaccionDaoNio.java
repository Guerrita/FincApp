package Dao.impl;

import Bsn.exception.ValorNegativoException;
import Dao.TransaccionDao;
import Model.Transaccion;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;

public class TransaccionDaoNio implements TransaccionDao {

    private final static String NOMBRE_ARCHIVO ="transacciones";
    private final static Path ARCHIVO = Paths.get(NOMBRE_ARCHIVO);
    private final static String FIELD_SEPARATOR= "°";
    private final static String RECORD_SEPARATOR= System.lineSeparator();

    public TransaccionDaoNio(){
        if(!Files.exists(ARCHIVO)){
            try{
                Files.createFile(ARCHIVO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void registrarTransaccion(Transaccion transaccionIngresada) throws ValorNegativoException {
        if(transaccionIngresada.getValor()<0){
            //throw new ValorNegativoException("");
        }
        String transaccionString = parseTransaccion2String(transaccionIngresada);
        byte[] datosRegistro = transaccionString.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(datosRegistro);
        try (FileChannel fileChannel = FileChannel.open(ARCHIVO, APPEND)) {
            fileChannel.write(byteBuffer);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private String parseTransaccion2String(Transaccion transaccion) {
        StringBuilder sb = new StringBuilder();
        sb.append(transaccion.getTipo()).append(FIELD_SEPARATOR).
                append(transaccion.getDescripcion()).append(FIELD_SEPARATOR).
                append(transaccion.getValor()).append(FIELD_SEPARATOR).
                append(transaccion.getFecha()).append(RECORD_SEPARATOR);
        return sb.toString();
    }

    private Transaccion parseTransaccion2Object(String transaccionString){
        String[] datosTransaccion = transaccionString.split(FIELD_SEPARATOR);
        // todo: validar que el tamaño del arreglo sea de 4 elementos
        Transaccion transaccion= new Transaccion(datosTransaccion[0],datosTransaccion[1]
        , Integer.parseInt(datosTransaccion[2]), LocalDate.parse(datosTransaccion[3]));
        //todo si se ingresa una descripcion "Primer transacción, capital inicial" toma como si lo separara
        return transaccion;
    }

    @Override
    public List<Transaccion> listarTransacciones() {
        List<Transaccion> transacciones = new ArrayList<>();
        try (Stream<String> stream = Files.lines(ARCHIVO)) {
            stream.forEach(estudianteString -> transacciones.add(parseTransaccion2Object(estudianteString)));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return transacciones;
    }
}
