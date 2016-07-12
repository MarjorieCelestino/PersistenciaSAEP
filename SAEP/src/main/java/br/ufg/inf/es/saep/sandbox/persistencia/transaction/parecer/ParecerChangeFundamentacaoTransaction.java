package br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer;

import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
import java.util.Date;
import org.prevayler.Transaction;

/**
 * Classe transaction para atualização da fundamentação em um business object
 * parecer
 *
 * @author Marjorie
 */
public class ParecerChangeFundamentacaoTransaction implements Transaction {

    private final String id;
    private final String fundamentacao;

    /**
     *
     * @param id
     * @param fundamentacao
     */
    public ParecerChangeFundamentacaoTransaction(String id, String fundamentacao) {
        this.id = id;
        this.fundamentacao = fundamentacao;
    }

    /**
     *
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime){
        ((ListaParecer) prevalentSystem).mudaFundamentacao(id, fundamentacao);
    }

}
