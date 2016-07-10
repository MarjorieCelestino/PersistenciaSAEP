/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia.bo;

import br.ufg.inf.es.saep.sandbox.dominio.Avaliavel;
import br.ufg.inf.es.saep.sandbox.dominio.IdentificadorExistente;
import br.ufg.inf.es.saep.sandbox.dominio.IdentificadorDesconhecido;
import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.ParecerRepository;
import br.ufg.inf.es.saep.sandbox.dominio.Radoc;
import java.io.Serializable;
import java.util.*;

/**
 * bo: business object
 * Classe seriável composta pela classe Parecer(bo)
 * @author Marjorie
 */
public class ListaParecer implements Serializable, ParecerRepository {
    //lista para armazenamento dos objetos Parecer
    private final List listaParecer = new ArrayList();
    
    public ListaParecer(){
        super();
    }
    
    /**
     * Adiciona nota ao parecer.
     *
     * @throws IdentificadorDesconhecido Caso o identificador
     * fornecido não identifique um parecer existente.
     *
     * @param id O identificador único do parecer.
     *
     * @param nota A alteração a ser acrescentada ao
     * pareder.
     */
    @Override
    public void adicionaNota(String id, Nota nota) {
        //percorre listaParecer
        for(Iterator i = listaParecer.iterator(); i.hasNext();){
            Parecer parecerAtual = (Parecer) i.next();
            //compara id do parecer com o fornecido
            if(parecerAtual.getId().equals(id)){
                //adiciona nota a lista de notas do parecer identificado
                parecerAtual.getNotas().add(nota);
            }else{
                throw new IdentificadorDesconhecido("Nenhum parecer existente com este identificador.");
            }
        }
    }
    
    /**
     * TO-DO
     * Remove a nota cujo item {@link Avaliavel} original é
     * fornedido.
     *
     * @param id O identificador único do parecer.
     * @param original Instância de {@link Avaliavel} que participa 
     * da {@link Nota} a ser removida como origem.
     *
     */
    @Override
    public void removeNota(String id, Avaliavel original) {
        //percorre listaParecer
        for(Iterator i = listaParecer.iterator(); i.hasNext();){
            Parecer parecerAtual = (Parecer) i.next();
            //compara id do parecer com o fornecido
            if(parecerAtual.getId().equals(id)){
                //parecerAtual.getNotas().remove();
                //original.get(id);
            }else{
                throw new IdentificadorDesconhecido("Nenhum parecer existente com este identificador.");
            }
        }
    }
    
    /**
     * Método para adicionar um novo parecer e persistir o mesmo.
     * @return novoParecer
     */
    public Parecer addParecer(){
        Parecer novoParecer = (ParecerSeriavel) new Parecer();
        persisteParecer(novoParecer);
        return novoParecer;
    } 
    /**
     * Acrescenta o parecer ao repositório.
     *
     * @throws IdentificadorExistente Caso o
     * identificador seja empregado por parecer
     * existente (já persistido).
     *
     * @param parecer O parecer a ser persistido.
     *
     */
    @Override
    public void persisteParecer(Parecer parecer) {
        //percorre listaParecer
        for(Iterator i = listaParecer.iterator(); i.hasNext();){
            Parecer parecerAtual = (Parecer) i.next();
            //compara id do parecer à ser adicionado com os já armazenados na listaParecer
            if(parecer.getId().equals(parecerAtual.getId())){
                throw new IdentificadorExistente("Identificador referente a outro parecer já armazenado.");
            //adiciona parecer a listaParecer
            }else{
                this.listaParecer.add(parecer);
                System.out.println("Parecer adicionado.");
            }
        }
    }
    
