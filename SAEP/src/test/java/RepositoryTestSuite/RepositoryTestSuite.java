package RepositoryTestSuite;

import br.ufg.inf.es.saep.sandbox.persistencia.teste.TransactionResolucaoTeste;
import br.ufg.inf.es.saep.sandbox.persistencia.teste.TransactionsParecerTeste;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TransactionsParecerTeste.class,
    TransactionResolucaoTeste.class})

public class RepositoryTestSuite {
    
}
