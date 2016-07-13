
package br.ufg.inf.es.saep.sandbox.persistencia.businessObject;

import br.ufg.inf.es.saep.sandbox.dominio.CampoExigidoNaoFornecido;
import br.ufg.inf.es.saep.sandbox.dominio.Resolucao;
import br.ufg.inf.es.saep.sandbox.dominio.ResolucaoRepository;
import br.ufg.inf.es.saep.sandbox.dominio.Tipo;
import java.io.Serializable;
import java.util.*;

/**
 * bo: business object Classe seriável composta pela classe Resolucao(bo)
 *
 * @author Marjorie
 */
public class ControlaResolucao implements Serializable, ResolucaoRepository {
    private static final long serialVersionUID = 1l;
    

   
    /**
     * Recupera a instância de {@code Resolucao} correspondente ao
     * identificador.
     *
     * @param id O identificador único da resolução a ser recuperada.
     *
     * @return {@code Resolucao} identificada por {@code id}. O retorno
     * {@code null} indica que não existe resolução com o identificador
     * fornecido.
     *
     * @see #persiste(Resolucao)
     */
    @Override
    public Resolucao byId(String id) {
        //percorre listaResolucao
        for (Iterator i = ListaResolucao.listaResolucao.iterator(); i.hasNext();) {
            Resolucao resolucaoAtual = (Resolucao) i.next();
            //identifica resolucao por id e retorna resolucaoAtual
            if (resolucaoAtual.getId().equals(id)) {
                return resolucaoAtual;
            }
        }
        return null;
    }

    /**
     * Persiste uma resolução.
     *
     * @throws CampoExigidoNaoFornecido Caso o identificador não seja fornecido.
     *
     * @param resolucao A resolução a ser persistida.
     *
     * @return O identificador único da resolução, conforme fornecido em
     * propriedade do objeto fornecido. Observe que o método retorna
     * {@code null} para indicar que a operação não foi realizada de forma
     * satisfatória, possivelmente por já existir resolução com identificador
     * semelhante.
     *
     * @see #byId(String)
     * @see #remove(String)
     */
    @Override
    public String persiste(Resolucao resolucao) {
        //percorre listaResolucao
        for (Iterator i = ListaResolucao.listaResolucao.iterator(); i.hasNext();) {
            Resolucao resolucaoAtual = (Resolucao) i.next();
            //compara id da resolução à ser adicionada com as já armazenadas na listaResolucao
            if (resolucao.getId().equals(resolucaoAtual.getId())) {
                //caso não encontre o id da resolucao
                throw new CampoExigidoNaoFornecido("Identificador nao fornecido.");
                //adiciona parecer a listaParecer e retorna id 
            } else {
                ListaResolucao.listaResolucao.add(resolucao);
                return resolucao.getId();
            }
        }
        return null;
    }

    /**
     * Remove a resolução com o identificado fornecido.
     *
     * @see #persiste(Resolucao)
     *
     * @param identificador O identificador único da resolução a ser removida.
     *
     * @return O valor {@code true} se a operação foi executada de forma
     * satisfatória e {@code false}, caso contrário.
     */
    @Override
    public boolean remove(String identificador) {
        //percorre listaResolucao
        for (Iterator i = ListaResolucao.listaResolucao.iterator(); i.hasNext();) {
            Resolucao resolucaoAtual = (Resolucao) i.next();
            //remove resolucao e retorna true  
            if (resolucaoAtual.getId().equals(identificador)) {
                i.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Recupera a lista dos identificadores das resoluções disponíveis.
     *
     * @return Identificadores das resoluções disponíveis.
     */
    @Override
    public List<String> resolucoes() {
        //Cria lista de identificadores de resoluções
        List resolucoesIds = new ArrayList();
        String idResolucao;
        //percorre a lista de resoluções
        for (Iterator i = ListaResolucao.listaResolucao.iterator(); i.hasNext();) {
            Resolucao resolucaoAtual = (Resolucao) i.next();
            //salva identificadores de cada resolução armazenada
            idResolucao = resolucaoAtual.getId();
            resolucoesIds.add(idResolucao);
        }
        //restorna lista de identificadores
        return resolucoesIds;
    }

    /**
     * Persiste o tipo fornecido.
     *
     * @param tipo O objeto a ser persistido.
     */
    @Override
    public void persisteTipo(Tipo tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Remove o tipo.
     *
     *
     * @param string
     * @param codigo O identificador do tipo a ser removido.
     */
    @Override
    public void removeTipo(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Recupera o tipo com o código fornecido.
     *
     * @param codigo O código único do tipo.
     *
     * @return A instância de {@link Tipo} cujo código único é fornecido.
     * Retorna {@code null} caso não exista tipo com o código indicado.
     */
    @Override
    public Tipo tipoPeloCodigo(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Recupera a lista de tipos cujos nomes são similares àquele fornecido. Um
     * nome é similar àquele do tipo caso contenha o argumento fornecido. Por
     * exemplo, para o nome "casa" temos que "asa" é similar.
     *
     * Um nome é dito similar se contém a sequência indicada.
     *
     * @param string
     * @param nome Sequência que será empregada para localizar tipos por nome.
     *
     * @return A coleção de tipos cujos nomes satisfazem um padrão de semelhança
     * com a sequência indicada.
     */
    @Override
    public List<Tipo> tiposPeloNome(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
