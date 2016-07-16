package br.ufg.inf.es.saep.sandbox.persistencia.businessObject;

import br.ufg.inf.es.saep.sandbox.dominio.Tipo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe serializável que manipula os métodos responsáveis pelas transactions
 * referentes ao objeto tipo
 */
public class ListaTipo implements Serializable {

    private static final long serialVersionUID = 1l;

    /**
     * lista para armazenamento dos tipos
     */
    public static List<Tipo> listaTipo = new ArrayList<>();

    ControlaResolucao control;

    /**
     * @param tipo
     */
    public void addTipo(Tipo tipo) {
        control.persisteTipo(tipo);
    }

    /**
     * @param codigo
     */
    public void removeTipo(String codigo) {
        control.removeTipo(codigo);
    }

    /**
     * @param codigo
     * @return tipo encrontrado pelo código
     */
    public Tipo getTipo(String codigo) {
        Tipo tipoEncontrado = control.tipoPeloCodigo(codigo);
        return tipoEncontrado;
    }
}
