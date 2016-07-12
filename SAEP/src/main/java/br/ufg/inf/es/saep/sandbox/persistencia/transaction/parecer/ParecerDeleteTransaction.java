
package br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer;

import br.ufg.inf.es.saep.sandbox.persistencia.bo.ControlaParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
import java.util.Date;
import org.prevayler.Transaction;

/**
 * Transaction para remoção de business object Parecer
 * 
 * @author Marjorie
 */
public class ParecerDeleteTransaction implements Transaction {
    private static final long serialVersionUID = 1L;
    
    private final String id;
    
    /**
     * Recebe parâmetros necessários para execução da transaction
     * @param id
     */
    public ParecerDeleteTransaction(String id){
        this.id = id;
    }

    /**
     * Executa transaction para deletar parecer
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaParecer)prevalentSystem).deletaParecer(id);
    }
}
