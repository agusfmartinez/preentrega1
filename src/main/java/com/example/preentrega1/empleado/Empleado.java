public class Empleado {
    private int legajo;
    private String nombre;
    private String apellido;
    private String cuil;
    private Rol rol;
    private String email;

    public Empleado(int legajo, String nombre, String apellido, String cuil) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;

        char c = nombre.charAt(0);

        this.email = c + apellido + "@mail.com";
    }

    public int getLegajo() {
        return legajo;
    }

    public String getCuil() {
        return cuil;
    }

    public String getRol() {
        return rol;
    }

    public String getEmail() {
        return email;
    }

    public int getNombreCompleto() {
        return apellido + ", " + nombre;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


}
