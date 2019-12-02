package Models;

/**
 *
 * @author ivantrejo
 */
public class Atenuador {
    int id;
    String nombre;
    float precio;
    int atenuacion;

    public Atenuador(int id, String nombre, float precio, int atenuacion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.atenuacion = atenuacion;
    }
}
