/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.Pontuacao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Marjorie
 */
public class ParecerSeriavel extends Parecer implements Serializable {
    private static final long serialVersionUID = 1L;  

    private String id;
    private String resolucaoId;
    private List<String> radocsIds; 
    private List<Pontuacao> pontuacoes;
    private String fundamentacao;
    private List<Nota> notas;
    
    public ParecerSeriavel(String id, String resolucaoId, List<String> radocsIds, 
            List<Pontuacao> pontuacoes, String fundamentacao, List<Nota> notas){
        this.id = id;
        this.resolucaoId = resolucaoId;
        this.radocsIds = radocsIds;
        this.pontuacoes = pontuacoes;
        this.fundamentacao = fundamentacao;
        this.notas = notas;
    }
}
