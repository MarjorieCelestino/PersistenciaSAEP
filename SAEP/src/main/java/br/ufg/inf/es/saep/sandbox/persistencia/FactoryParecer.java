package br.ufg.inf.es.saep.sandbox.persistencia;

import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaParecer;
import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import org.prevayler.foundation.serialization.XStreamSerializer;

/**
 * Classe utilizada para criação de uma nova factory
 */
public class FactoryParecer {

    public static Prevayler prevaylerParecer;

    /**
     * Cria e configura factory para parecer. Configura serialização de journal
     * e snapshot para XML.
     *
     * @throws Exception
     */
    public FactoryParecer() throws Exception {
        PrevaylerFactory factory = new PrevaylerFactory();
        factory.configurePrevalenceDirectory("Journals-Parecer");
        factory.configurePrevalentSystem(new ListaParecer());
        factory.configureJournalSerializer(new XStreamSerializer());
        factory.configureSnapshotSerializer(new XStreamSerializer());
        prevaylerParecer = factory.create();
        new SnapshotTimer(prevaylerParecer).start();
    }

}
