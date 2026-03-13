import java.sql.*;

import connection.ConnectionPool;

import java.util.ArrayList;
import java.util.Scanner;

import Estudiantes.Alumno;
import Estudiantes.AlumnosService;
import Estudiantes.Grupo;
import Estudiantes.GruposService;
public class App {
    public static void listarGrupos(GruposService service){
        try {
            ArrayList<Grupo> grupos = service.requestAll();
            if(grupos.size() == 0){
                System.out.println("No hay grupos de alumnos");
            }
            else{
                for(Grupo g : grupos){
                    System.out.println(g);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/alumnos"; //jdbc:mysql://{host}:{port}/{database}
        String usuario = "juan";
        String clave = "12345";

        ConnectionPool pool = new ConnectionPool(url, usuario, clave);
        GruposService gservice = new GruposService(pool.getConnection());
        AlumnosService aservice = new AlumnosService(pool.getConnection());

        String nombre, profesor;
        long id;
        boolean salir = false;
        while(!salir){
            try {
                // Conexión a la base de datos
                System.out.println("1. Crear un grupo de alumnos");
                System.out.println("2. Editar un grupo de alumnos");
                System.out.println("3. Borrar un grupo de alumnos");
                System.out.println("4. Visualizar grupos de alumnos");
                System.out.println("5. Visualiza un grupo");
                System.out.println("6. Salir");
                int opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca el nombre del grupo: ");
                        nombre = sc.nextLine();
                        System.out.println("Introduzca el nombre del tutor: ");
                        profesor = sc.nextLine();
                        try {
                            id = gservice.create(new Grupo(0, nombre, profesor));    
                            System.out.printf("Grupo creado correctamente (id: %d)\n", id);
                        } catch (SQLException e) {
                            if(e.getErrorCode() == 1062){
                                System.out.println("El grupo ya existe con ese nombre");
                            }
                            
                        }
                        break;
                    case 2:
                        System.out.println("Elija el grupo a editar");
                        listarGrupos(gservice);
                        id = Integer.parseInt(sc.nextLine());
                        System.out.println("Introduzca el nombre del grupo: ");
                        nombre = sc.nextLine();
                        System.out.println("Introduzca el nombre del tutor: ");
                        profesor = sc.nextLine();
                        try {
                            int rowAffected = gservice.update(new Grupo(id, nombre, profesor));
                            if(rowAffected == 1)
                                System.out.println("Grupo actualizado correctamente");
                            else
                                System.out.println("No se ha podido actualizar el grupo");
                        } catch (SQLException e) {
                            System.out.println("No se ha podido actualizar el grupo");
                            System.out.println("Ocurrión una excepción: "+ e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Elija el grupo a borrar");
                        listarGrupos(gservice);
                        id = Integer.parseInt(sc.nextLine());
                        try {
                            gservice.delete(id);
                        } catch (SQLException e) {
                            // TODO: handle exception
                        }
                        break;
                    case 4:
                        listarGrupos(gservice);
                        break;
                    case 5:
                        System.out.println("Elija el grupo a visualizar");
                        listarGrupos(gservice);
                        id = Integer.parseInt(sc.nextLine());
                        Grupo grupo = gservice.requestById(id);
                        if(grupo!=null)
                            System.out.println(grupo);
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        break;
                }
                //TODO: Incluye llamadas para probar el servicio
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         
    }
}



