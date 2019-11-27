package redestelecom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ivantrejo
 */
public class ConexionSQL {
    private Connection BaseDeDatos;
    
    private static final String base = "fibra";
    private static final String user = "root";
    private static final String password = "ivantm11";
    //private static final String password = "1396";
    //private final String url = "jdbc:mysql://localhost:3306/" + base;
    private static final String url = "jdbc:mysql://localhost:3306/" + base + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public ConexionSQL(){
        BaseDeDatos = ConectarSQL();
    }
    
    private Connection ConectarSQL(){
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
            JOptionPane.showMessageDialog(null, "Conexion correcta\n c:");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Conexion incorrecta\n :c" +e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }

    public Connection getConexionSQL() {
        return BaseDeDatos;
    }
}
