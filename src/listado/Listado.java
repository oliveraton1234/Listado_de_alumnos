package Listado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import exepciones.AlumnosExistenteExeption;
import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;
import exepciones.GuardarArchivoExeption;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import model.Alumno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Listado implements Serializable {

    private ArrayList<Alumno> alumnos;

    public Controller() throws CargarArchivoExption, ArchivoInvalidoExeption {
        cargar();
    }

    public Alumno getAlumno(int inx) {
        return alumnos.get(inx);
    }

    public boolean add(Alumno alumno) throws AlumnosExistenteExeption {
        if (alumnos.contains(alumno))
        {
            throw new AlumnosExistenteExeption("El numero de control de control ya existe");
        }
        return alumnos.add(alumno);
    }

    public int cantidadAlumnos() {
        return alumnos.size();
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }



    public void guardar() throws FileNotFoundException, IOException, GuardarArchivoExeption {
        
        try
        {
            File file = new File("Guardar.dat");
            FileOutputStream ouput = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(ouput);

            writer.writeObject(alumnos);

            writer.close();
            ouput.close();
        } catch (IOException e)
        {
            throw new GuardarArchivoExeption("Hubo un error en disco duro");
        }

    }

    public void cargar() throws CargarArchivoExption, ArchivoInvalidoExeption {
        
        File file = new File("Guardar.dat");
        if (file.exists())
        {
            try
            {
                FileInputStream input = new FileInputStream(file);
                ObjectInputStream reader = new ObjectInputStream(input);

                alumnos = (ArrayList<Alumno>) reader.readObject();

                reader.close();
                input.close();
            } catch (IOException e)
            {
                throw new CargarArchivoExption("Error al cargar el archivo");

            } catch (ClassNotFoundException e)
            {
                throw new ArchivoInvalidoExeption("El archivo ah sido corrompido");
    //            
            }

        } else
        {
            alumnos = new ArrayList<>();

        }

    }

    public String buscarAlumno(String id) {
        for (Alumno alumno : alumnos)
        {
            if (alumno.getNoCOntrol().equals(id))
            {
                return String.format("Numero de control: %s \n"
                        + " Nombre: %s \n"
                        + " Apellido paterno: %s \n"
                        + " Apellido materno: %s \n"
                        + " Carrera: %s \n"
                        + " Calificacion: %.2f \n", alumno.getNoCOntrol(),alumno.getNombre(), alumno.getPaterno(),alumno.getMaterno(),alumno.getCarrera(),alumno.getCalificacion());
            }
        }

        return "El alumno no existe";

    }

    public String borrarAlumno(String id){
        for (Alumno alumno : alumnos)
        {
            if (alumno.getNoCOntrol().equals(id))
            {
                Alumno prueba = alumno;
                alumnos.remove(alumno);
                return String.format("El alumno con los siguientes datos ah sido borrado\n\n" +
                        " Numero de control: %s \n"
                        + " Nombre: %s \n"
                        + " Apellido paterno: %s \n"
                        + " Apellido materno: %s \n"
                        + " Carrera: %s \n"
                        + " Calificacion: %.2f \n", prueba.getNoCOntrol(),prueba.getNombre(), prueba.getPaterno(),prueba.getMaterno(),prueba.getCarrera(),prueba.getCalificacion());

            }
        }

        return "El alumno no existe";

    }

    public void crear() {
        alumnos = new ArrayList<>();
    }
}