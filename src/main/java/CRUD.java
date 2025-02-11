import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Scanner;

public class CRUD {
    private final static Scanner s = new Scanner(System.in);

    // Insertar Bus
    public static void insertarBus() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            System.out.print("Ingrese el registro del autobús: ");
            int registro = s.nextInt();
            System.out.print("Ingrese el tipo de autobús: ");
            String tipo = s.next();
            System.out.print("Ingrese la licencia del autobús: ");
            int licencia = s.nextInt();
            Bus bus = new Bus(registro, tipo, licencia);

            session.persist(bus);
            transaction.commit();
            System.out.println("Autobús insertado correctamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Actualizar Bus
    public static void actualizarBus() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            System.out.print("Ingrese el registro del autobús a actualizar: ");
            int registro = s.nextInt();

            Bus bus = session.get(Bus.class, registro);
            if (bus != null) {
                System.out.print("Ingrese el nuevo tipo de autobús: ");
                String nuevoTipo = s.next();
                System.out.print("Ingrese la nueva licencia del autobús: ");
                int nuevaLicencia = s.nextInt();

                bus.setTipo(nuevoTipo);
                bus.setLicencia(nuevaLicencia);

                session.merge(bus);
                transaction.commit();
                System.out.println("Autobús actualizado correctamente.");
            } else {
                System.out.println("No se encontró un autobús con el registro indicado.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }


    // Buscar Bus
    public static void buscarBus() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            System.out.print("Ingrese el registro del autobús a buscar: ");
            int registro = s.nextInt();

            Bus bus = session.get(Bus.class, registro);
            if (bus != null) {
                System.out.println("Detalles del Autobús:");
                System.out.println("Registro: " + bus.getRegistro());
                System.out.println("Tipo: " + bus.getTipo());
                System.out.println("Licencia: " + bus.getLicencia());
            } else {
                System.out.println("No se encontró un autobús con el registro indicado.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Eliminar Bus
    public static void eliminarBus() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            System.out.print("Ingrese el registro del autobús a eliminar: ");
            int registro = s.nextInt();

            Bus bus = session.get(Bus.class, registro);
            if (bus != null) {
                session.remove(bus);
                transaction.commit();
                System.out.println("Autobús eliminado correctamente.");
            } else {
                System.out.println("No se encontró un autobús con el registro indicado.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}

