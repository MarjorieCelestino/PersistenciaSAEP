package br.ufg.inf.es.saep.sandbox.persistencia;

import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaTipo;
import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import org.prevayler.foundation.serialization.XStreamSerializer;

/**
 * Classe utilizada para criação de uma nova factory
 */
public class FactoryTipo {

    public static Prevayler prevayler3;

    /**
     * Cria e configura factory para tipo. Configura serialização de journal e
     * snapshot para XML.
     *
     * @throws Exception
     */
    public FactoryTipo() throws Exception {
        PrevaylerFactory factory = new PrevaylerFactory();
        factory.configurePrevalenceDirectory("Journals-Tipo");
        factory.configurePrevalentSystem(new ListaTipo());
        factory.configureJournalSerializer(new XStreamSerializer());
        factory.configureSnapshotSerializer(new XStreamSerializer());
        prevayler3 = factory.create();
        new SnapshotTimer(prevayler3).start();
    }
}
