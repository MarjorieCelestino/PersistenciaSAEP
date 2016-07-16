package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.dominio.Atributo;
import br.ufg.inf.es.saep.sandbox.dominio.Avaliavel;
import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Pontuacao;
import br.ufg.inf.es.saep.sandbox.dominio.Radoc;
import br.ufg.inf.es.saep.sandbox.dominio.Regra;
import br.ufg.inf.es.saep.sandbox.dominio.Relato;
import br.ufg.inf.es.saep.sandbox.dominio.Tipo;
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

    
    /**
     * @return lista de regras
     */
    public static List<Regra> geraRegra() {
        List<Regra> regras = new ArrayList<>();
        int tipo = 5;
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
        Regra novaRegra = new Regra(tipo, descricao, valorMaximo, valorMinimo, variavel, expressao, entao, senao, tipoRelato, valorMinimo, dependeDe);
        regras.add(novaRegra);
        return regras;
    }

    /**
     * @param id
     * @return radoc
     */
    public static Radoc geraRadoc(String id) {
        List<Relato> relatos = new ArrayList<>();
        Map<String, Valor> valores = new HashMap<>();
        String tipoValor = "TipoValor1";
        Valor valor = new Valor(2);
        valores.put(tipoValor, valor);
        Relato relato = new Relato("TipoRelato01", valores);
        relatos.add(relato);
        Radoc novoRadoc = new Radoc(id, 2015, relatos);

        return novoRadoc;
    }

    /**
     * @param id
     * @param nome
     * @return tipo
     */
    public static Tipo geraTipo(String id, String nome) {
        Set<Atributo> atributos = new HashSet<>();
        atributos.add(new Atributo("NomeAtributo", "DescricaoAtributo", 10));
        Tipo tipoTeste = new Tipo(id, nome, "DescricaoTipo", atributos);
        return tipoTeste;
    }
}
