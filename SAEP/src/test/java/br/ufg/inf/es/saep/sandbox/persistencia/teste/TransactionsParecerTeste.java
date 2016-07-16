package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.dominio.Avaliavel;
import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Pontuacao;
import br.ufg.inf.es.saep.sandbox.dominio.Relato;
import br.ufg.inf.es.saep.sandbox.dominio.Valor;
import br.ufg.inf.es.saep.sandbox.persistencia.FactoryParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerChangeAddNotaTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerChangeFundamentacaoTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerCreateTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerDeleteTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.radoc.RadocCreateTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.radoc.RadocDeleteTransaction;
import java.util.*;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.prevayler.Prevayler;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TransactionsParecerTeste {

    Prevayler prev;

    /**
     * @throws Exception
     */
    public TransactionsParecerTeste() throws Exception {
        FactoryParecer novaFactory = new FactoryParecer();
        prev = novaFactory.prevayler;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void TesteAdiconaParecer() {
        boolean salvo = true;
        try {
            prev.execute(new ParecerCreateTransaction("01", "IdResolucao20", ConstrutorBusinessObjects.geraRadocId(),
                    ConstrutorBusinessObjects.geraPontuacao(), "Fundamentacao teste ", ConstrutorBusinessObjects.geraNotas("100")));
        } catch (Exception e1) {
            salvo = false;
        }
        assertTrue("Parecer não foi salvo", salvo);
    }

    @Test
    public void TesteAlterarNota() {
        boolean notaAlterada = true;
        Valor valor = new Valor("50");
        Avaliavel original = new Pontuacao("50", valor);
        Valor valorBoole = new Valor(true);
        Map<String, Valor> map = new HashMap<>();
        map.put("Chave", valorBoole);
        Avaliavel destino = new Relato("50", map);
        Nota novaNota = new Nota(original, destino, "descrição da nota");

        try {
            prev.execute(new ParecerChangeAddNotaTransaction("01", novaNota));
        } catch (Exception e1) {
            notaAlterada = false;
        }
        assertTrue("Nota não foi alterada", notaAlterada);
    }

    @Test
    public void TesteAlteraFundamentacao() {
        boolean fundamentacaoAlterada = true;
        try {
            prev.execute(new ParecerChangeFundamentacaoTransaction("01", "FundamentacaoAlterada"));
        } catch (Exception e1) {
            fundamentacaoAlterada = false;
        }
        assertTrue("Fundamentacao não foi alterada", fundamentacaoAlterada);
    }

    @Test
    public void TesteCriaRadoc() {
        boolean radocAdicionado = true;
        List<Relato> relatos = new ArrayList<>();
        Map<String, Valor> valores = new HashMap<>();
        String tipoValor = "TipoValor1";
        Valor valor = new Valor(2);
        valores.put(tipoValor, valor);
        Relato relato = new Relato("TipoRelato02", valores);
        relatos.add(relato);
        try {
            prev.execute(new RadocCreateTransaction("01", "RadocId25", 2016, relatos));
        } catch (Exception e1) {
            radocAdicionado = false;
        }
        assertTrue("Radoc não foi adicionado", radocAdicionado);
    }

    @Test
    public void TesteDeletaRadoc() {
        boolean radocRemovido = true;
        try {
            prev.execute(new RadocDeleteTransaction("01", "RadocId25"));
        } catch (Exception e1) {
            radocRemovido = false;
        }
        assertTrue("Radoc não foi removido", radocRemovido);
    }

    @Test
    public void TesteDeletaParecer() {
        try {
            prev.execute(new ParecerDeleteTransaction("01"));
        } catch (Exception e1) {
        }
        assertFalse(ListaParecer.listaParecer.size() > 0);
    }
}
