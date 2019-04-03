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

       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FileManager.recogerValores();
        try {

            MainMenu();
            int opcion = pedirEntero("Elige una opciÃ³n");

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

    public static void LoginUser() {

        String username = pedirCadena("Insertar nombre de usuario");
        String password = pedirCadena("Insertar contraseÃ±a");

        FileManager.userLogin(username, password);

    }

    public static void MainMenu() {

        System.out.println("[1] Entrar como Administrador");
        System.out.println("[2] Entrar como Gerente");
        System.out.println("[3] Entrar como usuario");
    }

    public static void userMenu() {
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

        
        
        do{
        switch (opcion) {

            case 1:
                createEmpleado();
                break;
            case 2:
                createDepartamento();
                break;

            case 3:
                adminModificarEmpleado();
                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

        }

    }while(opcion != 7);
        
    }

    public static void createEmpleado() throws IOException {

        String usuario = pedirCadena("Insertar su nombre de usuario");
        String password = pedirCadena("Insertar password");
        String nombre = pedirCadena("Insertar nonmbre");
        String apellidos = pedirCadena("Inserta sus apellidos");
        String ciudad = pedirCadena("Inserta su ciudad de residencia");
        String departamento = pedirCadena("Insertar su departamento");

        FileManager.crearEmpleado(usuario, password, nombre, apellidos, ciudad, departamento);

    }

    public static void createDepartamento() throws IOException {

        String nombre = pedirCadena("Inserta el nombre del departamento");
        int capacidad = pedirEntero("Inserta su capacidad MÃ¡xima");
        String gerente = pedirCadena("Inserta el nombre del gerente a cargo");

        FileManager.crearDepartamento(nombre, capacidad, gerente);

    }

    public static void adminModificarEmpleado() throws IOException {
        String usuario = pedirCadena("Usuario a modificar");
        String password = pedirCadena("Password de este usuario");
        if (FileManager.userExists(usuario, password)) {
            System.out.println("Inidica la secciÃ³n a modificar");
            System.out.println("[1] Nombre de usuario");
            System.out.println("[2] Nombre");
            System.out.println("[3] Apellidos");
            System.out.println("[4] Ciudad");
            System.out.println("[5] Departamento");
            int opcion = pedirEntero("Elige una opciÃ³n");

            switch (opcion) {

                case 1:
                    String newUsername = pedirCadena("Inserta el nuevo nombre de usuario");
                    FileManager.adminChangeUserValues(usuario, opcion, newUsername);
                    break;

                case 2:
                    String nombre = pedirCadena("Nuevo nombre");
                    FileManager.adminChangeUserValues(usuario, opcion, nombre);

                    break;

                case 3:
                    String apellidos = pedirCadena("Nuevo apellido");
                    FileManager.adminChangeUserValues(usuario, opcion, apellidos);
                    break;

                case 4:
                    String ciudad = pedirCadena("Nueva ciudad");
                    FileManager.adminChangeUserValues(usuario, opcion, ciudad);
                    break;

                case 5:

                    String departamento = pedirCadena("Nuevo departamento");
                    FileManager.adminChangeUserValues(usuario, opcion, departamento);

                    break;

            }

        }

     

    }
    
    public static void eliminarUsuario(){
        
        String username = pedirCadena("Inserta el usuario que deseas eliminar");
        String password = pedirCadena("Inserta la password para verificar su eliminaciÃ³n");
        
        
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
                System.out.println("Debes introducir un nï¿½mero entero.");
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
