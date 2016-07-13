package br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer;

import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.Pontuacao;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaParecer;
import java.util.Date;
import java.util.List;
import org.prevayler.Transaction;

/**
 * Transações são necessárias para qualquer alteração no business object.
 * Permite o armazenamento das alterações pelo Prevayler Transaction.
 */
public class ParecerCreateTransaction implements Transaction {

    private static final long serialVersionUID = 1L;

    private final String id;
    private final String resolucaoId;
    private final List<String> radocsIds;
    private final List<Pontuacao> pontuacoes;
    private final String fundamentacao;
    private final List<Nota> notas;

    /**
     * Construtor com os parâmetros necessários para realização da transaction
     *
     * @param id
     * @param resolucaoId
     * @param radocsIds
     * @param pontuacoes
     * @param fundamentacao
     * @param notas
     */
    public ParecerCreateTransaction(String id, String resolucaoId, List<String> radocsIds,
            List<Pontuacao> pontuacoes, String fundamentacao, List<Nota> notas) {
        this.id = id;
        this.resolucaoId = resolucaoId;
        this.radocsIds = radocsIds;
        this.pontuacoes = pontuacoes;
        this.fundamentacao = fundamentacao;
        this.notas = notas;
    }

    /**
     * executa transaction para criação e adição de um novo parecer ao sistema
     * prevalente
     *
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaParecer) prevalentSystem).addParecer(new Parecer(id, resolucaoId,
                radocsIds, pontuacoes, fundamentacao, notas));
    }

}
