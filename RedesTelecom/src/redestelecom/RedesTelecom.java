package redestelecom;

import java.sql.Connection;

/**
 *
 * @author ivantrejo
 */
public class RedesTelecom {

    public static void main(String[] args) {
        ConexionSQL BaseSQL = new ConexionSQL();
        Connection BaseDeDatos = BaseSQL.getConexionSQL();
        if (BaseDeDatos != null) {
            MenuPrincipal menuNuevo = new MenuPrincipal(BaseDeDatos);
            menuNuevo.setVisible(true);
        }
    }
}
