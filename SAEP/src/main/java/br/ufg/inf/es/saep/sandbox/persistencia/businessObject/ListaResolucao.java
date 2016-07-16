package br.ufg.inf.es.saep.sandbox.persistencia.businessObject;

import br.ufg.inf.es.saep.sandbox.dominio.Resolucao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe serializável que manipula os métodos responsáveis pelas transactions
 * referentes ao objeto resolucao
 */
public class ListaResolucao implements Serializable {

    private static final long serialVersionUID = 1l;

    public static List<Resolucao> listaResolucao = new ArrayList<Resolucao>();

    ControlaResolucao control;

    /**
     * Adiciona uma nova reoslucao
     *
     * @param novaResolucao
     * @return resolucao adicionada
     */
    public Resolucao addResolucao(Resolucao novaResolucao) {
        control.persiste(novaResolucao);
        return novaResolucao;
    }

    /**
     * Deleta a resolução
     *
     * @param id
     */
    public void deletaResolucao(String id) {
        control.remove(id);
    }
}
