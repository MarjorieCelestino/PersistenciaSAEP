/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.transaction.resolucao;

import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaResolucao;
import java.util.Date;
import org.prevayler.Transaction;

/**
 *
 * @author Marjorie
 */
public class ResolucaoDeleteTransaction implements Transaction{
    private static final long serialVersionUID = 1L;
    
    private final String id;
    
    /**
     *
     * @param id
     */
    public ResolucaoDeleteTransaction(String id){
        this.id = id;
    }

    /**
     *
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaResolucao)prevalentSystem).deletaResolucao(id);
    }
}
