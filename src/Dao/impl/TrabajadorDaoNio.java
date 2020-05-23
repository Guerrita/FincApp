package Dao.impl;

import Bsn.exception.TrabajadorYaExisteException;
import Dao.TrabajadorDao;
import Dao.exception.LlaveDuplicadaException;
import Model.Trabajador;

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

public class TrabajadorDaoNio implements TrabajadorDao {

    private final static String NOMBRE_ARCHIVO = "trabajadores";
    private final static Path ARCHIVO = Paths.get(NOMBRE_ARCHIVO);
    private final static String FIELD_SEPARATOR = ",";
    private final static String RECORD_SEPARATOR = System.lineSeparator();

    public TrabajadorDaoNio() {
        if (!Files.exists(ARCHIVO)) {
            try {
                Files.createFile(ARCHIVO);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    @Override
    public void registrarTrabajador(Trabajador trabajadorIngresado) throws LlaveDuplicadaException {
        Optional<Trabajador> trabajadorOptional = this.consultarTrabajadorPorId(trabajadorIngresado.getId());
        if(trabajadorOptional.isPresent()){
            throw new LlaveDuplicadaException(trabajadorIngresado.getId());
        }
        String trabajadorString = parseTrabajador2String(trabajadorIngresado);
        byte[] datosRegistro = trabajadorString.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(datosRegistro);
        try (FileChannel fileChannel = FileChannel.open(ARCHIVO, APPEND)) {
            fileChannel.write(byteBuffer);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private String parseTrabajador2String(Trabajador trabajador) {
        StringBuilder sb = new StringBuilder();
        sb.append(trabajador.getId()).append(FIELD_SEPARATOR)
                .append(trabajador.getNombres()).append(FIELD_SEPARATOR)
                .append(trabajador.getApellidos()).append(FIELD_SEPARATOR)
                .append(trabajador.getCelular()).append(FIELD_SEPARATOR)
                .append(trabajador.getFechaDeRegistro()).append(RECORD_SEPARATOR);
        return sb.toString();
    }

    @Override
    public Optional<Trabajador> consultarTrabajadorPorId(String id) {
        try (Stream<String> stream = Files.lines(ARCHIVO)) {
            Optional<String> trabajadorString = stream
                    .filter(trabajador-> id.equals(trabajador.split(",")[0]))
                    .findFirst();
            if(trabajadorString.isPresent()){
                return Optional.of(parseTrabajador2Object(trabajadorString.get()));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Trabajador> listarTrabajadores() {
        List<Trabajador> trabajadores= new ArrayList<>();
        try(Stream<String> stream=Files.lines(ARCHIVO)){
            stream.forEach(trabajadorString -> trabajadores.add(parseTrabajador2Object(trabajadorString)));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return trabajadores;
    }

    private Trabajador parseTrabajador2Object(String trabajadorString) {
        String[] datosTrabajador = trabajadorString.split(FIELD_SEPARATOR);
        Trabajador trabajador = new Trabajador(datosTrabajador[0], datosTrabajador[1]
                , datosTrabajador[2], datosTrabajador[3], LocalDate.parse(datosTrabajador[4]));
        return trabajador;
    }

}
