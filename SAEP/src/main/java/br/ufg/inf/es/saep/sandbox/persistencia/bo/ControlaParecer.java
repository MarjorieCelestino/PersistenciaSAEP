
package br.ufg.inf.es.saep.sandbox.persistencia.bo;

import br.ufg.inf.es.saep.sandbox.dominio.Avaliavel;
import br.ufg.inf.es.saep.sandbox.dominio.IdentificadorExistente;
import br.ufg.inf.es.saep.sandbox.dominio.IdentificadorDesconhecido;
import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.ParecerRepository;
import br.ufg.inf.es.saep.sandbox.dominio.Radoc;
import java.util.*;

/**
 * bo: business object Classe seriável composta pela classe Parecer(bo)
 *
 * @author Marjorie
 */
public class ControlaParecer implements ParecerRepository {

    /**
     * Adiciona nota ao parecer.
     *
     * @throws IdentificadorDesconhecido Caso o identificador fornecido não
     * identifique um parecer existente.
     * @param id O identificador único do parecer.
     * @param nota A alteração a ser acrescentada ao pareder.
     */
    @Override
    public void adicionaNota(String id, Nota nota) {
        //percorre listaParecer
        for (Iterator i = ListaParecer.listaParecer.iterator(); i.hasNext();) {
            Parecer parecerAtual = (Parecer) i.next();
            //compara id do parecer com o fornecido
            if (parecerAtual.getId().equals(id)) {
                //adiciona nota a lista de notas do parecer identificado
                parecerAtual.getNotas().add(nota);
            } else {
                throw new IdentificadorDesconhecido("Nenhum parecer existente com este identificador.");
            }
        }
    }

    /**
     * TO-DO Remove a nota cujo item {@link Avaliavel} original é fornedido.
     *
     * @param id O identificador único do parecer.
     * @param original Instância de {@link Avaliavel} que participa da
     * {@link Nota} a ser removida como origem.
     *
     */
    @Override
    public void removeNota(String id, Avaliavel original) {
        //percorre listaParecer
        for (Iterator i = listaParecer.iterator(); i.hasNext();) {
            Parecer parecerAtual = (Parecer) i.next();
            //compara id do parecer com o fornecido
            if (parecerAtual.getId().equals(id)) {
                //parecerAtual.getNotas().remove();
                //original.get(id);
            } else {
                throw new IdentificadorDesconhecido("Nenhum parecer existente com este identificador.");
            }
        }
    }

    /**
     * Acrescenta o parecer ao repositório.
     *
     * @throws IdentificadorExistente Caso o identificador seja empregado por
     * parecer existente (já persistido).
     * @param parecer O parecer a ser persistido.
     */
    @Override
    public void persisteParecer(Parecer parecer) {
            for (int i = 0; i < ListaParecer.listaParecer.size(); i++) {
                //compara id do parecer à ser adicionado com os já armazenados na listaParecer
                 if(ListaParecer.listaParecer.get(i).getId().equals(parecer.getId())){
                    ListaParecer.pode = false;
                    throw new IdentificadorExistente("Identificador referente a outro parecer já armazenado.");
                } else {
                    ListaParecer.pode = true;
                }
            }
    }

    /**
     * Altera fundamentação, e persiste parecer atualizado.
     *
     * @param parecerId
     * @param fundamentacao
     */
    @Override
    public void atualizaFundamentacao(String parecerId, String fundamentacao) {
        //percorre listaParecer
        for (Iterator i = listaParecer.iterator(); i.hasNext();) {
            Parecer parecerAtual = (Parecer) i.next();
            //compara id do parecer com o fornecido
            if (parecerAtual.getId().equals(parecerId)) {
                Parecer novoParecer = new Parecer(parecerAtual.getId(), parecerAtual.getResolucao(),
                        parecerAtual.getRadocs(), parecerAtual.getPontuacoes(), fundamentacao,
                        parecerAtual.getNotas());
                //apaga parecerAtual
                removeParecer(parecerId);
                //armazena novo parecer
                persisteParecer(novoParecer);
            } else {
                throw new IdentificadorDesconhecido("Nenhum parecer existente com este identificador.");
            }
        }
    }

