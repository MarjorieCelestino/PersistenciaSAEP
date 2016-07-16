package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.persistencia.FactoryParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerCreateTransaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.prevayler.Prevayler;

public class TransactionsParecerTeste  {
    BusinessObjects bo;
    Prevayler prev;
    
    
    public TransactionsParecerTeste(Prevayler prev) throws Exception{
        FactoryParecer novaFactory = new FactoryParecer();
                prev = novaFactory.prevayler;

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    
    public void TesteAdiconaParecer(){
         try {
                prev.execute(new ParecerCreateTransaction(bo.CriaParecer("10")));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
    }
}
