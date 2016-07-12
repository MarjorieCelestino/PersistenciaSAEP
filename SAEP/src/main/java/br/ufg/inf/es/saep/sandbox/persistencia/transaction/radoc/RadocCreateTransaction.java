
package br.ufg.inf.es.saep.sandbox.persistencia.transaction.radoc;

import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.Radoc;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ControlaParecer;
import java.util.Date;
import org.prevayler.TransactionWithQuery;

/**
 *Transaction criação/persistencia de radoc em um business object parecer
 * 
 * @author Marjorie
 */
public class RadocCreateTransaction implements TransactionWithQuery {
    private final String idParecer;
    private final String idRadoc;
    
    public RadocCreateTransaction(String idP, String idR){
        this.idParecer = idP;
        this.idRadoc = idR;
    }

    @Override
    public Object executeAndQuery(Object prevalentSystem, Date executionTime) throws Exception {
        Parecer novoParecer = ((ControlaParecer) prevalentSystem).byId(idParecer);
        Radoc novoRadoc = ((ControlaParecer) prevalentSystem).radocById(idRadoc);
        ((ControlaParecer) prevalentSystem).persisteRadoc(novoRadoc);
        novoParecer.getRadocs().add(idRadoc);

        return novoRadoc;
    }
}
