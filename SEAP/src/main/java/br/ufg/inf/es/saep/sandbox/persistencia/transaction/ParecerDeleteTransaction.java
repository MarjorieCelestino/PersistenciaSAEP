/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.transaction;

import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
import java.util.Date;
import org.prevayler.Transaction;

/**
 * Transaction para remoção de business object Parecer
 * 
 * @author Marjorie
 */
public class ParecerDeleteTransaction implements Transaction {
    private final String id;
    
    public ParecerDeleteTransaction(String id){
        this.id = id;
    }
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaParecer)prevalentSystem).removeParecer(id);
    }
}
