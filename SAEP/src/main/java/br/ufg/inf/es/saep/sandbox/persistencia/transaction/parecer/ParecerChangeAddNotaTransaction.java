package br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer;

import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaParecer;
import java.util.Date;
import org.prevayler.Transaction;

/**
 *Classe transaction para adição de nota ao Parecer
 * 
 * @author Marjorie
 */
public class ParecerChangeAddNotaTransaction implements Transaction {
    private final String id;
    private final Nota nota;
    
    /**
     *
     * @param id
     * @param notas
     */
    public ParecerChangeAddNotaTransaction(String id, Nota notas){
        this.id = id;
        this.nota = notas;
    }

    /**
     *
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaParecer) prevalentSystem).addNota(id, nota);
    }
   
    
}
