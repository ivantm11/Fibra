/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redestelecom;

import java.sql.Connection;

/**
 *
 * @author ivantrejo
 */
public class RedesTelecom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionSQL BaseSQL = new ConexionSQL();
        Connection BaseDeDatos = BaseSQL.getConexionSQL();
        if (BaseDeDatos != null) {
            
        }
    }
}
