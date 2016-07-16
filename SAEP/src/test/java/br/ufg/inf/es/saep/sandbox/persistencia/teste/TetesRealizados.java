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
        Tipo tipo = new Tipo("id", "nomeTipo", "descricao", atributos);
        FactoryTipo.prevayler3.execute(new TipoCreateTransaction("id", "nomeTipo", "descricao", atributos));
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
        List radocIds = ConstrutorBusinessObjects.geraRadocId();
        List pontuacao = ConstrutorBusinessObjects.geraPontuacao();
        List notas = ConstrutorBusinessObjects.geraNotas("100");
        Parecer novoParecer = new Parecer("50", "IdResolucao20", radocIds,
                    pontuacao, "Fundamentacao teste ", notas);
        try {
            FactoryParecer.prevaylerParecer.execute(new ParecerCreateTransaction("50", "IdResolucao20", radocIds,
                    pontuacao, "Fundamentacao teste ", notas));
        } catch (Exception e1) {
        }
        Parecer parecerRecuperado = controlP.byId("50");
        assertEquals(novoParecer, parecerRecuperado);
    }
    
    @Test
    public void alteraNota() {
        boolean notaAdicionada = false;
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
        if((controlP.byId("50").getNotas().size()) > 1){
        notaAdicionada = true;
        }
        
        assertTrue("Nota não foi alterada", notaAdicionada);
    }
    
    @Test
    public void persisteResolucao() throws ParseException {
        List<Regra> regras = new ArrayList<>();
        int tipo = 3;
        String descricao = "descricao";
        float valorMaximo = 10;
        float valorMinimo = 0;
        String variavel = "variavel";
        String expressao = "expressao";
        String entao = "então";
        String senao = "senão";
        String tipoRelato = "relatoTipo";
        int pontosPorItem = 1;
        List<String> dependeDe = new ArrayList<>();
        dependeDe.add("Dependencia");
        regras.add(new Regra(tipo, descricao, valorMaximo, valorMinimo, variavel, expressao, entao, senao, tipoRelato, valorMinimo, dependeDe));
        
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
