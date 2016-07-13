package br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer;

import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaParecer;
import java.util.Date;
import org.prevayler.Transaction;

/**
 * Transações são necessárias para qualquer alteração no business object.
 * Permite o armazenamento das alterações pelo Prevayler Transaction.
 * Transaction para remoção de business object Parecer.
 */
public class ParecerDeleteTransaction implements Transaction {

    private static final long serialVersionUID = 1L;

    private final String id;

    /**
     * Recebe parâmetros necessários para execução da transaction.
     *
     * @param id
     */
    public ParecerDeleteTransaction(String id) {
        this.id = id;
    }

    /**
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaParecer) prevalentSystem).deletaParecer(id);
    }
}
