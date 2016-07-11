
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

    public ParecerChangeFundamentacaoTransaction(String id, String fundamentacao) {
        this.id = id;
        this.fundamentacao = fundamentacao;
    }

    @Override
    public void executeOn(Object prevalentSystem, Date executionTime){
        ((ListaParecer) prevalentSystem).atualizaFundamentacao(id, fundamentacao);
    }

}
