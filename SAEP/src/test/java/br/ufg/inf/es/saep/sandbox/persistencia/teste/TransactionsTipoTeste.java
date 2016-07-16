package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.dominio.Atributo;
import br.ufg.inf.es.saep.sandbox.persistencia.FactoryTipo;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaTipo;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.tipo.TipoCreateTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.tipo.TipoDeleteTransaction;
import java.util.HashSet;
import java.util.Set;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.prevayler.Prevayler;

public class TransactionsTipoTeste {

    Prevayler prev3;

    /**
     * @throws Exception
     */
    public TransactionsTipoTeste() throws Exception {
        FactoryTipo novaFactoryTipo = new FactoryTipo();
        prev3 = novaFactoryTipo.prevayler3;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void TesteCriaTipo() {
        boolean salvo = true;
        Set<Atributo> atributos = new HashSet<>();
        atributos.add(new Atributo("NomeAtributo", "DescricaoAtributo", 10));
        try {
            prev3.execute(new TipoCreateTransaction("idTipo01", "TipoNome01", "DescricaoTipo", atributos));
        } catch (Exception e1) {
            salvo = false;
        }
        assertTrue("Tipo não foi salvo", salvo);
    }

    public void TesteDeletaTipo() {
        try {
            prev3.execute(new TipoDeleteTransaction("idTipo01"));
        } catch (Exception e1) {
        }
        assertFalse(ListaTipo.listaTipo.size() > 0);
    }
}
