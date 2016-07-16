package RepositoryTestSuite;

import br.ufg.inf.es.saep.sandbox.persistencia.teste.TransactionsResolucaoTeste;
import br.ufg.inf.es.saep.sandbox.persistencia.teste.TransactionsParecerTeste;
import br.ufg.inf.es.saep.sandbox.persistencia.teste.TransactionsTipoTeste;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TransactionsParecerTeste.class,
    TransactionsResolucaoTeste.class,
    TransactionsTipoTeste.class})

public class RepositoryTestSuite {

}
