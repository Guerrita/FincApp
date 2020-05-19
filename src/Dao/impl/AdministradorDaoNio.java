package Dao.impl;

import Dao.AdministradorDao;
import Model.Administrador;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;

public class AdministradorDaoNio implements AdministradorDao {
    private static Administrador administrador ;

    private final static String NOMBRE_ARCHIVO="administrador";
    private final static Path ARCHIVO= Paths.get(NOMBRE_ARCHIVO);
    private final static String FIELD_SEPARATOR = ",";
    private final static String RECORD_SEPARATOR = System.lineSeparator();

    public AdministradorDaoNio(){
        if (!Files.exists(ARCHIVO)){
            try {
                Files.createFile(ARCHIVO);
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }


    @Override
    public void registrarAdministrador(Administrador administradorIngresado) {
        administrador = administradorIngresado;
        String administradorString = parseAdmnistrador2String(administradorIngresado);
        byte[] datosRegistro = administradorString.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(datosRegistro);
        try(FileChannel fileChannel = FileChannel.open(ARCHIVO, APPEND)){
            fileChannel.write(byteBuffer);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parseAdmnistrador2String(Administrador administrador) {
        StringBuilder sb = new StringBuilder();
        sb.append(administrador.getNombres()).append(FIELD_SEPARATOR)
                .append(administrador.getApellidos()).append(FIELD_SEPARATOR)
                .append(administrador.getId()).append(FIELD_SEPARATOR)
                .append(administrador.getCelular()).append(FIELD_SEPARATOR)
                .append(administrador.getContrasena()).append(RECORD_SEPARATOR);
        return sb.toString();
    }


    public static Administrador obtenerAdministrador() { ///Como hacer cuando solo se tiene un objeto en el archivo
        String[] admin = Files.(ARCHIVO);

        return administrador = ;
    }

    private Administrador parseAdministrador2Object() {
        String[] datosEstudiante = estudianteString.split(FIELD_SEPARATOR);
        //ToDo: validar el tamaño del arreglo
        Estudiante estudiante = new Estudiante(datosEstudiante[0],datosEstudiante[1],datosEstudiante[2],datosEstudiante[3]);
        return estudiante;
}
