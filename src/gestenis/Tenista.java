package gestenis;

import java.io.*;
import java.util.ArrayList;


/**
 * @author david
 *
 */
public class Tenista {
    private String nombre;
    private int edad;
    private ArrayList<Torneo> palmares;
    
    /**
     * @param nombre
     * @param edad
     */
    Tenista(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
        //lista de torneos
        palmares=new ArrayList<Torneo>();
    }

    /**
     * Obtenemos el nombre del tenista
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asignamos el nombre del tenista
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return Nos devuelve la edad del tenista
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Asigna la edad del tenista
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /*
     * Devuelve el palmarés con los nombres de los torneos ganados
     * @return
     */
    public String[] getPalmares(){
        String[] p = new String[palmares.size()];
        for(int i=0;i<p.length;i++){
            p[i] = palmares.get(i).getNombreTorneo();
        }
        return p;
    }
    /**
     * Añade el torneo ganado al palmarés
     * @param torneo
     */
    public void aniadirPalmares(Torneo torneo){
        palmares.add(torneo);
    }
    
    /*
     * Recorre un bucle acumulando la puntuación obtenida
     * 
     */
    public int getPuntuacionATP(){
    	int p = 1;
        p = 0;
        for(Torneo t:palmares){
            p += t.getPuntuacion();
        }
        return p;
    }
    /**
     * Carga en fichero el archivo seleccionado e introduce
     * sus datos en el ArrayList Tenista
     * @param fichero
     * @return devuelve lista
     */
	public static ArrayList<Tenista> cargar(File fichero){
        ArrayList<Tenista> l = null;
        ObjectInputStream ficheroEntrada = null;
        try{
            ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
            l = (ArrayList<Tenista>) ficheroEntrada.readObject();
            ficheroEntrada.close();
            return l;
        }catch(ClassNotFoundException onfe){
            return null;
        }catch(FileNotFoundException fnfe){
            return null;
        }catch(IOException ioe){
            return null;
        }
    }
    /**
     * Graba en fichero los datos del ArrayList lista
     * @param lista
     * @param fichero
     * @return true si ha sido todo correcto o false en caso contrario
     */
    public static boolean guardar(ArrayList<Tenista> lista, File fichero){
        try{
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
            ficheroSalida.writeObject(lista);
            ficheroSalida.flush();
            ficheroSalida.close();
            return true;
        }catch(FileNotFoundException fnfe){
            return false;
        }catch(IOException ioe){
            return false;
        }
    }
}