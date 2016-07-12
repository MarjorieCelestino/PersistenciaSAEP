/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.persistencia.bo.*;
import br.ufg.inf.es.saep.sandbox.dominio.IdentificadorExistente;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marjorie
 */
public class ListaParecer implements Serializable{
    private static final long serialVersionUID = 1l;
    
    public static boolean pode = true;
    //referência a classe controla parecer
    ControlaParecer control;
    
    /**
     * Cria lista para armazenamento dos pareceres
     */
    public static List<ParecerSeriavel> listaParecer = new ArrayList<ParecerSeriavel>();
    
    /**
     * adiciona e persiste parecer
     * @param novoParecer
     * @return novoParecer
     */
    public Parecer addParecer(ParecerSeriavel novoParecer){
        control.persisteParecer(novoParecer);
        if(pode){
            listaParecer.add(novoParecer);
        }else{
            throw new IdentificadorExistente("Identificador referente a outro parecer já armazenado.");
        }
        
        return novoParecer;
    }
    
    /**
     * encontra parecer pela id
     * @param id
     * @return parecerEncontrado
     */
    public Parecer getParecer(String id){
        //busca parecer por id
        Parecer parecerEncontrado = control.byId(id);
        return parecerEncontrado;
    }
    
    /**
     * encontra e remove parecer pela id
     * @param id
     */
    public void deletaParecer(String id){
        control.removeParecer(id);
        System.out.println("Parecer removido.");
    }
    
    public void imprimeIds(){ 
        System.out.println("Id dos pareceres armazenados: \n");
        for (int i = 0; i < listaParecer.size(); i++) {  
            System.out.println(listaParecer.get(i).getId());  
        } 
    }

}
