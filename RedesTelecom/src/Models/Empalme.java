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
public class Empalme {
    public int IdEmpalmes;
    public String nombre;
    public float precio;
    public float perdidas; 
    
    public String mensaje;

    public Empalme (int IdEmpalmes, String nombre, float precio, float perdidas, String mensaje){
        this.IdEmpalmes = IdEmpalmes;
        this.nombre = nombre;
        this.precio = precio;
        this.perdidas = perdidas;
        this.mensaje = mensaje;
    }
}