    /**
     * Altera a fundamentação do parecer.
     *
     * <p>Fundamentação é o texto propriamente dito do
     * parecer. Não confunda com as alterações de
     * valores (dados de relatos ou de pontuações).
     *
     * <p>Após a chamada a esse método, o parecer alterado
     * pode ser recuperado pelo método {@link #byId(String)}.
     * Observe que uma instância disponível antes dessa chamada
     * torna-se "inválida".
     *
     * @throws IdentificadorDesconhecido Caso o identificador
     * fornecido não identifique um parecer.
     *
     * @param parecerId O identificador único do parecer.
     * @param fundamentacao Novo texto da fundamentação do parecer.
     */
    @Override
    public void atualizaFundamentacao(String parecerId, String fundamentacao) {
        //percorre listaParecer
        for(Iterator i = listaParecer.iterator(); i.hasNext();){
            Parecer parecerAtual = (Parecer) i.next();
            //compara id do parecer com o fornecido
            if(parecerAtual.getId().equals(parecerId)){
                //adiciona nota a lista de notas do parecer identificado
                parecerAtual.getFundamentacao();
                //cria novo parecer com fundamentacao atualizada
                Parecer novoParecer = new Parecer(parecerAtual.getId(), parecerAtual.getResolucao(), 
                        parecerAtual.getRadocs(), parecerAtual.getPontuacoes(), fundamentacao, parecerAtual.getNotas());
                //apaga parecerAtual
                removeParecer(parecerId);
                //armazena novo parecer
                persisteParecer(novoParecer);
            }else{
                throw new IdentificadorDesconhecido("Nenhum parecer existente com este identificador.");
            }
        }
    }
    
    /**
     * Recupera o parecer pelo identificador.
     *
     * @param id O identificador do parecer.
     *
     * @return O parecer recuperado ou o valor {@code null},
     * caso o identificador não defina um parecer.
     */
    @Override
    public Parecer byId(String id) {
        //percorre listaParecer
        for(Iterator i = listaParecer.iterator(); i.hasNext();){
            Parecer parecerAtual = (Parecer) i.next();
            //identifica parecer por id e retorna parecerAtual
            if(parecerAtual.getId().equals(id)){
                return parecerAtual;
            }
        }
        return null;
    }
    
    /**
     * Remove o parecer.
     *
     * <p>Se o identificador fornecido é inválido
     * ou não correspondente a um parecer existente,
     * nenhuma situação excepcional é gerada.
     *
     * @param id O identificador único do parecer.
     */
    @Override
    public void removeParecer(String id) {
        //percorre listaParecer
        for(Iterator i = listaParecer.iterator(); i.hasNext();){
            Parecer parecerAtual = (Parecer) i.next();
            //remove parecer  
            if(parecerAtual.getId().equals(id)){
                i.remove();
                System.out.println("Parecer removido.");
            }
        }
    }
    
    /**
     * TO-DO
     * Recupera o RADOC identificado pelo argumento.
     *
     * @param identificador O identificador único do RADOC.
     *
     * @return O {@code Radoc} correspondente ao
     * identificador fornecido.
     */
    @Override
    public Radoc radocById(String identificador) {
       return null; 
    }
    
    
    /**
     * Conjunto de relatos de atividades e produtos
     * associados a um docente.
     *
     * <p>Um conjunto de relatos é extraído de fonte
     * externa de informação. Uma cópia é mantida pelo
     * SAEP para consistência de pareceres efetuados ao
     * longo do tempo. Convém ressaltar que informações
     * desses relatórios podem ser alteradas continuamente.
     *
     * @throws IdentificadorExistente Caso o identificador
     * do objeto a ser persistido seja empregado por
     * RADOC existente.
     *
     * @param radoc O conjunto de relatos a ser persistido.
     *
     * @return O identificador único do RADOC.
     */
    @Override
    public String persisteRadoc(Radoc radoc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Remove o RADOC.
     *
     * <p>Após essa operação o RADOC correspondente não
     * estará disponível para consulta.
     *
     * <p>Não é permitida a remoção de um RADOC para o qual
     * há pelo menos um parecer referenciando-o.
     *
     * @param identificador O identificador do RADOC.
     */
    @Override
    public void removeRadoc(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
