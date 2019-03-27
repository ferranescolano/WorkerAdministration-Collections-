
package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;
import model.Departamento;
import model.Empleado;
import model.Incidencia;


public class FileManager {
    
    
    private int token;
    static File fileIncidencia = new File("incidencias.txt");
    static File fileEmpleados = new File("empleados.txt");
    static File fileDepartamentos = new File("departamentos.txt");
    static FileReader leer = null;
    //static BufferedReader buff = null;
            private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static TreeSet<Empleado> treeSetEmpleados = new TreeSet<>();
    private static ArrayList<Incidencia> arrayListIncidencias = new ArrayList<>();
    private static HashSet<Departamento> hashSetDepartamentos = new HashSet<>();


     public static File route(String fileString) {

        String rutaActual = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaFichero = rutaActual + separador + fileString;
        File f = new File(rutaFichero);
        return f;
    }
public static void showEmpleadoInfo(){
    
    for(Empleado e: treeSetEmpleados){
        System.out.println(e.getNombre());
    }
}
 
     public static void recogerValores() throws IOException, FileNotFoundException, ParseException {
        if (fileDepartamentos.exists()) { recogerDepartamentos(); }
        if (fileIncidencia.exists()) { recogerIncidencias(); }
        if (fileEmpleados.exists()) { recogerEmpleados(); }
    }
     
        public static void recogerEmpleados() throws FileNotFoundException, IOException {
        String fileString = "empleados.txt";
        File f = route(fileString);

        if (f.exists()) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String usuario = datos[0];
                String password = datos[1];
                String nombre = datos[2];
                String apellido = datos[3];
                String fechaContratacion = datos[4];
                String ciudadResidencia = datos[5];
                String departamento = datos[6];
                Departamento d = searchDepartmentByName(departamento);
                //Constructor añadido por defecto, CUIDADO              
                Empleado e = new Empleado(usuario, password, nombre, apellido, fechaContratacion, ciudadResidencia, d);
                treeSetEmpleados.add(e);
                if (fr != null) {
                    fr.close();
                }

            }
        }

    }
        
        
   public static void recogerIncidencias() throws FileNotFoundException, IOException, ParseException {
                String fileString = "incidencias.txt";
        File f = route(fileString);

        if (f.exists()) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String departamento = datos[0];
                String tipoPlazo = datos[1];
                String detalle = datos[2];
                //Parse date
                /*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                
                
               
                Date fecha1 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);*/
                 
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                 String fecha = datos[3]; 
                 
                Date fecha1 = formatter.parse(fecha);
                Boolean completada = Boolean.parseBoolean(datos[4]);
                 //Constructor añadido por defecto, CUIDADO
                 Departamento objdepartamento = searchDepartmentByName(departamento);
                Incidencia i = new Incidencia(objdepartamento, tipoPlazo, detalle,fecha1, completada);
                arrayListIncidencias.add(i);

            }
            if (fr != null) {
                fr.close();
            }
        }
    }
   
//   public static Incidencia searchIncidenciaByName(String incidencia){
//       
//       for (Incidencia i: arrayListIncidencias){
//           if(i.get)
//       }
//   }
   
   public static Departamento searchDepartmentByName(String departamento){
       
       for(Departamento d: hashSetDepartamentos){
           if(d.getNombreDepartamento().equalsIgnoreCase(departamento)){
               return d;
           }
       }
        return null;
   }
   
   public static void userLogin(String username, String password){
       
       
   }
   
   public static void recogerDepartamentos() throws IOException {
        String fileString = "departamentos.txt";
        File f = route(fileString);
        if (f.exists()) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombreDepartamento = datos[0];
                int capacidadMax = Integer.parseInt(datos[1]);
                String gerente = datos[2];
                Departamento d = new Departamento(nombreDepartamento, capacidadMax, gerente);
                hashSetDepartamentos.add(d);        
            }
             if (fr != null) {
                    fr.close();
                }
        }
    }

   
   
    public static int pedirEntero(String texto) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean error;
        do {

            try {
                System.out.println(texto);
                num = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
                error = true;
            } catch (NumberFormatException ex) {
                System.out.println("Debes introducir un n�mero entero.");
                error = true;
            }
        } while (error);
        return num;
    }

    public static String pedirCadena(String texto) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        do {
            try {
                System.out.println(texto);
                cadena = br.readLine();
                if (cadena.equals("")) {
                    System.out.println("No se puede dejar el campo en blanco.");
                }
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
            }
        } while (cadena.equals(""));
        return cadena;
    }
    
 
}


