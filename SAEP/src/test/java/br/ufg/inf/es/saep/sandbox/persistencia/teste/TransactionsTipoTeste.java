package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.dominio.Atributo;
import br.ufg.inf.es.saep.sandbox.dominio.Tipo;
import br.ufg.inf.es.saep.sandbox.persistencia.FactoryTipo;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ControlaResolucao;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.tipo.TipoCreateTransaction;
import java.util.HashSet;
import java.util.Set;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.prevayler.Prevayler;

public class TransactionsTipoTeste {

    Prevayler prev3;
    ControlaResolucao control;

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
    public void persisteRecuperaTipo() {
        Atributo a = new Atributo("a", "atributo", Atributo.REAL);
        Set<Atributo> atributos = new HashSet<>(1);
        atributos.add(a);
        Tipo tipo = new Tipo("id", "t", "tipo", atributos);
        prev3.execute(new TipoCreateTransaction("id", "t", "tipo", atributos));
        Tipo recuperado = control.tipoPeloCodigo("id");
        assertEquals(tipo, recuperado);
    }
    
    @Test
    public void recuperaTiposPorSemelhancaDeNome() {
        Atributo a = new Atributo("alcalina", "atributo", Atributo.REAL);

        Set<Atributo> atributos = new HashSet<>(1);
        atributos.add(a);

        Tipo t1 = new Tipo("t1", "alcalina", "tipo", atributos);

        prev3.execute(new TipoCreateTransaction("t1", "alcalina", "tipo", atributos));

        // "alcalina" e "cristalina"
        assertEquals(2, control.tiposPeloNome("lina").size());
    }
}
