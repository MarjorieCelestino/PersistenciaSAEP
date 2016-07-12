/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.bo;

import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.Pontuacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marjorie
 */
public class ListaParecer implements Serializable{
    private static final long serialVersionUID = 1l;
    
    //referência a classe controla parecer
    ControlaParecer control;
    
    /**
     * Cria lista para armazenamento dos pareceres
     */
    public static List<Parecer> listaParecer = new ArrayList<Parecer>();
    
    /**
     * adiciona e persiste parecer
     * @param id
     * @param resolucaoId
     * @param radocsIds
     * @param pontuacoes
     * @param fundamentacao
     * @param notas
     * @return novoParecer
     */
    public Parecer addParecer(Parecer novoParecer){
        //cria novo parecer pelos parâmetros do método
        //Parecer novoParecer = new Parecer(id, resolucaoId, radocsIds, pontuacoes, fundamentacao, notas);
        //persiste parecer
        control.persisteParecer(novoParecer);
        
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

}
