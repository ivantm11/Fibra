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
public class Receptores {
   int IdReceptor;
	String Nombre;
    float precio;
    float PinMin;
    float PinMax;
    float WL;
    
    public Receptores (int IdReceptor, String Nombre, float precio, float PinMin, float PinMax, float WL){
    this.IdReceptor = IdReceptor;
    this.Nombre = Nombre;
    this.PinMax = PinMax;
    this.PinMin = PinMin;
    this.WL = WL;
    }
}
