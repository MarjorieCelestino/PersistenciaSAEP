package br.ufg.inf.es.saep.sandbox.persistencia.transaction.resolucao;

import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaResolucao;
import java.util.Date;
import org.prevayler.Transaction;

/**
 * Transações são necessárias para qualquer alteração no business object.
 * Permite o armazenamento das alterações pelo Prevayler Transaction.
 */
public class ResolucaoDeleteTransaction implements Transaction {

    private static final long serialVersionUID = 1L;

    private final String id;

    /**
     * Recebe parâmtero necessário para realização da transaction.
     *
     * @param id
     */
    public ResolucaoDeleteTransaction(String id) {
        this.id = id;
    }

    /**
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaResolucao) prevalentSystem).deletaResolucao(id);
    }
}
