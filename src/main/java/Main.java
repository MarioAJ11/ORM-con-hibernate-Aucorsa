import java.util.Scanner;

public class Main {
    private final static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        int opc;
        while (!salir) {
            System.out.println("======= Bus Menú =======");
            System.out.println("1. Insertar Autobús");
            System.out.println("2. Actualizar Autobús");
            System.out.println("3. Buscar Autobús");
            System.out.println("4. Eliminar Autobús");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opc = s.nextInt();
            s.nextLine();

            switch (opc) {
                case 1:
                    CRUD.insertarBus();
                    break;
                case 2:
                    CRUD.actualizarBus();
                    break;
                case 3:
                    CRUD.buscarBus();
                    break;
                case 4:
                    CRUD.eliminarBus();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Hasta la próxima jefe :)");
                    HibernateUtil.atomarporculo();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
