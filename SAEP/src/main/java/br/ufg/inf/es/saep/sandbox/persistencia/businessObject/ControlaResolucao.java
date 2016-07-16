package br.ufg.inf.es.saep.sandbox.persistencia.businessObject;

import br.ufg.inf.es.saep.sandbox.dominio.CampoExigidoNaoFornecido;
import br.ufg.inf.es.saep.sandbox.dominio.IdentificadorExistente;
import br.ufg.inf.es.saep.sandbox.dominio.Resolucao;
import br.ufg.inf.es.saep.sandbox.dominio.ResolucaoRepository;
import br.ufg.inf.es.saep.sandbox.dominio.ResolucaoUsaTipoException;
import br.ufg.inf.es.saep.sandbox.dominio.Tipo;
import java.util.*;

/**
 * Obs.: Resolucao e Tipo são business objects.
 */
public class ControlaResolucao implements ResolucaoRepository {

    /**
     * @return lista de resolução
     */
    public List<Resolucao> listaResolucao() {
        return ListaResolucao.listaResolucao;
    }

    /**
     * @return lista de tipo
     */
    public List<Tipo> listaTipo() {
        return ListaTipo.listaTipo;
    }

    /**
     * @param id O identificador único da resolução a ser recuperada.
     *
     * @return {@code Resolucao}
     */
    @Override
    public Resolucao byId(String id) {
        for (Iterator i = listaResolucao().iterator(); i.hasNext();) {
            Resolucao resolucaoAtual = (Resolucao) i.next();
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
     * @return O identificador único da resolução
     */
    @Override
    public String persiste(Resolucao resolucao) {
        for (Iterator i = listaResolucao().iterator(); i.hasNext();) {
            Resolucao resolucaoAtual = (Resolucao) i.next();
            if (resolucao.getId().equals(resolucaoAtual.getId())) {
                throw new CampoExigidoNaoFornecido("Identificador nao fornecido.");
            } else {
                listaResolucao().add(resolucao);
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
        for (Iterator i = listaResolucao().iterator(); i.hasNext();) {
            Resolucao resolucaoAtual = (Resolucao) i.next();
            if (resolucaoAtual.getId().equals(identificador)) {
                listaResolucao().remove(resolucaoAtual);
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
        List resolucoesIds = new ArrayList();
        String idResolucao;
        for (Iterator i = listaResolucao().iterator(); i.hasNext();) {
            Resolucao resolucaoAtual = (Resolucao) i.next();
            idResolucao = resolucaoAtual.getId();
            resolucoesIds.add(idResolucao);
        }
        return resolucoesIds;
    }

    /**
     * Persiste o tipo fornecido.
     *
     * @param tipo O objeto a ser persistido.
     */
    @Override
    public void persisteTipo(Tipo tipo) {
        for (Iterator i = listaTipo().iterator(); i.hasNext();) {
            Tipo tipoAtual = (Tipo) i.next();
            if (tipo.getId().equals(tipoAtual.getId())) {
                throw new IdentificadorExistente("Identificador já existe.");
            } else {
                listaTipo().add(tipo);
            }
        }
    }

    /**
     * @param codigo
     */
    @Override
    public void removeTipo(String codigo) {
        for (Iterator i = listaTipo().iterator(); i.hasNext();) {
            Tipo tipoAtual = (Tipo) i.next();
            if (tipoAtual.getId().equals(codigo)) {
                listaTipo().remove(tipoAtual);
            } else {
                throw new ResolucaoUsaTipoException("O tipo é empregado por pelo menos uma resolução.");
            }
        }
    }

    /**
     *
     * @param codigo
     * @return tipo com referente ao código fornecido
     */
    @Override
    public Tipo tipoPeloCodigo(String codigo) {
        for (Iterator i = listaTipo().iterator(); i.hasNext();) {
            Tipo tipoAtual = (Tipo) i.next();
            if (tipoAtual.getId().equals(codigo)) {
                return tipoAtual;
            }
        }
        return null;
    }

    /**
     *
     * @param nome
     * @return lista de tipos com o nome fornecido
     */
    @Override
    public List<Tipo> tiposPeloNome(String nome) {
        List<Tipo> tipoByName = new ArrayList();
        for (Iterator i = listaTipo().iterator(); i.hasNext();) {
            Tipo tipoAtual = (Tipo) i.next();
            if (tipoAtual.getNome().equals(nome)) {
                tipoByName.add(tipoAtual);

            }
        }
        return tipoByName;
    }
}
