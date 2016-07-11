
package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.Pontuacao;
import br.ufg.inf.es.saep.sandbox.persistencia.SnapshotTimer;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerChangeAddNotaTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerCreateTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerDeleteTransaction;
import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import java.util.*;

/**
 * Classe com o método main() - Utiliza o padrão de projeto Factory para criar
 * objetos necessários para o Prevayler funcionar, indicando que as classes
 *
 * @author Marjorie
 */
public class Main {

    static Prevayler prevayler;

    public static void main(String[] args) throws Exception {
               
        System.out.println("Iniciando Prevayler...");  
        //configura e cria sistema prevalente para Listaparecer
        PrevaylerFactory factory = new PrevaylerFactory();  
        factory.configurePrevalenceDirectory("PARECER");  
        factory.configurePrevalentSystem(new ListaParecer());  
        prevayler = factory.create(); 
        //chama thread responsável por snapshots 
        new SnapshotTimer(prevayler).start(); 
        
        
        Scanner scan = new Scanner(System.in);

        List<String> radoc = new ArrayList();
        radoc.add("123");
        List<Pontuacao> pontos = new ArrayList();
        List<Nota> notas = new ArrayList();
        //Criado nvoo parecer de teste
        Parecer novoParecer = new Parecer("234", "resolucaoId", radoc , pontos, "fundamentations", notas);
        
        System.out.println("1. Adicionar novo Parecer.\n2. Adicionar nova nota.\nRemover Parecer.");
        int op = scan.nextInt();
        
        switch(op){
            case 1:
                    try{
                    prevayler.execute(new ParecerCreateTransaction(novoParecer.getId()));
                    }catch (Exception e1) {  
                           e1.printStackTrace();  
                        }  
                    System.out.println("Pessoa armazenada.");
            break;
    }
 
    }
}
