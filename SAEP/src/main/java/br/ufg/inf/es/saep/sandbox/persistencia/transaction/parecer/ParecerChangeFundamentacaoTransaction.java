package br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer;

import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaParecer;
import java.util.Date;
import org.prevayler.Transaction;

/**
 * Transações são necessárias para qualquer alteração no business object.
 * Permite o armazenamento das alterações pelo Prevayler Transaction. Classe
 * transaction para atualização da fundamentação em um business object parecer
 */
public class ParecerChangeFundamentacaoTransaction implements Transaction {

    private final String id;
    private final String fundamentacao;

    /**
     * Construtor com os parâmetros necessários para realização da transaction.
     *
     * @param id
     * @param fundamentacao
     */
    public ParecerChangeFundamentacaoTransaction(String id, String fundamentacao) {
        this.id = id;
        this.fundamentacao = fundamentacao;
    }

    /**
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaParecer) prevalentSystem).mudaFundamentacao(id, fundamentacao);
    }

}
