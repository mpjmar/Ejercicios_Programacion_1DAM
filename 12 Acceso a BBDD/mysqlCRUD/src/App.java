import java.sql.*;

import connection.ConnectionPool;

import java.util.ArrayList;
import java.util.Scanner;

import centro_educativo.Alumno;
import centro_educativo.AlumnosService;
import centro_educativo.Grupo;
import centro_educativo.GruposService;

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
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
    }

    public static void listarAlumnos(AlumnosService service){
        try {
            ArrayList<Alumno> alumnos = service.requestAll();
            if(alumnos.size() == 0){
                System.out.println("No hay alumnos");
            }
            else{
                for(Alumno a : alumnos){
                    System.out.println(a);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
    }

    public static void listarAlumnosPorGrupo(AlumnosService service, long idGrupo){
        try {
            ArrayList<Alumno> alumnos = service.requestAll();
            if(alumnos.size() == 0){
                System.out.println("No hay alumnos");
            }
            else{
                for(Alumno a : alumnos){
					if (a.getGrupoId() == idGrupo)
                    	System.out.println(a);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/centro_educativo"; //jdbc:mysql://{host}:{port}/{database}
        String usuario = "paz";
        String clave = "1234";

        ConnectionPool pool = new ConnectionPool(url, usuario, clave);
        GruposService gservice = new GruposService(pool.getConnection());
        AlumnosService aservice = new AlumnosService(pool.getConnection());

        String nombre, profesor;
		String nombreAlum, apeAlum, respuesta;
        long id = -1, idAlum = -1;
        boolean salir = false;
        while(!salir){
            try {
                // Conexión a la base de datos
                System.out.println("1. Crear un grupo de alumnos");
                System.out.println("2. Editar un grupo de alumnos");
                System.out.println("3. Borrar un grupo de alumnos");
                System.out.println("4. Visualizar grupos de alumnos");
                System.out.println("5. Visualizar un grupo");
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
                                System.out.println("Ya existe un grupo con ese nombre");
                            }
                        }
						do {
							System.out.println("¿Desea añadir un alumno? (s/n)");
							respuesta = System.console().readLine().toLowerCase();
							if (respuesta.equals("s")) {
								System.out.println("Introduzca el nombre del alumno: ");
								nombreAlum = System.console().readLine();
								System.out.println("Introduzca los apellidos del alumno: ");
								apeAlum = System.console().readLine();
								try {
									idAlum = aservice.create(new Alumno(0, nombreAlum, apeAlum, id));
									System.out.printf("Alumno creado correctamente (id: %d)\n", idAlum);
								} catch (SQLException e) {
									if(e.getErrorCode() == 1062){
										System.out.println("Ya existe un alumno con ese nombre");
									}
								}
							}
							else
								System.out.println("Debe introducir una respuesta válida (s/n)");
						} while (!respuesta.equals("n"));	
                        break;
                    case 2:
                        System.out.println("Elija el grupo a editar");
                        listarGrupos(gservice);
                        id = Integer.parseInt(sc.nextLine());
						System.out.println("¿Desea editar el grupo o un alumno? (g/a): ");
						respuesta = System.console().readLine().toLowerCase();
						if (respuesta.equals("g")) {
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
								System.out.println("Ocurrió una excepción: "+ e.getMessage());
							}
						}
						else if (respuesta.equals("a")) {
							System.out.println("Elija el alumno a editar: ");
							listarAlumnosPorGrupo(aservice, id);
							System.out.println("Introduzca el ID del alumno: ");
							idAlum = Long.parseLong(System.console().readLine());
							System.out.println("Introduzca el nombre del alumno: ");
							nombreAlum = sc.nextLine();
							System.out.println("Introduzca los apellidos del alumno: ");
							apeAlum = sc.nextLine();
							try {
								int rowAffected = aservice.update(new Alumno(idAlum, nombreAlum, apeAlum, id));
								if(rowAffected == 1)
									System.out.println("Grupo actualizado correctamente");
								else
									System.out.println("No se ha podido actualizar el grupo");
							} catch (SQLException e) {
								System.out.println("No se ha podido actualizar el grupo");
								System.out.println("Ocurrió una excepción: "+ e.getMessage());
							}
						}
						else
							System.out.println("Debe introducir una respuesta válida (g/a)");
                        break;
                    case 3:
                        System.out.println("Elija el grupo a borrar");
                        listarGrupos(gservice);
                        id = Integer.parseInt(sc.nextLine());
                        try {
                            gservice.delete(id);
                        } catch (SQLException e) {
                            System.out.println("Ha ocurrido un error.");
            				e.printStackTrace();
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
                        if(grupo!=null) {
                            System.out.println(grupo);
							listarAlumnosPorGrupo(aservice, id);
						}
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         
    }
}