    /**
     * Recupera o parecer pelo identificador.
     *
     * @param id O identificador do parecer.
     * @return O parecer recuperado ou o valor {@code null}, caso o
     * identificador não defina um parecer.
     */
    @Override
    public Parecer byId(String id) {
        //percorre listaParecer
        for (Iterator i = ListaParecer.listaParecer.iterator(); i.hasNext();) {
            Parecer parecerAtual = (Parecer) i.next();
            //identifica parecer por id e retorna parecerAtual
            if (parecerAtual.getId().equals(id)) {
                return parecerAtual;
            }
        }
        return null;
    }

    /**
     * Remove o parecer.
     *
     * @param id O identificador único do parecer.
     */
    @Override
    public void removeParecer(String id) {
        //percorre listaParecer
        for (Iterator i = ListaParecer.listaParecer.iterator(); i.hasNext();) {
            Parecer parecerAtual = (Parecer) i.next();
            //remove parecer  
            if (parecerAtual.getId().equals(id)) {
                i.remove();
                System.out.println("Parecer removido.");
            }
        }
    }

    /**
     * Recupera o RADOC identificado pelo argumento.
     *
     * @param identificador O identificador único do RADOC.
     * @return O {@code Radoc} correspondente ao identificador fornecido.
     */
    @Override
    public Radoc radocById(String identificador) {
        //percorre listaRadoc
        for (Iterator i = listaRadoc.iterator(); i.hasNext();) {
            Radoc radocAtual = (Radoc) i.next();
            //identifica radoc por id e retorna radocAtual
            if (radocAtual.getId().equals(identificador)) {
                return radocAtual;
            }
        }
        return null;
    }

    /**
     * Armazena radoc Conjunto de relatos de atividades e produtos associados a
     * um docente.
     *
     * @throws IdentificadorExistente Caso o identificador do objeto a ser
     * persistido seja empregado por RADOC existente.
     * @param radoc O conjunto de relatos a ser persistido.
     * @return O identificador único do RADOC.
     */
    @Override
    public String persisteRadoc(Radoc radoc) {
        //percorre listaRadoc
        for (Iterator i = listaRadoc.iterator(); i.hasNext();) {
            Radoc radocAtual = (Radoc) i.next();
            //compara id do radoc à ser adicionado com os já armazenados na listaRadoc
            if (radoc.getId().equals(radocAtual.getId())) {
                throw new IdentificadorExistente("Identificador referente a outro parecer já armazenado.");
            } else {
                //adiciona radoc a listaRadoc e retorna identificador do mesmo
                this.listaRadoc.add(radoc);
                System.out.println("Radoc armazenado.");
                return radoc.getId();
            }
        }
        return null;
    }

    /**
     * Remove o RADOC.
     *
     * @param identificador O identificador do RADOC.
     */
    @Override
    public void removeRadoc(String identificador) {
        //percorre listaRadoc
        for (Iterator i = listaRadoc.iterator(); i.hasNext();) {
            Radoc radocAtual = (Radoc) i.next();
            //compara id do radoc à ser adicionado com os já armazenados na listaRadoc
            if (radocAtual.getId().equals(identificador)) {
                //Não é permitida a remoção de um RADOC para o qual há pelo menos um parecer referenciando-o. 
                // Percorre listaParecer e verifica se o radocAtual é referenciado por algum parecer.
                for (Iterator j = listaParecer.iterator(); j.hasNext();) {
                    Parecer parecerAtual = (Parecer) j.next();
                    if (parecerAtual.getRadocs().equals(radocAtual)) {
                        System.out.println("Radoc relacionado a um parecer.");
                    } else {
                        //deleta radocAtual
                        this.listaRadoc.remove(radocAtual);
                        System.out.println("Radoc removido.");
                    }
                }
            }
        }
    }
    
    //Métodos criados
    public void imprimeParecer(){
        for (int i = 0; i < listaParecer.size(); i++) {
                    System.out.println(listaParecer.get(i).getId() + "\t"
                            + listaParecer.get(i).getResolucao() + "\t"
                            + listaParecer.get(i).getRadocs() + "\t"
                            + listaParecer.get(i).getPontuacoes() + "\t"
                            + listaParecer.get(i).getFundamentacao() + "\t"
                            + listaParecer.get(i).getNotas());
        }
    }
}
