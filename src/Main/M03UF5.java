package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import manager.FileManager;
import static manager.FileManager.recogerValores;
import model.Departamento;
import model.Empleado;
import model.Incidencia;

public class M03UF5 {
   static FileReader leer = null;
    static BufferedReader buff = null;
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        FileManager.recogerValores();
        try {
         
            MainMenu();
            int opcion = pedirEntero("Elige una opción");

            switch (opcion) {

                case 1:
                    adminMenu();
                    
                    break;

                case 2:
                    FileManager.showEmpleadoInfo();
                    break;

                case 3:
                    LoginUser();
                    break;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void LoginUser(){

        
        
        String username = pedirCadena("Insertar nombre de usuario");
        String password = pedirCadena("Insertar contraseña");
        
        FileManager.userLogin(username, password);
        
    }
    public static void MainMenu() {

        System.out.println("[1] Entrar como Administrador");
        System.out.println("[2] Entrar como Gerente");
        System.out.println("[3] Entrar como usuario");
    }
    public static void userMenu(){
        System.out.println("[1] Crear Usuario");
        System.out.println("[2] Crear Departamento");
        System.out.println("[3] Modificar datos de Usuario");
        System.out.println("[4] Eliminar Usuario");
    }
    public static void adminMenu() throws IOException {

        System.out.println("[1] Crear Usuario");
        System.out.println("[2] Crear Departamento");
        System.out.println("[3] Modificar datos de Usuario");
        System.out.println("[4] Eliminar Usuario");
        System.out.println("[5] Listado de Incidencias por Departamento");
        System.out.println("[6] Listado de usuarios que no han solucionado Incidencias");
        int opcion = pedirEntero("Elige una opcion");

        switch (opcion) {

            case 1:
                createEmpleado();
                break;
            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

        }

    }

    
    

    public static void createEmpleado() throws IOException{
        
        String usuario = pedirCadena("Insertar su nombre de usuario");
        String password = pedirCadena("Insertar password");
        String nombre = pedirCadena("Insertar nonmbre");
        String apellidos = pedirCadena("Inserta sus apellidos");
        String ciudad = pedirCadena("Inserta su ciudad de residencia");
        String departamento = pedirCadena("Insertar su departamento");
        
        FileManager.crearEmpleado(usuario, password, nombre, apellidos, ciudad, departamento);
        
    }
    
    public void createDepartamento(){
        
        String nombre = pedirCadena("Inserta el nombre del departamento");
        int capacidad=  pedirEntero("Inserta su capacidad Máxima");
        String gerente = pedirCadena("Inserta el nombre del gerente a cargo");
        
        FileManager.crearDepartamento(nombre, capacidad, gerente);
       
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
