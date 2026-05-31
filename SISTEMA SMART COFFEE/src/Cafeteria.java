import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Cafeteria implements CrudPedido {

    private String nombreCafeteria;

    private HashSet<Cliente> clientes = new HashSet<>();

    private Map<String, Double> mapaPedidos = new HashMap<>();

    public Cafeteria(String nombreCafeteria) {
        this.nombreCafeteria = nombreCafeteria;
    }

    public boolean registrarCliente(Cliente cliente) {
        return clientes.add(cliente);
    }

    public Cliente buscarClientePorCorreo(String correo) {

        for (Cliente c : clientes) {
            if (c.getCorreo().equalsIgnoreCase(correo)) {
                return c;
            }
        }

        return null;
    }

    public void mostrarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("No existen clientes.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    @Override
    public void registrarPedido(String correo, double consumo) {

        Cliente cliente = buscarClientePorCorreo(correo);

        if (cliente == null) {
            System.out.println("Cliente no existe.");
            return;
        }

        if (consumo <= 0) {
            System.out.println("El consumo debe ser mayor que cero.");
            return;
        }

        mapaPedidos.put(cliente.getCodigoCliente(), consumo);

        System.out.println("Pedido registrado.");
    }

    @Override
    public void actualizarPedido(String correo, double nuevoConsumo) {

        Cliente cliente = buscarClientePorCorreo(correo);

        if (cliente == null) {
            System.out.println("Cliente no existe.");
            return;
        }

        String codigo = cliente.getCodigoCliente();

        if (!mapaPedidos.containsKey(codigo)) {
            System.out.println("Pedido inexistente.");
            return;
        }

        mapaPedidos.put(codigo, nuevoConsumo);

        System.out.println("Pedido actualizado.");
    }

    @Override
    public void eliminarPedido(String correo) {

        Cliente cliente = buscarClientePorCorreo(correo);

        if (cliente == null) {
            System.out.println("Cliente no existe.");
            return;
        }

        String codigo = cliente.getCodigoCliente();

        if (!mapaPedidos.containsKey(codigo)) {
            System.out.println("Pedido inexistente.");
            return;
        }

        mapaPedidos.remove(codigo);

        System.out.println("Pedido eliminado.");
    }

    @Override
    public double promedioConsumo() {

        if (mapaPedidos.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return 0;
        }

        double suma = 0;

        for (double valor : mapaPedidos.values()) {
            suma += valor;
        }

        return suma / mapaPedidos.size();
    }

    @Override
    public void mejorCliente() {

        if (mapaPedidos.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return;
        }

        String mejorCodigo = "";
        double mayor = 0;

        for (Map.Entry<String, Double> entry : mapaPedidos.entrySet()) {

            if (entry.getValue() > mayor) {
                mayor = entry.getValue();
                mejorCodigo = entry.getKey();
            }
        }

        for (Cliente c : clientes) {

            if (c.getCodigoCliente().equals(mejorCodigo)) {

                System.out.println("Mejor cliente:");
                System.out.println(c);
                System.out.println("Consumo: $" + mayor);
                return;
            }
        }
    }

    public void mostrarPedidos() {

        if (mapaPedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }

        for (Map.Entry<String, Double> pedido : mapaPedidos.entrySet()) {
            System.out.println(
                    "Código Cliente: " + pedido.getKey()
                            + " | Consumo: $" + pedido.getValue());
        }
    }
}