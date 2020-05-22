package Dao.impl;

import Dao.FincaDao;
import Model.Administrador;
import Model.Finca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;

public class FincaDaoNio implements FincaDao {

    private final static String NOMBRE_ARCHIVO = "finca";
    private final static Path ARCHIVO = Paths.get(NOMBRE_ARCHIVO);
    private final static String FIELD_SEPARATOR = ",";
    private final static String RECORD_SEPARATOR = System.lineSeparator();

    public FincaDaoNio() {
        if (!Files.exists(ARCHIVO)) {
            try {
                Files.createFile(ARCHIVO);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    //Estos dos metodos registran la finca en un archivo txt
    @Override
    public void registrarFinca(Finca fincaIngresada) {
        String administradorString = parseFinca2String(fincaIngresada);
        byte[] datosRegistro = administradorString.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(datosRegistro);
        try (FileChannel fileChannel = FileChannel.open(ARCHIVO, APPEND)) {
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String parseFinca2String(Finca fincaIngresada) {
        StringBuilder sb = new StringBuilder();
        sb.append(fincaIngresada.getNombre()).append(FIELD_SEPARATOR)
                .append(fincaIngresada.getExtension()).append(RECORD_SEPARATOR);
        return sb.toString();
    }


    //Si la finca esta registrada estos dos metodos obtienen los datos y crean la finca
    public Finca obtenerFinca(){ ///Como hacer cuando solo se tiene un objeto en el archivo
        BufferedReader br = null;
        FileReader fr;
        try{
            fr = new FileReader(NOMBRE_ARCHIVO);
            br = new BufferedReader(fr);
            String fincaString = br.readLine();
            if ("".equals(fincaString)){
                Finca finca = parseFinca2Object(fincaString);
                return finca;
            }
                //Falta agregar los trabajadores y la caja a la finca
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private Finca parseFinca2Object(String fincaString) {
        String[] datosFinca = fincaString.split(FIELD_SEPARATOR);
        Finca fincaObject = new Finca(datosFinca[0],
                datosFinca[1]);
        return fincaObject;
    }

}

