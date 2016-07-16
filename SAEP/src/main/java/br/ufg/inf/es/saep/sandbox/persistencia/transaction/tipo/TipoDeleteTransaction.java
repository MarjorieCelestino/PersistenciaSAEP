package br.ufg.inf.es.saep.sandbox.persistencia.transaction.tipo;

import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaTipo;
import java.util.Date;
import org.prevayler.Transaction;

/**
 * Transações são necessárias para qualquer alteração no business object.
 * Permite o armazenamento das alterações pelo Prevayler Transaction.
 */
public class TipoDeleteTransaction implements Transaction {

    private static final long serialVersionUID = 1L;

    private final String id;

    /**
     * @param codigo
     */
    public TipoDeleteTransaction(String codigo) {
        this.id = codigo;
    }

    /**
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaTipo) prevalentSystem).removeTipo(id);
    }
}
