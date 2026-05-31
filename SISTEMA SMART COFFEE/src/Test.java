import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cafeteria cafeteria = new Cafeteria("Smart Coffee");

        int opcion;

        do {

            System.out.println("\n========= SMART COFFEE =========");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Registrar pedido");
            System.out.println("4. Actualizar pedido");
            System.out.println("5. Eliminar pedido");
            System.out.println("6. Mostrar promedio de consumo");
            System.out.println("7. Mostrar mejor cliente");
            System.out.println("8. Buscar cliente por correo");
            System.out.println("9. Mostrar pedidos registrados");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            try {

                switch (opcion) {

                    case 1:

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Correo: ");
                        String correo = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Código cliente: ");
                        String codigo = sc.nextLine();

                        System.out.print("Tipo membresía (Gold/Silver/Premium): ");
                        String membresia = sc.nextLine();

                        Cliente cliente = new Cliente(
                                nombre,
                                correo,
                                edad,
                                codigo,
                                membresia);

                        if (cafeteria.registrarCliente(cliente)) {
                            System.out.println("Cliente registrado.");
                        } else {
                            System.out.println("Cliente duplicado.");
                        }

                        break;

                    case 2:
                        cafeteria.mostrarClientes();
                        break;

                    case 3:

                        System.out.print("Correo cliente: ");
                        correo = sc.nextLine();

                        System.out.print("Consumo: ");
                        double consumo = sc.nextDouble();

                        cafeteria.registrarPedido(correo, consumo);

                        break;

                    case 4:

                        sc.nextLine();

                        System.out.print("Correo cliente: ");
                        correo = sc.nextLine();

                        System.out.print("Nuevo consumo: ");
                        double nuevo = sc.nextDouble();

                        cafeteria.actualizarPedido(correo, nuevo);

                        break;

                    case 5:

                        sc.nextLine();

                        System.out.print("Correo cliente: ");
                        correo = sc.nextLine();

                        cafeteria.eliminarPedido(correo);

                        break;

                    case 6:

                        System.out.println(
                                "Promedio consumo: $"
                                        + cafeteria.promedioConsumo());

                        break;

                    case 7:
                        cafeteria.mejorCliente();
                        break;

                    case 8:

                        System.out.print("Correo: ");
                        correo = sc.nextLine();

                        Cliente encontrado =
                                cafeteria.buscarClientePorCorreo(correo);

                        if (encontrado != null) {
                            System.out.println(encontrado);
                        } else {
                            System.out.println("Cliente no encontrado.");
                        }

                        break;

                    case 9:
                        cafeteria.mostrarPedidos();
                        break;

                    case 10:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }

        } while (opcion != 10);

        sc.close();
    }
}