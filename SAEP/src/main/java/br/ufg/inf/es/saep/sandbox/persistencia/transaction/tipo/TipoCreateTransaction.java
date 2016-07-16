package br.ufg.inf.es.saep.sandbox.persistencia.transaction.tipo;

import br.ufg.inf.es.saep.sandbox.dominio.Atributo;
import br.ufg.inf.es.saep.sandbox.dominio.Tipo;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaTipo;
import java.util.Date;
import java.util.Set;
import org.prevayler.Transaction;

/**
 * Transações são necessárias para qualquer alteração no business object.
 * Permite o armazenamento das alterações pelo Prevayler Transaction.
 */
public class TipoCreateTransaction implements Transaction {

    private static final long serialVersionUID = 1L;

    private final String id;
    private final String nome;
    private final String descricao;
    private final Set<Atributo> atributos;

    /**
     * @param id
     * @param nome
     * @param descricao
     * @param atributos
     */
    public TipoCreateTransaction(String id, String nome, String descricao, Set<Atributo> atributos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.atributos = atributos;
    }

    /**
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaTipo) prevalentSystem).addTipo(new Tipo(id, nome, descricao, atributos));
    }

}
