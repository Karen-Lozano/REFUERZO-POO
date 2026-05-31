public class Persona {

    private String nombre;
    private String correo;
    private int edad;

    public Persona() {
    }

    public Persona(String nombre, String correo, int edad) {
        this.nombre = nombre;
        setCorreo(correo);
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo.contains("@")) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("Correo inválido.");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 18 && edad <= 60) {
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("La edad debe estar entre 18 y 60 años.");
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Correo: " + correo +
                ", Edad: " + edad;
    }
}
