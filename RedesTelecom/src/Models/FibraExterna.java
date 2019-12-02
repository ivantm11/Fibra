package Models;


public class FibraExterna {
    public int id;
    public String fabricante;
    public String tipo;
    public int wl;
    public float atenuacion;
    public int bw;
    public int lc;
    public float costo;
    
    public String mensaje;
    
    public FibraExterna(int id, String fab, String tipo, int wl, float atenuacion, int bw, int lc, float costo, String mensaje) {
        this.id = id;
        this.fabricante = fab;
        this.tipo = tipo;
        this.wl = wl;
        this.atenuacion = atenuacion;
        this.bw = bw;
        this.lc = lc;
        this.costo = costo;
        
        this.mensaje = mensaje;
    }
}
