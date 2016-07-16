package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.dominio.Atributo;
import br.ufg.inf.es.saep.sandbox.dominio.Avaliavel;
import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.Pontuacao;
import br.ufg.inf.es.saep.sandbox.dominio.Regra;
import br.ufg.inf.es.saep.sandbox.dominio.Relato;
import br.ufg.inf.es.saep.sandbox.dominio.Tipo;
import br.ufg.inf.es.saep.sandbox.dominio.Valor;
import br.ufg.inf.es.saep.sandbox.persistencia.FactoryParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.FactoryResolucao;
import br.ufg.inf.es.saep.sandbox.persistencia.FactoryTipo;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ControlaParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ControlaResolucao;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerChangeAddNotaTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerCreateTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.resolucao.ResolucaoCreateTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.tipo.TipoCreateTransaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.prevayler.Prevayler;

public class TetesRealizados {
    ControlaParecer controlP;
    ControlaResolucao controlR;
        
    public void main(String[] args) throws Exception{
        FactoryParecer factoryParecer = new FactoryParecer();
        FactoryResolucao factoryResolucao = new FactoryResolucao();
        FactoryTipo factoryTipo = new FactoryTipo();
        
        persisteRecuperaParecer();
        persisteRecuperaTipo();
        recuperaTiposPorSemelhancaDeNome();
        alteraNota();
        persisteResolucao();
    }
    
    @Test
    public void persisteRecuperaTipo() {
        Atributo a = new Atributo("a", "atributo", Atributo.REAL);
        Set<Atributo> atributos = new HashSet<>(1);
        atributos.add(a);
        Tipo tipo = new Tipo("id", "t", "tipo", atributos);
        FactoryTipo.prevayler3.execute(new TipoCreateTransaction("id", "t", "tipo", atributos));
        Tipo recuperado = controlR.tipoPeloCodigo("id");
        assertEquals(tipo, recuperado);
    }
    
    @Test
    public void recuperaTiposPorSemelhancaDeNome() {
        Atributo a = new Atributo("alcalina", "atributo", Atributo.REAL);

        Set<Atributo> atributos = new HashSet<>(1);
        atributos.add(a);

        Tipo t1 = new Tipo("t1", "alcalina", "tipo", atributos);

        FactoryTipo.prevayler3.execute(new TipoCreateTransaction("t1", "alcalina", "tipo", atributos));

        // "alcalina" e "cristalina"
        assertEquals(2, controlR.tiposPeloNome("lina").size());
    }
    
    @Test
    public void persisteRecuperaParecer() {
        Parecer novoParecer = new Parecer("50", "IdResolucao20", ConstrutorBusinessObjects.geraRadocId(),
                    ConstrutorBusinessObjects.geraPontuacao(), "Fundamentacao teste ", ConstrutorBusinessObjects.geraNotas("100"));
        try {
            FactoryParecer.prevaylerParecer.execute(new ParecerCreateTransaction("50", "IdResolucao20", ConstrutorBusinessObjects.geraRadocId(),
                    ConstrutorBusinessObjects.geraPontuacao(), "Fundamentacao teste ", ConstrutorBusinessObjects.geraNotas("100")));
        } catch (Exception e1) {
        }
        Parecer parecerRecuperado = controlP.byId("50");
        assertEquals(novoParecer, parecerRecuperado);
    }
    
    @Test
    public void alteraNota() {
        boolean notaAdicionada = false;
        int tamanho = controlP.byId("50").getNotas().size();
        Valor valor = new Valor("50");
        Avaliavel original = new Pontuacao("50", valor);
        Valor valorBoole = new Valor(true);
        Map<String, Valor> map = new HashMap<>();
        map.put("Chave", valorBoole);
        Avaliavel destino = new Relato("50", map);
        Nota novaNota = new Nota(original, destino, "descrição da nota");
        
        try {
            FactoryParecer.prevaylerParecer.execute(new ParecerChangeAddNotaTransaction("50", novaNota));
        } catch (Exception e1) {
        }
        if(tamanho < (controlP.byId("50").getNotas().size())){
        notaAdicionada = true;
        }
        
        assertTrue("Nota não foi alterada", notaAdicionada);
    }
    
    @Test
    public void persisteResolucao() throws ParseException {
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
            FactoryResolucao.prevayler2.execute(new ResolucaoCreateTransaction("IdResolucao001", "500", "resolucao", 
                    date, regras));
        } catch (Exception e1) {
            salvo = false;
        }
        assertTrue("Resolucao não foi salva", salvo);
    }
}
