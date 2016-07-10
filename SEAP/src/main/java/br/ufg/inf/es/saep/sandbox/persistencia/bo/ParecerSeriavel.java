/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.bo;

import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.Pontuacao;
import java.io.Serializable;
import java.util.*;

/**
 * business object seriável 
 * herda de Parecer, utilizado para criação dos métodos set
 * @author Marjorie
 */
public class ParecerSeriavel extends Parecer implements Serializable {
    private String id;
    private String resolucao;
    private List<String> radocs;
    private List<Pontuacao> pontuacoes;
    private String fundamentacao;
    private List<Nota> notas;
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setResolucao(String resolucao){
        this.resolucao = resolucao;
    }
    
    public void setRadoc(List<String> radocs){
        this.radocs = radocs;
    }
    
    public void setPontuacao(List<Pontuacao> pontuacoes){
        this.pontuacoes = pontuacoes;
    }
    
    public void setFundamentacao(String fundamentacao){
        this.fundamentacao = fundamentacao;
    }
    
    public void setNota(List<Nota> notas){
        this.notas = notas;
    }
}
