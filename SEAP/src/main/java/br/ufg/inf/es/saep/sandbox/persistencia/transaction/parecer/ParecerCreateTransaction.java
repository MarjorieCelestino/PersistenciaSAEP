
package br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer;

import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
import java.util.Date;
import org.prevayler.TransactionWithQuery;

/**
 * Transações são necessárias para qualquer alteração no business object Permite
 * o armazenamento das alterações pelo Prevayler
 * 
 *Transaction: Criação e persistencia de um novo parecer
 * @author Marjorie
 */
public class ParecerCreateTransaction implements TransactionWithQuery {
    private final String id;
    
    public ParecerCreateTransaction(String id) {
        this.id = id;
    }

    @Override
    public Object executeAndQuery(Object prevalentSystem, Date executionTime) throws Exception {
        Parecer novoParecer = ((ListaParecer) prevalentSystem).byId(id);
        ((ListaParecer) prevalentSystem).persisteParecer(novoParecer);
        return novoParecer;
    }

}
