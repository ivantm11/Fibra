/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author royca
 */
public class TransmisorOptico {
    int IdTxoptic;
    String Nombre;
    int WL;
    int Potencia;
    float costo;
    
    public TransmisorOptico(int IdTxoptic, String Nombre, int WL, int Potencia, float costo){
        this.IdTxoptic = IdTxoptic;
        this.Nombre = Nombre;
        this.Potencia = Potencia;
        this.WL = WL;
        this.costo = costo;
    }
    
}
