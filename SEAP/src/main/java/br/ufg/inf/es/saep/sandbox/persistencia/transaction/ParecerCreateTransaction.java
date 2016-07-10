/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.transaction;

import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Pontuacao;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ParecerSeriavel;
import java.util.Date;
import java.util.List;
import org.prevayler.TransactionWithQuery;

/**
 * Transações são necessárias para qualquer alteração no business object
 * Permite o armazenamento das alterações pelo Prevayler
 * @author Marjorie
 */
public class ParecerCreateTransaction implements TransactionWithQuery{
    private final String id;
    private final String resolucao;
    private final List<String> radocs;
    private final List<Pontuacao> pontuacoes;
    private final String fundamentacao;
    private final List<Nota> notas;
    
    public ParecerCreateTransaction(String id, String resolucaoId, List<String> radocsIds, List<Pontuacao> pontuacoes, 
           String fundamentacao, List<Nota> notas) {
        this.id = id;
        this.resolucao = resolucaoId;
        this.radocs = radocsIds;
        this.pontuacoes = pontuacoes;
        this.fundamentacao = fundamentacao;
        this.notas = notas;
    }
    @Override
    public Object executeAndQuery(Object prevalentSystem, Date executionTime) throws Exception {
        ParecerSeriavel novoParecer = (ParecerSeriavel) ((ListaParecer)prevalentSystem).addParecer();
        novoParecer.setId(id);
        novoParecer.setResolucao(resolucao);
        novoParecer.setPontuacao(pontuacoes);
        novoParecer.setFundamentacao(fundamentacao);
        novoParecer.setNota(notas);
        return novoParecer;
    }
    
}
