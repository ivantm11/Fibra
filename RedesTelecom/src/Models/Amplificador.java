package Models;

/**
 *
 * @author ivantrejo
 */
public class Amplificador {
    int IdAmplificador;
    String nombre;
    int PinMin;
    int PinMax;
    int PoutMin;
    int PoutMax;
    int Ganancia;
    float costo;

    public Amplificador(int IdAmplificador, String nombre, int PinMin, int PinMax, int PoutMin, int PoutMax, int Ganancia, float costo) {
        this.IdAmplificador = IdAmplificador;
        this.nombre = nombre;
        this.PinMin = PinMin;
        this.PinMax = PinMax;
        this.PoutMin = PoutMin;
        this.PoutMax = PoutMax;
        this.Ganancia = Ganancia;
        this.costo = costo;
    }
}
