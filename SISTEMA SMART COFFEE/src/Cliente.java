import java.util.Objects;

public class Cliente extends Persona {

    private String codigoCliente;
    private String tipoMembresia;

    public Cliente() {
    }

    public Cliente(String nombre, String correo, int edad,
                   String codigoCliente, String tipoMembresia) {

        super(nombre, correo, edad);
        this.codigoCliente = codigoCliente;
        setTipoMembresia(tipoMembresia);
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(String tipoMembresia) {

        if (tipoMembresia.equalsIgnoreCase("Gold")
                || tipoMembresia.equalsIgnoreCase("Silver")
                || tipoMembresia.equalsIgnoreCase("Premium")) {

            this.tipoMembresia = tipoMembresia;

        } else {
            throw new IllegalArgumentException(
                    "Membresía inválida. Debe ser Gold, Silver o Premium.");
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Código: " + codigoCliente
                + ", Membresía: " + tipoMembresia;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Cliente cliente = (Cliente) obj;

        return Objects.equals(codigoCliente, cliente.codigoCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCliente);
    }
}