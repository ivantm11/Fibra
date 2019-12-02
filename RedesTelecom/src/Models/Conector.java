package Models;

/**
 *
 * @author ivantrejo
 */
public class Conector {
    public int id;
    public String conector;
    public int precio;
    public String descripcion;
    public String tipo;
    public float PInsercion;
    
    public String mensaje;

    public Conector(int id, String conector, int precio, String descripcion, String tipo, float PInsercion, String mensaje) {
        this.id = id;
        this.conector = conector;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.PInsercion = PInsercion;
        this.mensaje = mensaje;
    }
}
