package br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer;

import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
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
    
    public ParecerChangeAddNotaTransaction(String id, Nota notas){
        this.id = id;
        this.nota = notas;
    }

    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaParecer) prevalentSystem).addNota(id, nota);
    }
   
    
}
