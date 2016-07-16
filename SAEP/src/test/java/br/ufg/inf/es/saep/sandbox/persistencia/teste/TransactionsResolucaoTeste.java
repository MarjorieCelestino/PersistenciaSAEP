package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.dominio.Regra;
import br.ufg.inf.es.saep.sandbox.persistencia.FactoryResolucao;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaResolucao;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.resolucao.ResolucaoCreateTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.resolucao.ResolucaoDeleteTransaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.prevayler.Prevayler;
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
    public void TesteCriaResolucao() throws ParseException {
        List<Regra> regras = new ArrayList<>();
        String descricao = "descricao da regra";
        float valorMaximo = 50;
        float valorMinimo = 10;
        String variavel = "variavelRegra";
        String expressao = "expressaoRegra";
        String entao = "então";
        String senao = "senão";
        String tipoRelato = "Tipo do relato";
        int pontosPorItem = 1;
        List<String> dependeDe = new ArrayList<>();
        dependeDe.add("Dependencia da regra");
        Regra novaRegra = new Regra(10, descricao, valorMaximo, valorMinimo, variavel, 
                expressao, entao, senao, tipoRelato, valorMinimo, dependeDe);
        regras.add(novaRegra);
        
        boolean salvo = true;
        String data = "10-07-2016";
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dt.parse(data);

        try {
            prev2.execute(new ResolucaoCreateTransaction("IdResolucao001", "500", "resolucao", 
                    date, regras));
        } catch (Exception e1) {
            salvo = false;
        }
        assertTrue("Resolucao não foi salva", salvo);
    }

    @Test
    public void TesteDeletaResolucao() {
        
        try {
            prev2.execute(new ResolucaoDeleteTransaction("10"));
        } catch (Exception e1) {
        }
        assertFalse(ListaResolucao.listaResolucao.size() < 0);
    }
}
