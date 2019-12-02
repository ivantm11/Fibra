package redestelecom;

import Models.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ivantrejo
 */
public class BaseDatos {
    private final Connection conexionSQL;
    
    public BaseDatos(Connection conexionSQL) {
        this.conexionSQL = conexionSQL;
    }
    
    public Amplificador getAmplificador() throws SQLException {
        return this.loadAmplificador();
    }
    
    public Atenuador getAtenuador() throws SQLException {
        return this.loadAtenuador();
    }
    
    public Conector getConector() throws SQLException {
        return this.loadConector();
    }
    
    public Empalme getEmpalme() throws SQLException {
        return this.loadEmpalme();
    }
    
    public FibraExterna getFibraExterna(int WL) throws SQLException {
        return this.loadFibraExterna(WL);
    }
    
    public FibraInterna getFibraInterna(int WL) throws SQLException {
        return this.loadFibraInterna(WL);
    }
    
    public Receptor getReceptor(int WL) throws SQLException {
        return this.loadReceptor(WL);
    }
    
    public TransmisorOptico getTransmisorOptico(int WL) throws SQLException {
        return this.loadTransmisorOptico(WL);
    }
    
    private Amplificador loadAmplificador() throws SQLException {
        String instruccion;
        Statement consulta;
        ResultSet respuesta;
        ResultSet res;
        consulta = this.conexionSQL.createStatement();
        instruccion =  "select * from amplificadores order by costo";
        respuesta = consulta.executeQuery(instruccion);
        
        respuesta.next();
        int id = respuesta.getInt("IdAmplificador");
        String nombre = respuesta.getString("nombre");
        int PinMin = respuesta.getInt("PinMin");
        int PinMax = respuesta.getInt("PinMax");
        int PoutMin = respuesta.getInt("PoutMin");
        int PoutMax = respuesta.getInt("PoutMax");
        int Ganancia = respuesta.getInt("Ganancia");
        float costo = respuesta.getFloat("costo");
        
        respuesta.close();
        
        Amplificador resultado = new Amplificador(id, nombre, PinMin, PinMax, PoutMin, PoutMax, Ganancia, costo);
        
        String respuestaFO = nombre + " " + Ganancia;
        System.out.println("Amplificador: " + respuestaFO);
        
        return resultado;
    }
    
    private Atenuador loadAtenuador() throws SQLException {
        String instruccion;
        Statement consulta;
        ResultSet respuesta;
        ResultSet res;
        consulta = this.conexionSQL.createStatement();
        instruccion =  "select * from atenuadores order by precio";
        respuesta = consulta.executeQuery(instruccion);
        
        respuesta.next();
        
        int id = respuesta.getInt("IdAtenuadores");
        String nombre = respuesta.getString("nombre");
        float precio = respuesta.getFloat("precio");
        int atenuacion = respuesta.getInt("atenuacion");
        
        respuesta.close();
        
        Atenuador resultado = new Atenuador(id, nombre, precio, atenuacion);
        
        String respuestaFO = nombre + " " + atenuacion;
        System.out.println("Atenuador: " + respuestaFO);
        
        return resultado;
    }
    
    private Conector loadConector() throws SQLException {
        String instruccion;
        Statement consulta;
        ResultSet respuesta;
        ResultSet res;
        consulta = this.conexionSQL.createStatement();
        instruccion =  "select * from conectores order by precio";
        respuesta = consulta.executeQuery(instruccion);
        
        respuesta.next();
        
        int id = respuesta.getInt("idConector");
        String conector = respuesta.getString("conector");
        int precio = respuesta.getInt("precio");
        String descripcion = respuesta.getString("descripcion");
        String tipo = respuesta.getString("tipo");
        float PInsercion = respuesta.getFloat("PInsercion");
        
        respuesta.close();
        
        Conector resultado = new Conector(id, conector, precio, descripcion, tipo, PInsercion);
        
        String respuestaFO = conector + " " + tipo;
        System.out.println("Conector: " + respuestaFO);
        
        return resultado;
    }
    
    private Empalme loadEmpalme() throws SQLException {
        String instruccion;
        Statement consulta;
        ResultSet respuesta;
        ResultSet res;
        consulta = this.conexionSQL.createStatement();
        instruccion =  "select * from empalmes order by precio";
        respuesta = consulta.executeQuery(instruccion);
        
        respuesta.next();
        
        int IdEmpalmes = respuesta.getInt("IdEmpalmes");
        String nombre = respuesta.getString("nombre");
        float precio = respuesta.getFloat("precio");
        float perdidas = respuesta.getFloat("perdidas");
        
        respuesta.close();
        
        Empalme resultado = new Empalme(IdEmpalmes, nombre, precio, perdidas);
        
        String respuestaFO = nombre + " " + perdidas;
        System.out.println("Conector: " + respuestaFO);
        
        return resultado;
    }
    
