package dto;

public class Usuario {

    private int UsuarioId;
    private String nombre;
    private String telefono;

    public Usuario() {
        ;
    }

    public void setUsuarioId(int contactoId) {
        this.UsuarioId = contactoId;
    }

    public int getUsuarioId() {
        return this.UsuarioId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return this.telefono;
    }

}
