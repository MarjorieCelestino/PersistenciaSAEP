package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.persistencia.FactoryResolucao;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaResolucao;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.resolucao.ResolucaoCreateTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.resolucao.ResolucaoDeleteTransaction;
import java.util.Date;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.prevayler.Prevayler;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TransactionsResolucaoTeste {

    Prevayler prev2;

    /**
     * @throws Exception
     */
    public TransactionsResolucaoTeste() throws Exception {
        FactoryResolucao novaFactoryRes = new FactoryResolucao();
        prev2 = novaFactoryRes.prevayler2;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void TesteCriaResolucao() {
        boolean salvo = true;
        Date date = new Date("10-04-2016");
        try {
            prev2.execute(new ResolucaoCreateTransaction("idResolucao32", "500", "resolucao", date, ConstrutorBusinessObjects.geraRegra()));
        } catch (Exception e1) {
            salvo = false;
        }
        assertTrue("Resolucao não foi salva", salvo);
    }

    @Test
    public void TesteDeletaResolucao() {
        try {
            prev2.execute(new ResolucaoDeleteTransaction("idResolucao32"));
        } catch (Exception e1) {
        }
        assertFalse(ListaResolucao.listaResolucao.size() > 0);
    }
}
