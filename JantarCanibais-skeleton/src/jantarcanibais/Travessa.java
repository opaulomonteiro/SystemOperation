package jantarcanibais;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Travessa {

    int porcoes;
    int totalDePorcoes;
    Semaphore mutex1;
    Semaphore mutex2;

    Travessa(int M) {
        this.porcoes = M;
        this.totalDePorcoes = M;
        this.mutex1 = new Semaphore(1);
        this.mutex2 = new Semaphore(0);
    }

    /* Chamada pelos canibais. 
       Retorna true se conseguiu se servir, senão retorna falso. 
     */
    public boolean seserve() {
        System.out.println("Canibal se servindo");
        boolean retorno = false;
        try {
            mutex2.acquire();
            if (porcoes != 0) {
                porcoes--;
                System.out.println("Numero de porcoes: " + porcoes);                
                retorno = true;
            } else {     
                System.out.println("Numero de porcoes: " + porcoes);   
                mutex1.release();
                retorno = false;
            }            
            Thread.sleep(1000);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Travessa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /* Chamado pelo cozinheiro. */
    public void enchetravessa() {
        System.out.println("Cozinheiro enchendo a travessa para " + totalDePorcoes + " porcoes");
        try {
            mutex1.acquire();
            this.porcoes = this.totalDePorcoes;
            Thread.sleep(1000);
            mutex2.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Travessa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
