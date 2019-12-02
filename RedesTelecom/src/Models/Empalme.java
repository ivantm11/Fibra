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
    int IdEmpalmes;
    String nombre;
    float precio;
    float perdidas; 

    public Empalme (int IdEmpalmes, String nombre, float precio, float perdidas){
        this.IdEmpalmes = IdEmpalmes;
        this.nombre = nombre;
        this.precio = precio;
        this.perdidas = perdidas;
    }
}
