import centro_educativo.Alumno;
import centro_educativo.Grupo;
import centro_educativo.ModelService;
import connection.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	private static final String[] aColumnsAll = {"id", "nombre", "apellidos", "grupo_id"};
	private static final String[] aColumnsInsert = {"nombre", "apellidos", "grupo_id"};
	private static final String[] gColumnsAll = {"id", "nombre", "profesor"};
	private static final String[] gColumnsInsert = {"nombre", "profesor"};

    public static void listarGrupos(ModelService<Grupo> service){
        try {
            ArrayList<Grupo> grupos = service.requestAll("grupo", gColumnsAll);
            if(grupos.isEmpty()){
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

    public static void listarAlumnos(ModelService<Alumno> service){
        try {
            ArrayList<Alumno> alumnos = service.requestAll("alumno", aColumnsAll);
            if(alumnos.isEmpty()){
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

    public static void listarAlumnosPorGrupo(ModelService<Alumno> service, long idGrupo){
        try {
            ArrayList<Alumno> alumnos = service.requestAll("alumno", aColumnsAll);
            if(alumnos.isEmpty()){
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
        ModelService<Grupo> gService = new ModelService<>(pool.getConnection());
        ModelService<Alumno> aService = new ModelService<>(pool.getConnection());

        String nombre, profesor;
		String nombreAlum, apeAlum, respuesta;
        long id = -1, idAlum;
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
							Grupo nuevoGrupo = new Grupo(nombre, profesor);
                            id = gService.create("grupo", gColumnsInsert, nuevoGrupo);
							nuevoGrupo.setId(id);
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
									Alumno nuevoAlumno = new Alumno(nombreAlum, apeAlum, id);
									idAlum = aService.create("alumno", aColumnsInsert, nuevoAlumno);
									nuevoAlumno.setId(idAlum);
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
                        listarGrupos(gService);
                        id = Integer.parseInt(sc.nextLine());
						System.out.println("¿Desea editar el grupo o un alumno? (g/a): ");
						respuesta = System.console().readLine().toLowerCase();
						if (respuesta.equals("g")) {
							System.out.println("Introduzca el nombre del grupo: ");
							nombre = sc.nextLine();
							System.out.println("Introduzca el nombre del tutor: ");
							profesor = sc.nextLine();
							try {
								int rowAffected = gService.update("grupo", gColumnsAll, new Grupo(id, nombre, profesor));
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
							listarAlumnosPorGrupo(aService, id);
							System.out.println("Introduzca el ID del alumno: ");
							idAlum = Long.parseLong(System.console().readLine());
							System.out.println("Introduzca el nombre del alumno: ");
							nombreAlum = sc.nextLine();
							System.out.println("Introduzca los apellidos del alumno: ");
							apeAlum = sc.nextLine();
							try {
								int rowAffected = aService.update("alumno", aColumnsAll, new Alumno(idAlum, nombreAlum, apeAlum, id));
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
                        listarGrupos(gService);
                        id = Integer.parseInt(sc.nextLine());
                        try {
                            gService.delete("grupo", id);
                        } catch (SQLException e) {
                            System.out.println("Ha ocurrido un error.");
            				e.printStackTrace();
                        }
                        break;
                    case 4:
                        listarGrupos(gService);
                        break;
                    case 5:
                        System.out.println("Elija el grupo a visualizar");
                        listarGrupos(gService);
                        id = Integer.parseInt(sc.nextLine());
                        Grupo grupo = gService.requestById("grupo", gColumnsAll, id);
                        if(grupo!=null) {
                            System.out.println(grupo);
							listarAlumnosPorGrupo(aService, id);
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
        sc.close(); 
    }
}



