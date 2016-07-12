/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.bo;

import br.ufg.inf.es.saep.sandbox.dominio.IdentificadorExistente;
import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.Radoc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marjorie
 */
public class ListaParecer implements Serializable{
    private static final long serialVersionUID = 1l;
    
    /**
     *
     */
    public static boolean pode = true;
    //referência a classe controla parecer
    ControlaParecer control;
    
    /**
     * Cria lista para armazenamento dos pareceres
     */
    public static List<Parecer> listaParecer = new ArrayList<Parecer>();

    /**
     *
     */
    public static List<Radoc> listaRadoc = new ArrayList<Radoc>();
    
    /**
     * adiciona e persiste parecer
     * @param novoParecer
     * @return novoParecer
     */
    public Parecer addParecer(Parecer novoParecer){
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
    }
    
    /**
     * Imprime as ids de cada paecer armazenado
     */
    public void imprimeIds(){ 
        for (int i = 0; i < listaParecer.size(); i++) {  
            System.out.println(listaParecer.get(i).getId());  
        } 
    }
    
    /**
     * adiciona nota ao parecer
     * @param id
     * @param nota
     */
    public void addNota(String id, Nota nota){
        control.adicionaNota(id, nota);
    }

    /**
     * atualiza a fundamentacao do parecer
     * @param parecerId
     * @param fundamentacao
     */
    public void mudaFundamentacao(String parecerId, String fundamentacao){
        control.atualizaFundamentacao(parecerId, fundamentacao);
    }
    
    /**
     * adiciona radoc ao parecer
     * @param radoc
     */
    public void addRadoc(Radoc radoc){
        control.persisteRadoc(radoc);
    }
    
    /**
     * remove radoc 
     * @param id
     */
    public void deletaRadoc(String id){
        control.removeRadoc(id);
    }
}
