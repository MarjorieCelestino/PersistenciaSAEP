/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.bo;

import br.ufg.inf.es.saep.sandbox.dominio.Resolucao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marjorie
 */
public class ListaResolucao implements Serializable{
    private static final long serialVersionUID = 1l;
    
    /**
     * lista para armazenamento dos objetos Resolucao
     */
    public static List<Resolucao> listaResolucao = new ArrayList<Resolucao>();
    
    ControlaResolucao control;
    
    /**
     * adiciona uma nova reoslucao
     * @param novaResolucao
     * @return
     */
    public Resolucao addResolucao(Resolucao novaResolucao){
        control.persiste(novaResolucao);
        return novaResolucao;
    }
    
    /**
     * deleta a resolução
     * @param id
     */
    public void deletaResolucao(String id){
        control.remove(id);
    }    
}
