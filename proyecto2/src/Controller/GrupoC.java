/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.GrupoM;

/**
 *
 * @author ariel
 */
public class GrupoC {
    public void Agregar(int numeroGrupo){
        //Objeto del modelo
        GrupoM grupoM = new GrupoM();
        grupoM.setNumeroGrupo(numeroGrupo);
        grupoM.Agregar();
    }
}
