package br.ufg.inf.es.saep.sandbox.persistencia.transaction.resolucao;

import br.ufg.inf.es.saep.sandbox.dominio.Regra;
import br.ufg.inf.es.saep.sandbox.dominio.Resolucao;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaResolucao;
import java.util.Date;
import java.util.List;
import org.prevayler.Transaction;

/**
 * Transações são necessárias para qualquer alteração no business object.
 * Permite o armazenamento das alterações pelo Prevayler Transaction.
 */
public class ResolucaoCreateTransaction implements Transaction {

    private static final long serialVersionUID = 1L;

    private final String id;
    private final Date dataAprovacao;
    private final String nome;
    private final String descricao;
    private final List<Regra> regras;

    /**
     * Recebe parâmetros necessários para execução da transaction.
     *
     * @param id
     * @param nome
     * @param descricao
     * @param dataAprovacao
     * @param regras
     */
    public ResolucaoCreateTransaction(String id, String nome, String descricao, Date dataAprovacao, List<Regra> regras) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataAprovacao = dataAprovacao;
        this.regras = regras;
    }

    /**
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
        ((ListaResolucao) prevalentSystem).addResolucao(new Resolucao(id, nome,
                descricao, dataAprovacao, regras));
    }
}