    private FibraExterna loadFibraExterna(int WL) throws SQLException {
        String instruccion;
        Statement consulta;
        ResultSet respuesta;
        ResultSet res;
        consulta = this.conexionSQL.createStatement();
        instruccion = "select * from producto where WL=" + Integer.toString(WL) + " and exterior = true order by costo";
        respuesta = consulta.executeQuery(instruccion);
        
        respuesta.next();
        int idP = respuesta.getInt("IdProducto");
        String fab = respuesta.getString("Fabricante");
        String tipo = respuesta.getString("Tipo");
        int waveL = respuesta.getInt("WL");
        float atenuacion = respuesta.getFloat("atenuacion");
        int bandW = respuesta.getInt("BW");
        int lc = respuesta.getInt("LC");
        float costo = respuesta.getFloat("costo");
        respuesta.close();
        
        FibraExterna resultado = new FibraExterna(idP, fab, tipo, waveL, atenuacion, bandW, lc, costo);
        
        String respuestaFO = fab + " " + tipo;
        System.out.println("Fibra externa: " + respuestaFO);
        
        return resultado;
    }
    
    private FibraInterna loadFibraInterna(int WL) throws SQLException {
        String instruccion;
        Statement consulta;
        ResultSet respuesta;
        ResultSet res;
        consulta = this.conexionSQL.createStatement();
        instruccion = "select * from producto where WL=" + Integer.toString(WL) + " and interior = true order by costo";
        respuesta = consulta.executeQuery(instruccion);
        
        respuesta.next();
        int idP = respuesta.getInt("IdProducto");
        String fab = respuesta.getString("Fabricante");
        String tipo = respuesta.getString("Tipo");
        int waveL = respuesta.getInt("WL");
        float atenuacion = respuesta.getFloat("atenuacion");
        int bandW = respuesta.getInt("BW");
        int lc = respuesta.getInt("LC");
        float costo = respuesta.getFloat("costo");
        respuesta.close();
        
        FibraInterna resultado = new FibraInterna(idP, fab, tipo, waveL, atenuacion, bandW, lc, costo);
        
        String respuestaFO = fab + " " + tipo;
        System.out.println("Fibra interna: " + respuestaFO);
        
        return resultado;
    }
    
    private Receptor loadReceptor(int WL) throws SQLException {
        String instruccion;
        Statement consulta;
        ResultSet respuesta;
        ResultSet res;
        consulta = this.conexionSQL.createStatement();
        instruccion =  "select * from rx  where WL =" + Integer.toString(WL) + " order by precio";
        respuesta = consulta.executeQuery(instruccion);
        
        respuesta.next();
        
        int IdReceptor = respuesta.getInt("IdReceptor");
        String Nombre = respuesta.getString("Nombre");
        float precio = respuesta.getFloat("precio");
        float PinMin = respuesta.getFloat("PinMin");
        float PinMax = respuesta.getFloat("PinMax");
        float waveL = respuesta.getFloat("WL");
        
        respuesta.close();
        
        Receptor resultado = new Receptor(IdReceptor, Nombre, precio, PinMin, PinMax, waveL);
        
        String respuestaFO = Nombre + " " + waveL;
        System.out.println("Receptor: " + respuestaFO);
        
        return resultado;
    }
    
    private TransmisorOptico loadTransmisorOptico(int WL) throws SQLException {
        String instruccion;
        Statement consulta;
        ResultSet respuesta;
        ResultSet res;
        consulta = this.conexionSQL.createStatement();
        instruccion =  "select * from txoptic  where WL =" + Integer.toString(WL) + " order by costo";
        respuesta = consulta.executeQuery(instruccion);
        
        respuesta.next();
        
        int IdTxoptic = respuesta.getInt("IdTxoptic");
        String Nombre = respuesta.getString("Nombre");
        int waveL = respuesta.getInt("WL");
        int Potencia = respuesta.getInt("Potencia");
        float costo = respuesta.getFloat("costo");
        
        respuesta.close();
        
        TransmisorOptico resultado = new TransmisorOptico(IdTxoptic, Nombre, waveL, Potencia, costo);
        
        String respuestaFO = Nombre + " " + waveL;
        System.out.println("Transmisor optico: " + respuestaFO);
        
        return resultado;
    }
}
