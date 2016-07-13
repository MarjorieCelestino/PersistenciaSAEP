package br.ufg.inf.es.saep.sandbox.persistencia.businessObject;

import br.ufg.inf.es.saep.sandbox.dominio.Avaliavel;
import br.ufg.inf.es.saep.sandbox.dominio.IdentificadorExistente;
import br.ufg.inf.es.saep.sandbox.dominio.IdentificadorDesconhecido;
import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.ParecerRepository;
import br.ufg.inf.es.saep.sandbox.dominio.Radoc;
import java.util.*;

/**
 * Obs.: Classe Parecer é um business object
 */
public class ControlaParecer implements ParecerRepository {

    /**
     * @return ListaParecer.listaParece
     */
    public List<Parecer> listaParecer() {
        return ListaParecer.listaParecer;
    }

    /**
     * @return ListaParecer.listaRadoc
     */
    public List<Radoc> listaRadoc() {
        return ListaParecer.listaRadoc;
    }

    /**
     * @param id
     * @param nota
     */
    @Override
    public void adicionaNota(String id, Nota nota) {
        for (Iterator i = listaParecer().iterator(); i.hasNext();) {
            Parecer parecerAtual = (Parecer) i.next();
            if (parecerAtual.getId().equals(id)) {
                parecerAtual.getNotas().add(nota);
            } else {
                throw new IdentificadorDesconhecido("Nenhum parecer existente com este identificador.");
            }
        }
    }

    /**
     * @param id
     * @param original
     */
    @Override
    public void removeNota(String id, Avaliavel original) {
        for (Iterator i = listaParecer().iterator(); i.hasNext();) {
            Parecer parecerAtual = (Parecer) i.next();
            if (parecerAtual.getId().equals(id)) {
            } else {
                throw new IdentificadorDesconhecido("Nenhum parecer existente com este identificador.");
            }
        }
    }

    /**
     * @param parecer
     */
    @Override
    public void persisteParecer(Parecer parecer) {
        for (int i = 0; i < listaParecer().size(); i++) {
            if (listaParecer().get(i).getId().equals(parecer.getId())) {
                ListaParecer.pode = false;
                throw new IdentificadorExistente("Identificador referente a outro parecer já armazenado.");
            } else {
                ListaParecer.pode = true;
            }
        }
    }

    /**
     * @param parecerId
     * @param fundamentacao
     */
    @Override
    public void atualizaFundamentacao(String parecerId, String fundamentacao) {
        for (Iterator i = listaParecer().iterator(); i.hasNext();) {
            Parecer parecerAtual = (Parecer) i.next();
            if (parecerAtual.getId().equals(parecerId)) {
                Parecer novoParecer = new Parecer(parecerAtual.getId(), parecerAtual.getResolucao(),
                        parecerAtual.getRadocs(), parecerAtual.getPontuacoes(), fundamentacao,
                        parecerAtual.getNotas());
                removeParecer(parecerId);
                persisteParecer(novoParecer);
            } else {
                throw new IdentificadorDesconhecido("Nenhum parecer existente com este identificador.");
            }
        }
    }

    /**
     * @param id
     * @return parecerAtual
     */
    @Override
    public Parecer byId(String id) {
        for (Iterator i = listaParecer().iterator(); i.hasNext();) {
            Parecer parecerAtual = (Parecer) i.next();
            if (parecerAtual.getId().equals(id)) {
                return parecerAtual;
            }
        }
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void removeParecer(String id) {
        for (Iterator i = listaParecer().iterator(); i.hasNext();) {
            Parecer parecerAtual = (Parecer) i.next();
            if (parecerAtual.getId().equals(id)) {
                i.remove();
            }
        }
    }

    /**
     * @param identificador
     * @return
     */
    @Override
    public Radoc radocById(String identificador) {
        for (Iterator i = listaRadoc().iterator(); i.hasNext();) {
            Radoc radocAtual = (Radoc) i.next();
            if (radocAtual.getId().equals(identificador)) {
                return radocAtual;
            }
        }
        return null;
    }

    /**
     * @param radoc
     * @return radoc.getId()
     */
    @Override
    public String persisteRadoc(Radoc radoc) {
        for (Iterator i = listaRadoc().iterator(); i.hasNext();) {
            Radoc radocAtual = (Radoc) i.next();
            if (radoc.getId().equals(radocAtual.getId())) {
                throw new IdentificadorExistente("Identificador referente a outro parecer já armazenado.");
            } else {
                listaRadoc().add(radoc);
                return radoc.getId();
            }
        }
        return null;
    }

    /**
     * @param identificador
     */
    @Override
    public void removeRadoc(String identificador) {
        for (Iterator i = listaRadoc().iterator(); i.hasNext();) {
            Radoc radocAtual = (Radoc) i.next();
            if (radocAtual.getId().equals(identificador)) {
                for (Iterator j = listaRadoc().iterator(); j.hasNext();) {
                    Parecer parecerAtual = (Parecer) j.next();
                    if (parecerAtual.getRadocs().equals(radocAtual)) {
                    } else {
                        listaRadoc().remove(radocAtual);
                    }
                }
            }
        }
    }
}
