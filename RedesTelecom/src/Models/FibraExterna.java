package Models;

/**
 *
 * @author ivantrejo
 */
public class FibraExterna {
    int id;
    String fabricante;
    String tipo;
    int wl;
    float atenuacion;
    int bw;
    int lc;
    float costo;
    
    public FibraExterna(int id, String fab, String tipo, int wl, float atenuacion, int bw, int lc, float costo) {
        this.id = id;
        this.fabricante = fab;
        this.tipo = tipo;
        this.wl = wl;
        this.atenuacion = atenuacion;
        this.bw = bw;
        this.lc = lc;
        this.costo = costo;
    }
}
