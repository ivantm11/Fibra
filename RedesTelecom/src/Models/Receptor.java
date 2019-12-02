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
public class Receptor {
    public int IdReceptor;
    public String Nombre;
    public float precio;
    public float PinMin;
    public float PinMax;
    public float WL;
    
    public String mensaje;
    
    public Receptor (int IdReceptor, String Nombre, float precio, float PinMin, float PinMax, float WL, String mensaje){
        this.IdReceptor = IdReceptor;
        this.Nombre = Nombre;
        this.PinMax = PinMax;
        this.PinMin = PinMin;
        this.WL = WL;
        this.mensaje = mensaje;
    }
}
