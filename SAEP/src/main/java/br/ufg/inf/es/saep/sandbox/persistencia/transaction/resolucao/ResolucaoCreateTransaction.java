/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.transaction.resolucao;

import br.ufg.inf.es.saep.sandbox.dominio.Regra;
import br.ufg.inf.es.saep.sandbox.dominio.Resolucao;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaResolucao;
import java.util.Date;
import java.util.List;
import org.prevayler.Transaction;

/**
 *
 * @author Marjorie
 */
public class ResolucaoCreateTransaction implements Transaction{
    private static final long serialVersionUID = 1L;
    
    private final String id;
    private final Date dataAprovacao;
    private final String nome;
    private final String descricao;
    private final List<Regra> regras;
    
    /**
     * parametros necessários para execução da transaction
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
     * realiza transaction de adicionar resolução
     * @param prevalentSystem
     * @param executionTime
     */
    @Override
    public void executeOn(Object prevalentSystem, Date executionTime) {
            ((ListaResolucao) prevalentSystem).addResolucao(new Resolucao(id, nome,
                    descricao, dataAprovacao, regras));
    }
}
