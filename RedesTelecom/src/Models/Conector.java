package Models;

/**
 *
 * @author ivantrejo
 */
public class Conector {
    int id;
    String conector;
    int precio;
    String descripcion;
    String tipo;
    float PInsercion;

    public Conector(int id, String conector, int precio, String descripcion, String tipo, float PInsercion) {
        this.id = id;
        this.conector = conector;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.PInsercion = PInsercion;
    }
}
