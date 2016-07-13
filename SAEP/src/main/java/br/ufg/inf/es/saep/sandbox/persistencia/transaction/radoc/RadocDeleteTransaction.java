package br.ufg.inf.es.saep.sandbox.persistencia.transaction.radoc;

import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import java.util.Date;
import org.prevayler.Transaction;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ControlaParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaParecer;

/**
 * Transações são necessárias para qualquer alteração no business object.
 * Permite o armazenamento das alterações pelo Prevayler Transaction.
 * Transaction para deletar Radoc.
 */
public class RadocDeleteTransaction implements Transaction {

    private final String idParecer;
    private final String idRadoc;

    /**
     * Recebe parâmtros necessários para realização da transaction.
     *
     * @param idP
     * @param idR
     */
    public RadocDeleteTransaction(String idP, String idR) {
        this.idParecer = idP;
        this.idRadoc = idR;
    }

    /**
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        Parecer novoParecer = ((ControlaParecer) prevalentSystem).byId(idParecer);
        ((ListaParecer) prevalentSystem).deletaRadoc(idRadoc);
    }
}
