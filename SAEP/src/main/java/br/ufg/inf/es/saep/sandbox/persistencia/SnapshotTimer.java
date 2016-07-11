package br.ufg.inf.es.saep.sandbox.persistencia;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.prevayler.Prevayler;

/**
 * Thread para snapshots de 1 em 1 hora
 * Evita a re-execução dos logs na inicialização do sisema
 * @author marjorie.goncalves
 */
public class SnapshotTimer extends Thread {
     Prevayler prevayler;  
  
    public SnapshotTimer(Prevayler prevayler) {  
        this.prevayler = prevayler;  
        this.setDaemon(true);  
    }  
  
     @Override
    public void run() {  
        super.run();  
  
        while (true) {  
            try {  
                Thread.sleep(1000 * 60 * 60); //1 hora  
                prevayler.takeSnapshot();  
                System.out.println("Snapshot disparado as " + new java.util.Date() + "...");      
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            } catch (Exception ex) {
                Logger.getLogger(SnapshotTimer.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }  
    }  
}