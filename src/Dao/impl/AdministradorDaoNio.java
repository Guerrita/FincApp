package Dao.impl;

import Dao.AdministradorDao;
import Model.Administrador;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;

public class AdministradorDaoNio implements AdministradorDao {
    private static Administrador administrador;

    private final static String NOMBRE_ARCHIVO = "administrador";
    private final static Path ARCHIVO = Paths.get(NOMBRE_ARCHIVO);
    private final static String FIELD_SEPARATOR = ",";
    private final static String RECORD_SEPARATOR = System.lineSeparator();

    public AdministradorDaoNio() {
        if (!Files.exists(ARCHIVO)) {
            try {
                Files.createFile(ARCHIVO);
            } catch (IOException ioe) {
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
        try (FileChannel fileChannel = FileChannel.open(ARCHIVO, APPEND)) {
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
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


    public static void obtenerAdministrador() throws IOException { ///Como hacer cuando solo se tiene un objeto en el archivo
        BufferedReader br = null;
        FileReader fr;
        try{
             fr = new FileReader(NOMBRE_ARCHIVO);
             br = new BufferedReader(fr);
            String admin = br.readLine();
            administrador = parseAdministrador2Object(admin);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Administrador getAdministrador() {
        return administrador;
    }

    private static Administrador parseAdministrador2Object(String administradorString) {
        String[] datosAdministrador = administradorString.split(FIELD_SEPARATOR);
        //ToDo: validar el tamaño del arreglo
        Administrador administrador = new Administrador(datosAdministrador[0],
                datosAdministrador[1],
                datosAdministrador[2],
                datosAdministrador[3],
                datosAdministrador[4]);
        return administrador;
    }
}
