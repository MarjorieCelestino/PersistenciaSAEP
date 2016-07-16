import br.ufg.inf.es.saep.sandbox.dominio.Avaliavel;
import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Pontuacao;
import br.ufg.inf.es.saep.sandbox.dominio.Regra;
import br.ufg.inf.es.saep.sandbox.dominio.Relato;
import br.ufg.inf.es.saep.sandbox.dominio.Valor;
import java.util.*;

/**
 * Classe para criação dos business objects utilizados para teste
 */
public class ConstrutorBusinessObjects {

    /**
     * @return lista de id de radocs
     */
    public static List<String> geraRadocId() {
        List<String> radocIds = new ArrayList();
        radocIds.add("1");
        radocIds.add("2");
        radocIds.add("3");

        return radocIds;
    }

    /**
     * @return lista de pontuacao
     */
    public static List<Pontuacao> geraPontuacao() {
        List<Pontuacao> pontuacaoTeste = new ArrayList();
        Valor valor = new Valor("42");
        Valor valor2 = new Valor("36");
        Pontuacao pontuacoes = new Pontuacao("NomePontuacao1", valor);
        Pontuacao pontuacoes2 = new Pontuacao("NomePontuacao2", valor2);
        pontuacaoTeste.add(pontuacoes);
        pontuacaoTeste.add(pontuacoes2);
        return pontuacaoTeste;
    }

    /**
     * @param nota
     * @return lista de notas
     */
    public static List<Nota> geraNotas(String nota) {
        List<Nota> notasTeste = new ArrayList();

        Valor valor = new Valor(nota);
        Avaliavel original = new Pontuacao(nota, valor);
        Valor valorBoole = new Valor(true);
        Map<String, Valor> map = new HashMap<>();
        map.put("Chave", valorBoole);
        Avaliavel destino = new Relato(nota, map);
        Nota novaNota = new Nota(original, destino, "descrição da nota");
        notasTeste.add(novaNota);
        return notasTeste;
    }
}