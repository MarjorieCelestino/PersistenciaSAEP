package br.ufg.inf.es.saep.sandbox.persistencia;

import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaResolucao;
import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import org.prevayler.foundation.serialization.XStreamSerializer;

/**
 * Classe que cria o factory para resolução.
 */
public class FactoryResolucao {

    public static Prevayler prevayler2;

    /**
     * Cria e configura factory para resolução. Configura serialização de
     * journal e snapshot para XML.
     *
     * @throws Exception
     */
    public FactoryResolucao() throws Exception {
        System.out.println("Iniciando Prevayler...");
        PrevaylerFactory factory = new PrevaylerFactory();
        factory.configurePrevalenceDirectory("LogsResolucao");
        factory.configurePrevalentSystem(new ListaResolucao());
        factory.configureJournalSerializer(new XStreamSerializer());
        factory.configureSnapshotSerializer(new XStreamSerializer());
        prevayler2 = factory.create();
        new SnapshotTimer(prevayler2).start();
    }
}
