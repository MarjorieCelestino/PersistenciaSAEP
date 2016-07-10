/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia;

import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaResolucao;
import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;

/**
 *Classe com o método main() - Utiliza o padrão de projeto Factory para criar objetos necessários
 *para o Prevayler funcionar, indicando que as classes ListaParecer e ListaResolucao são os 
 *objetos raíz.
Insere o código para o Thread que gera um snapshot em intervalos
de 500 ms
 * @author Marjorie
 */
public class Main {
    
    public Main() {super();}
    public static void main(String[] args) throws Exception {
        final Prevayler prevaylerParecer = PrevaylerFactory.
                createPrevayler(new ListaParecer(), "Parecer");
        final Prevayler prevaylerResolucao = PrevaylerFactory.
                createPrevayler(new ListaResolucao(), "Resolucao");
    }
}
