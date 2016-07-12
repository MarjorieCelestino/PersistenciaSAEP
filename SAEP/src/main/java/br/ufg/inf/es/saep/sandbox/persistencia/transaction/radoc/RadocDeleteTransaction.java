
package br.ufg.inf.es.saep.sandbox.persistencia.transaction.radoc;

import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import java.util.Date;
import org.prevayler.Transaction;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ControlaParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
/**
 *
 * @author Marjorie
 */
public class RadocDeleteTransaction implements Transaction {
     private final String idParecer;
    private final String idRadoc;
    
    public RadocDeleteTransaction(String idP, String idR){
        this.idParecer = idP;
        this.idRadoc = idR;
    }
    
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        Parecer novoParecer = ((ControlaParecer) prevalentSystem).byId(idParecer);
        ((ListaParecer) prevalentSystem).deletaRadoc(idRadoc);
    }
}
