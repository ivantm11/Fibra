package Models;

/**
 *
 * @author ivantrejo
 */
public class Atenuador {
    public int id;
    public String nombre;
    public float precio;
    public int atenuacion;
    
    public String mensaje;

    public Atenuador(int id, String nombre, float precio, int atenuacion, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.atenuacion = atenuacion;
        this.mensaje = mensaje;
    }
}
