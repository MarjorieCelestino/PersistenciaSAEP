/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.transaction;

import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
import java.util.Date;
import org.prevayler.TransactionWithQuery;

/**
 * Classe transaction para atualização da fundamentação em um business object
 * parecer
 *
 * @author Marjorie
 */
public class ParecerChangeFundamentacaoTransaction implements TransactionWithQuery {

    private final String id;
    private final String fundamentacao;

    public ParecerChangeFundamentacaoTransaction(String id, String fundamentacao) {
        this.id = id;
        this.fundamentacao = fundamentacao;
    }

    @Override
    public Object executeAndQuery(Object prevalentSystem, Date executionTime) throws Exception {
        Parecer parecerAlterado = ((ListaParecer) prevalentSystem).novaFundamentacao(id, fundamentacao);
        return parecerAlterado;
    }

}
