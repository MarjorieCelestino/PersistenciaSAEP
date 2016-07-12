/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.persistencia.*;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import org.prevayler.foundation.serialization.XStreamSerializer;

/**
 * Classe utilizada para criação de uma nova factory
 * @author Marjorie
 */
public class FactoryParecer {
    public static Prevayler prevayler;
    //Cria e configura factory
    public FactoryParecer() throws Exception{
       System.out.println("Iniciando Prevayler...");
        //configura e cria sistema prevalente para Listaparecer
        PrevaylerFactory factory = new PrevaylerFactory();
        factory.configurePrevalenceDirectory("LogsParecer");
        factory.configurePrevalentSystem(new ListaParecer());
        //configura serialização de journal e snapshot
        factory.configureJournalSerializer(new XStreamSerializer());
        factory.configureSnapshotSerializer(new XStreamSerializer());
        //cria factory 
        prevayler = factory.create();
        //chama thread responsável por snapshots 
        new SnapshotTimer(prevayler).start();
    }
    
}
