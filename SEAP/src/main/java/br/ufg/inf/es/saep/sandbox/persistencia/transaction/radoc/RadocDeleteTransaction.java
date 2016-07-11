
package br.ufg.inf.es.saep.sandbox.persistencia.transaction.radoc;

import java.util.Date;
import org.prevayler.Transaction;
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
        
    }
}
