
package br.ufg.inf.es.saep.sandbox.persistencia.teste;

import br.ufg.inf.es.saep.sandbox.dominio.IdentificadorExistente;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import java.util.*;

/**
 * bo: business object Classe seriável composta pela classe Parecer(bo)
 *
 * @author Marjorie
 */
public class ControlaParecer {

    
    public void persisteParecer(ParecerSeriavel parecer) {
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


}
