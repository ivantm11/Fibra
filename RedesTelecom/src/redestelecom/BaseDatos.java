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
        
        String mensaje = nombre + " " + Ganancia;
        System.out.println("Amplificador: " + mensaje);
        
        Amplificador resultado = new Amplificador(id, nombre, PinMin, PinMax, PoutMin, PoutMax, Ganancia, costo, mensaje);
        
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
        
        String mensaje = nombre + " " + atenuacion;
        System.out.println("Atenuador: " + mensaje);
        
        Atenuador resultado = new Atenuador(id, nombre, precio, atenuacion, mensaje);
        
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
        
        String mensaje = conector + " " + tipo;
        System.out.println("Conector: " + mensaje);
        
        Conector resultado = new Conector(id, conector, precio, descripcion, tipo, PInsercion, mensaje);
        
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
        
        String mensaje = nombre + " " + perdidas;
        System.out.println("Conector: " + mensaje);
        
        Empalme resultado = new Empalme(IdEmpalmes, nombre, precio, perdidas, mensaje);
        
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
        
        String mensaje = fab + " " + tipo;
        System.out.println("Fibra externa: " + mensaje);
        
        FibraExterna resultado = new FibraExterna(idP, fab, tipo, waveL, atenuacion, bandW, lc, costo, mensaje);
        
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
        
        String mensaje = fab + " " + tipo;
        System.out.println("Fibra interna: " + mensaje);
        
        FibraInterna resultado = new FibraInterna(idP, fab, tipo, waveL, atenuacion, bandW, lc, costo, mensaje);
        
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
        
        String mensaje = Nombre + " " + waveL;
        System.out.println("Receptor: " + mensaje);
        
        Receptor resultado = new Receptor(IdReceptor, Nombre, precio, PinMin, PinMax, waveL, mensaje);
        
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
        
        String mensaje = Nombre + " " + waveL;
        System.out.println("Transmisor optico: " + mensaje);
        
        TransmisorOptico resultado = new TransmisorOptico(IdTxoptic, Nombre, waveL, Potencia, costo, mensaje);
        
        return resultado;
    }
}
