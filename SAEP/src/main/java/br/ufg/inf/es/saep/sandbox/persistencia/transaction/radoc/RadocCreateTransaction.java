package br.ufg.inf.es.saep.sandbox.persistencia.transaction.radoc;

import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.Radoc;
import br.ufg.inf.es.saep.sandbox.dominio.Relato;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ControlaParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaParecer;
import java.util.Date;
import java.util.List;
import org.prevayler.Transaction;

/**
 * Transações são necessárias para qualquer alteração no business object.
 * Permite o armazenamento das alterações pelo Prevayler Transaction.
 * Transaction criação/persistencia de radoc em um business object parecer
 */
public class RadocCreateTransaction implements Transaction {

    private final String idParecer;
    private final String id;
    private final int anoBase;
    private final List<Relato> relatos;

    /**
     * Recebe parâmetros necessários para realização da transaction.
     *
     * @param idParecer
     * @param id
     * @param anoBase
     * @param relatos
     */
    public RadocCreateTransaction(String idParecer, String id, int anoBase, List<Relato> relatos) {
        this.idParecer = idParecer;
        this.id = id;
        this.anoBase = anoBase;
        this.relatos = relatos;
    }

    /**
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        Parecer novoParecer = ((ControlaParecer) prevalentSystem).byId(idParecer);
        ((ListaParecer) prevalentSystem).addRadoc(new Radoc(id, anoBase, relatos));
    }
}
