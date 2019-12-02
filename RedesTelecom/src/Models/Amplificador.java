package Models;

/**
 *
 * @author ivantrejo
 */
public class Amplificador {
    public int IdAmplificador;
    public String nombre;
    public int PinMin;
    public int PinMax;
    public int PoutMin;
    public int PoutMax;
    public int Ganancia;
    public float costo;
    
    public String mensaje;

    public Amplificador(int IdAmplificador, String nombre, int PinMin, int PinMax, int PoutMin, int PoutMax, int Ganancia, float costo, String mensaje) {
        this.IdAmplificador = IdAmplificador;
        this.nombre = nombre;
        this.PinMin = PinMin;
        this.PinMax = PinMax;
        this.PoutMin = PoutMin;
        this.PoutMax = PoutMax;
        this.Ganancia = Ganancia;
        this.costo = costo;
        this.mensaje = mensaje;
    }
}
