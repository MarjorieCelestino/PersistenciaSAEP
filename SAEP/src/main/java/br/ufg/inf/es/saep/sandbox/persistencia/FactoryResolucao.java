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
import org.prevayler.foundation.serialization.XStreamSerializer;

/**
 *
 * @author Marjorie
 */
public class FactoryResolucao {
    public static Prevayler prevayler2;
    //Cria e configura factory

    /**
     * cria e configura factory para resolucao
     * @throws Exception
     */
    public FactoryResolucao() throws Exception{
       System.out.println("Iniciando Prevayler...");
        //configura e cria sistema prevalente para Listaparecer
        PrevaylerFactory factory = new PrevaylerFactory();
        factory.configurePrevalenceDirectory("LogsResolucao");
        factory.configurePrevalentSystem(new ListaResolucao());
        //configura serialização de journal e snapshot
        factory.configureJournalSerializer(new XStreamSerializer());
        factory.configureSnapshotSerializer(new XStreamSerializer());
        //cria factory 
        prevayler2 = factory.create();
        //chama thread responsável por snapshots 
        new SnapshotTimer(prevayler2).start();
    }
}
