package gestenis;

import java.io.*;
import java.util.ArrayList;


/**
 * @author david
 *
 */
public class Torneo  {
	
	/*//No usado:
    public static String GRAND_SLAM = "Grand Slam";
    public static String MASTER1000 = "ATP World Tour Master 1000";
    public static String MASTER500 = "ATP World Tour 500";
    public static String MASTER250 = "ATP World Tour 250";
    */
    private String nombreTorneo;
    private int puntuacion;
    
    
    /**
     * @param nombreTorneo
     * @param puntuacion
     */
    Torneo (String nombreTorneo,int puntuacion){
        this.nombreTorneo=nombreTorneo;
        this.puntuacion=puntuacion;
    }

    /**
     * 
     * @return Devuelve el nombre del torneo
     */
    public String getNombreTorneo() {
        return nombreTorneo;
    }

    /**
     * Asignamos un nombre de torneo
     * @param nombreTor del torneo
     */
    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    /**
     * 
     * @return Devuelve la puntuación asignada al torneo
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * 
     * @param Introducimos la puntuación asignada para el torneo
     */
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    /**
     * Carga los datos del fichero en el ArrayList lista
     * @param fichero
     * @return devuelve true si todo ha ido bien o false si ha fallado algo
     */
    public static ArrayList<Torneo> cargar(File fichero){
        ArrayList<Torneo> lista = null;
        try{
        	lista = new ArrayList<Torneo>();
            ObjectInputStream ficheroEntrada = null;
            ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
            lista = (ArrayList<Torneo>) ficheroEntrada.readObject();
            ficheroEntrada.close();
            return lista;
        }catch(ClassNotFoundException cnfe){
            return null;
        }catch(FileNotFoundException fnfe){
            return null;
        }catch (IOException ioe){
            return null;
        }
    }
    /**
     * Guarda los datos del ArrayList lista en el fichero fichero
     * @param lista
     * @param fichero
     * @return Si todo ha ido bien devuelve true y en caso contrario false
     */
    public static boolean guardar(ArrayList<Torneo> lista,File fichero){
        try{
        	//Fichero de salida
            ObjectOutputStream sal = null; 
            sal = new ObjectOutputStream(new FileOutputStream (fichero));
            sal.writeObject(lista);
            sal.flush();
            sal.close();
            return true;
        }catch(FileNotFoundException fnfe){
            return false;
        }catch(IOException ioe){
            return false;
        }
    }
    
}